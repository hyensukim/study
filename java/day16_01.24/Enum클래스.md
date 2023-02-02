# 출처 : 자바의정석 3RD Edition (도우출판) & 강의자료(이용교 강사님)
# 열거형(Enumeration)
## Enum 클래스(열거형)란?
- JDK 1.5부터 추가된 기능.
- 상수를 위한 클래스, 서로 관련된 상수를 내부에 선언하기 위한 것.
- 추상클래스, 상수 = 정적 상수 객체, 생성자 = private 내부적 정의(외부에서 객체 생성 불가)

> ### Enum 클래스가 추가된 배경
- 이전 상수는 static final이라는 예약어를 붙여 정의함.
- 상수의 갯수가 많아지면 가독성이 떨어지고, 상수 간의 충돌이 발생할 확률이 높아진다는 단점이 있다.
- 이를 보완하고자 열거형이라는 개념이 추가되었다.

## Enum 클래스 장점
- 하나의 클래스 안에 상수를 나열하여 정의함으로서 가독성이 좋아졌다.
- 정의된 상수들은 고정된 타입으로 외부에서 변경이 불가능한 final의 형태를 갖고, 생성자의 접근제어자가 private으로 지정되어 있어 객체 생성이 불가능 하므로 ***타입에 대한 안전성이 보장*** 된다.
- 추가로 이전에는 상수의 값이 바뀌면 해당 상수를 참조하는 모든 소스를 다시 컴파일 해야했지만, 열거형은 기존의 소슬를 다시 컴파일 하지 않아도 된다.

## 열거형의 정의와 사용
- 정의 : `enum 열거형 이름 {상수명1, 상수명2, ...;}`
- 사용 : `이넘 클래스명.상수명`
- 비교
    - == : 같음 여부를 비교함.
    - 상수명1. compareTo(상수명2) : 상수명1이 큼(양수), 작음(음수), 같음(0) 반환.
    - <, >와 같은 비교 연산자는 사용이 불가능하다.
- switch 조건문 사용
    ※주의사항※ : 열거형의 이름은 적지않고 상수명만 기입.
```
예시
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
    - 데이터 영역(상수)에 생성된 참조 상수가 힙메모리에 생성된 객체를 참조하게 된다.
    - 즉, 상수마다 객체의 주소값을 가지며, 이로인해 '=='로 비교가 가능한 것이다.
    - 따라서, 열거형에 추상메서드 추가 시, 객체 생성식에서 미구현된 추상메서드를 구현
      해줘야 하므로, 각 상수에서 추상메서드를 구현해주는 것이다.(익명 클래스와 동일)
- 모든 열거형은 추상 클래스 Enum의 하위 클래스이며, 이를 구현한 MyEnum 클래스의 내부적 구조를 확인해보자.
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