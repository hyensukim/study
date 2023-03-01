### 2023.02.23
# 3장 제어문
## 1. if 구문
1. if 구문 기본구조
    ```
    if 조건문:
        수행할 문장1
        수행할 문장2
        ...
    else:
        수행할 문장A
        수행할 문장B
        ...
    ```

2. 들여쓰기
    - if 조건문 : 아래 문장부터 if구문에 속하는 모든 문장들은 들여쓰기 되어야 한다.
    - 들여쓰기의 깊이는 모든 문장이 같아야 한다. 하나라도 더 깊거나 덜 깊으면, 오류 발생함.
    - 공백과 탭 모두 사용가능 하지만 하나로 통일해야한다.(나는 탭)

3. 콜론(:) 붙이기
    - if 조건문 다음에 콜론(:)이 온다. 이는 파이썬 문법이므로 암기하자.

3. 조건문
    - 조건문에는 비교연산자, 논리연산자, in/not in 연산자
    - in/not in 예시    
    ```
    >>> 1 in [1, 2, 3]
    True
    >>> 1 not in [1, 2, 3]
    False
    ```

4. 조건문에서 아무일도 일어나지 않도록 하기윈한 pass 예시
    ```
    >>> pocket = ['paper', 'money', 'cellphone']
    >>> if 'money' in pocket:
    ...     pass 
    ... else:
    ...     print("카드를 꺼내라")
    ... #아무런 결과도 나오지 않게된다.
    ```

5. 다양한 조건을 판단하는 elif문 기본구조
    ```
    If <조건문>:
    <수행할 문장1> 
    <수행할 문장2>
    ...
    elif <조건문>:
        <수행할 문장1>
        <수행할 문장2>
        ...
    elif <조건문>:
        <수행할 문장1>
        <수행할 문장2>
        ...
    ...
    else:
    <수행할 문장1>
    <수행할 문장2>
    ... 
    ```
    - elif는 이전 조건문이 거짓일 때에만 수행된다.
    - 예시
    ```
    >>> pocket = ['paper', 'cellphone']
    >>> card = True
    >>> if 'money' in pocket:
    ...      print("택시를 타고가라")
    ... elif card: 
    ...      print("택시를 타고가라")
    ... else:
    ...      print("걸어가라")
    ...
    택시를 타고가라
    ```

6. if문 한줄로 작성하기
    ```
    >>> pocket = ['paper', 'money', 'cellphone']
    >>> if 'money' in pocket: pass
    ... else: print("카드를 꺼내라")
    ...
    ```

7. ★조건부 표현식1
    ```
    if score >= 60:
        message = "success"
    else:
        message = "failure"
    ```
    - 위 코드를 간단히 표현하면
    ```
    message = "success" if score >= 60 else "failure"
    ```
    - 조건부 표현식
    `변수 = 조건문이_참인_경우의_값 if 조건문 else 조건문이_거짓인_경우의_값`
<br><br>

## 2. while 반복문
1. while 구문 기본구조
    ```
    while <조건문>:
        <수행할 문장1>
        <수행할 문장2>
        <수행할 문장3>
        ...
    ```

2. while문 사용 시 주의점
    - 초기화식이 while문 보다 위에 나와야 한다.
    ```
    >>> number = 0 #초기화식
    >>> while number != 4:
    ...     print(prompt)
    ...     number = int(input())
    ... 
    ```

3. while문 강제로 빠져나가기
- break

4. while문의 조건문으로 돌아가기
- continue

5. 무한루프 : 무한 반복(while True :)
- Ctrl + c : 무한루프 탈출