# 출처 : 자바의정석 3RD Edition (도우출판) & 강의자료(이용교 강사님)
# 열거형(Enums)
## 열거형이란?
- 서로 관련된 상수를 편리하게 선언하기 위한 것.
- 상수를 정의할 때 유용하다.
- JDK 1.5부터 새로 추가된 내용.

```
C언어의 열거형
class Animal{
    static final int LION = 0;
    static final int TIGER = 1;
    static final int MONKEY = 2;
    static final int MOUSE = 3;

    static final int TWO = 0;
    static final int FOUR = 1;

    final int kind;
    final int legs;
}

Java의 열거형
class Animal {
    enum Kind { LION,TIGER,MONKRY,MOUSE;}
    enum Legs { TWO,FOUR;}

    final Kind kind;
    final Value value;
}
```
- 자바의 열거형은 **타입에 안전한 열거형**이라서 실제 값이 같아도 타입이 다르면 컴파일 에러가 발생하게 된다.

```
if(Animal.LION == Animal.TWO); // 타입 체크 X -> true 반환
if(Animal.Kind.LION == Animal.Legs.TWO) // 컴파일 에러, 값은 0으로 같지만 타입(Kind != Legs)이 다름.
```
- 더 중요한 것은 상수의 값이 바뀌면, 해당 상수를 참조하는 모든 소스를 다시 컴파일 해야하지만,
- 열거형 상수를 사용 시 기존의 소스를 다시 컴파일하지 않아도 된다.

## 열거형의 정의와 사용
- 정의
` enum 열거형 이름 {상수명1, 상수명2, ...; }`
```
enum Direction {EAST, SOUTH, WEST, NORTH}
```

- 사용
` 열거형 이름.상수명 `

```
class Unit{
    int x,y// 유닛의 위치
    Direction dir;//열거형을 멤버변수로 선언
    void init(){
        dir = Direction.EAST; // 유닛의 방향을 EAST로 초기화
    }
}
```

- 비교
    - == : 같다 여부로 비교.
    - 상수명1.compareTo(상수명2) : 왼쪽이 큼(양수), 오른쪽이 큼(음수), 같음(0)
        - <, > 와 같은 비교 연산자 사용 불가.

- switch 조건문 사용
    - ※주의사항 : 열거형의 이름은 적지않고 상수명만 적어야 한다.
```
void move(){
    switch(dir)
        case EAST : x++; break; // Direction.EAST라고 쓰면 안됨.
        case WEST : x--; break;
        case SOUTH : y++; break;
        case NORTH : y--; break;
}
```

### 모든 열거형의 조상 -java.lang.Enum
- 열거형은 내부적으로 Enum 클래스를 상속받는다.
- Enum 클래스 내부 정의 메서드
    - String name() : 열거형 상수의 이름을 문자열로 반환.
    - int ordinal() : 열거형 상수가 정의된 순서를 봔환.(0부터 시작)
        - 내부적인 순서.
    - T valueOf(String name) : 열거형 상수의 이름으로 문자열 상수에 대한 참조를 얻음.
    - T valueOf(Class enumType, String name) : 지정된 열거형에서 name과 일치한 상수를 반환.
    - [] vales() : 열거형의 모든 상수를 배열에 담아 반환.

## 열거형에 멤버 추가
- Enum 클래스에 정의된 ordinal() 메서드가 열거형 상수의 정의된 순서를 반환하지만, 이 값은 내부적
  용도로 사용하기 위해 정의된것이므로 상수의 값으로 사용하지 않는 것이 좋다.
- 따라서, 열거형 상수의 값이 불연속적인 경우에는 열거형 상수의 이름 옆에 ()괄호와 함께 적어주면 된다.

` enum Direction {EAST(1), SOUTH(5), WEST(-1), NORTH(9)} `

- 그리고 이렇게 지정된 값을 저장할 멤버 변수와 생성자를 새로 추가해줘야 한다.
```
enum Direction{
    EAST(1), SOUTH(5), WEST(-1), NORTH(9);

    private final int value;
    Direction(int value){ this.value = value; }
    
    public int getValue() {return value;}
}
```
- 멤버 변수에 반드시 final이 붙어야 한다는 제약은 없다.
- 열거형의 생성자는 외부에서 호출이 불가능하다.(외부에서 객체 생성 불가)
    - 열거형의 생성자는 묵시적으로 접근 제어자가 **private** 이기 때문이다.

### 열거형에 추상 메서드 추가
- 거의 사용하지 않으니 참고만 할것.
- 추상 메서드 선언 시, 각 열거형 상수가 이 추상 메서드를 반드시 구현해줘야한다.
- 이는 거의 익명 클래스와 비슷한데, 이는 아래 '열거형의 이해'에서 자세히 설명하겠다.
```
enum Transportation {
    BUS(100) {int fare(int distance) { return distance * BASIC_FARE;}},
    TRAIN(150) {int fare(int distance) { return distance * BASIC_FARE;}},
    SHIP(100) {int fare(int distance) { return distance * BASIC_FARE;}},
    AIRPLANE(300) {int fare(int distance) { return distance * BASIC_FARE;}}, 

    abstract int fare(int distance);

    protected final int BASIC_FARE; // protected로 해야 상수에서 접근이 가능.

    Transportation(int basicFare){
        BASIC_FARE = basicFare;
    }
}
```

## 열거형의 이해
- 열거형 상수는 모두 클래스 객체이다.
    - 각 상수마다 객체의 주소값을 가지며, 이로인해 '=='로 비교가 가능한 것이다.
    - 따라서, 열거형에 추상메서드 추가 시, 객체 생성식에서 미구현된 추상메서드를 구현
      해줘야 하므로, 각 상수에서 추상메서드를 구현해주는 것이다.(익명 클래스와 동일)
- 모든 열거형은 추상 클래스 Enum의 하위 클래스이며, 이를 구현한 열거형의 내부적 구조를 확인해보자.
```
abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T>{
    static int id = 0;

    int ordinal;
    String name = "";

    public int ordinal() {return ordinal;}

    MyEnum(String name){
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t){
        return ordinal - T.ordinal; // T에서 ordinal을 호출 가능한 것은 MyEnum 클래스 지네릭을 MyEnum<T> 하위로 제한했기 때문이다.
        // MyEnum<T>의 하위 클래스만 객체로 생성가능하므로, 이를 별도로 형변환하지 않아도 사용이 가능한 것이다.
    }

}
```