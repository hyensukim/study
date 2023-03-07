# Integer 클래스 메서드

## parseInt()
- 구조
    ```
    static int parseInt(String s){...}
    static int parseInt(String s,int radix){...}
    ```
- 해석 : 문자열을 int 정수로 parse(해석) 해준다.
         두번째 매개변수 radix는 어떤 진수의 값으로 변환할 것인지에 대한 진수 값.(8 -> 8진수, 16 -> 16진수...)
- 예시
    ```
    String intStr = "1234";
    int num = Integer.parseInt(intStr);
    System.out.println(num);
    /**
    연산 결과
        1234
    */
    ```