# String 클래스 메서드

## split()
- 구조
    ```
    String[] split(String regex){

    }
    ```
- 해석 : 매개변수 regex를 구분하여 String을 분리하여 String[] 에 순서대로 담는다.
- 예시
    ```
    String str ="I LOVE YOU";
    String[] splited = str.split(" ");
    Arrays.stream(splited).forEach(System.out::println);
    /**
    연산 결과
        I
        LOVE
        YOU
    */
    ```
## char charAt(int index)
- 해석 : 인덱스 주소의 문자를 반환함.
- 예시
    ```
		String str = "안녕하세요 반가워요 잘있어요 다시 만나요 ";
		char a =str.charAt(0);
		char b = str.charAt(1);
		System.out.println(a+ " ....... " + b);
        /**
        연산 결과
            안 ....... 녕
        */
    ```

## IntStream chars()
- 해석 : chars() 메서드가 생성한 IntStream 객체는 문자열의 각 문자를 int 형태로 반환합니다. 이때 int 값은 해당 문자의 유니코드 코드 포인트 값입니다.
- 예시
    ```
    예를 들어, "Hello World" 문자열에서 chars() 메서드를 호출하면 다음과 같은 IntStream 객체를 반환합니다.
    72
    101
    108
    108
    111
    32
    87
    111
    114
    108
    100

    String str = "Hello World";
    str.chars().forEach(ch -> System.out.print((char)ch));

    연산 결과
    Hello World
    ```
### Q : JAVADOC 상 설명에 zero-extending이라는 말이 있는데 이건 뭐지?
- A : 부호확장과 제로 확장
    - CPU에서 bit를 확장할 때 사용되는 개념.
    - 부호확장 : 부호 있는 수를 확장할 때 사용하며, 최상위 비트(가장앞)의 값을 확장하는 나머지 비트값에 대입하면 된다.
        | 부호 있는 수                             | 8bit 2진수를 32bit로 부호 확장 |
        |-----------------------------------------|------------------------|
        |     |           0000_0001               |
        | +1  |                ↓                  |
        |     |0000_0000 0000_0000 0000_0000 0000_0001|
        |     |            1111_1111              |
        | -1  |                ↓                  |
        |     |1111_1111 1111_1111 1111_1111 1111_1111 |
        
    - 제로 확장 : 부호 없는 수를 확장 시 사용하며, 확장하는 나머지 비트값에 0을 대입하면 된다.
        
        | 부호 있는 수                             | 8bit 2진수를 32bit로 부호 확장 |
        |-----------------------------------------|------------------------|
        |     |           0000_0001               |
        | +1  |                ↓                  |
        |     |0000_0000 0000_0000 0000_0000 0000_0001|
        |     |            1111_1111              |
        | +255|                ↓                  |
        |     |0000_0000 0000_0000 0000_0000 1111_1111 |

### 2의 보수 표현법?

# String과 StringBuffer 차이점