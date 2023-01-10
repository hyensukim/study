<!--01/03 ~01/04-->
# 함수
- 함수는 객체이다. 일급 객체. 값이다.  

## 함수 정의하기
함수 정의 방법은 4가지 이다.

- 함수 선언문  
**`function square(x) {return x*x;}`**  
- 함수 리터럴  
**`const a = function (x){return x*x; };`**  
- Function 생성자로 정의  
**`const square = new Function("x","return x*x");`**  
- 화살표 함수 표현식  
**`const square = x => x*x;`**  
- 함수 리터럴, Function 생성자, 화살표 함수 이 세가지 방식으로 함수 정의 시, 함수의 호이스팅이 되지 않는다. 이는 좌항 참조변수(참조값)가 **호이스팅** 되기 때문이다.
    - 이러한 경우, 정의 후 하기부터 함수를 사용할 수 있다.
- 화살표 함수 표현식의 제한된 기능.
    1. prototype 속성이 없어 생성자로서 사용이 불가하다.
    2. <mark>this 범위가 다르고 변경이 불가함.</mark>
        - 일반적인 this : 호출 이후 객체 자신의 참조값을 나타내는 지역 변수.
        - 화살표 함수 this : 함수를 정의할 때 객체의 참조값을 나타내는 지역 변수.
        - 모든 객체는 호출되기 전까지는 window 객체 하위에 포함되어 있다.
        - 일반적으로 this의 범위가 달라지므로 화살표 함수 내 this 사용 지양함.
        - 대신, callback함수의 인수로 많이 사용된다.

<br><br>

## 함수는 객체이고 값이다.
- 매개변수
```
1) 함수를 매개변수 값으로 사용.
function func(callback){
    callback();
}

function callback(){
    console.log("나는 돌아온다.");
}

func(callback); // 나는 돌아온다.

2) 배열과 함수를 매개변수로 받아 배열 내부 값을 출력하는 함수.
function(array,callback){
    for(arr of array){
        callback(arr);
    }
}

fuction callback(arr){
    console.log(arr);
}

func([1,2,3],callback);
//출력
1
2
3
undefined

3) 화살표 함수
function(array, callback){
    for(arr of array){
        callback(arr);
    }
}

func([1,2,3],(x)=>console.log(x));
//결과
1
2
3
undefined
```
- 반환값
 : 클로저 예시

<br><br>

## 중첩함수
- 특정 함수의 내부에 정의된 함수.
- 중첩 함수는 참조값을 그 중첩 함수의 외부 함수의 지역변수에 저장되며,외부 함수 밖에서는 읽거나 쓸 수 없다.

<br><br>

## 함수 호출하기
- 함수 호출 방법
    - 함수 참조 변수 뒤에 그룹 연산자() 소괄호를 붙여 함수 호출.
- 메서드 호출 방법
    - 객체의 속성에 함수 참조값이 저장된 것을 '메서드'라고 함.
    - 객체명. 메서드명 ()
- 생성자 함수 호출
    - new 키워드와 함께 사용.
- call, apply를 이용한 간접 호출
    - Function의 call과 apply 메서드를 사용하면 함수를 간접적으로 호출 할 수 있음.
    - Function.prototype.call() : 주어진 this값 및 각각 전달된 인수와 함께 호출됨.
- 즉시 실행 함수  
**`(function() {...})();`**

<br><br>

## 프로그램 평가와 실행 과정
- 자바 스크립트에서는 함수가 객체이므로 코드 자체가 실행되는 것이 아니라, 실행문맥이라는 객체를 생성하여 재구성된다.
- 실행문맥(Execution Context) -> 스택
- 함수 실행 -> 실행 가능 여부 평가 및 실행문맥 생성 -> 내부적으로 구조화(재구성) -> 호이스팅 발생.
    1. 환경 레코드(구조화) 
        - 원시타입 변수(숫자,문자,...함수)
        - 객체 변수
        - 외부 환경 레코드 참조(함수 재구성 시 참조)
        - 유효범위 스코프 체인(변수 참조 체인) 
    2. this 범위 결정.

<br><br>

## 자바스크립트는 싱글 쓰레드.
- 자바스크립트 초기에 웹에서 비중이 작은 언어 이었으며, 이로 인해 싱글 스레드 방식으로 사용되었다.
  하지만 점차 비중이 커지게 되면서 좀 더 발전된 방식을 추구하게 된다.
- 싱글 스레드 방식 : 프로그램 한개의 처리 흐름, 순차적으로 실행하는 방식.
- 자바스크립트에서는 싱글 스레드로 작업을 처리한다. 호출 스택에 싸힌 실행 문맥들을 위에서부터 아래로 순차적으로 실행한다.
    - 즉 하나의 작업이 끝날 때까지 다른 실행 문맥 작업을 실행하지 않는다.
- 비동기 프로그래밍 방식 : Qeue 구조에 대기열을 만들고 실행 중인 함수의 작업이 끝나면 대기 행열에서 첫번째 실행문맥부터 차례대로 호출 스택에 push해 실행해 나간다. 이때 웹 브라우저의 API인 Web Workers를 사용해 특정 작업을 백그라운드에 있는 다른 스레드에서 실행 할 수 있게된다.

<br><br>

## 클로저
- 중첩 함수에서 외부 함수의 변수를 중첩 함수 내부에서 참조할 경우,
  참조가 끊기지 않게되어 외부 함수의 동작이 끝나도 GC에 의해 제거되지 
  않는다.

<br><Br>

## 이름 공간
1. 객체를 이름 공간으로 활용.(Name-tag)
    - 패키지의 역할, 변수 또는 함수명의 충돌을 방지하기 위함.
```
var code = code || {};
code.객체 = {...};
// code. 이름을 포함한 경우, code 객체 내부에 저장되지만, 아닌경우 빈객체에 저장되도록 하는 코드.
```

2. 모듈 패턴
    - 즉시 실행 함수 사용.

```
const _module = (function(){
    return {
            popup : function(){
                console.log('팝업열기');
            },
    };
})();
```
<br><Br>


# ECMAScript6+ 추가된 기능


## 이터레이터(Iterator)
- prototype
    .Symbol.iterator 가 있으면, 이터레이터 객체 생성가능.(@@iterator)
    -> String 객체도 사용 가능.

- for of 이터레이터 사용 구문


```
const fruits = ["apple", "orange", "mango"];
undefined
const iterator = fruits[Symbol.iterator]();
undefined
iterator.next();
{value: 'apple', done: false}
iterator.next();
{value: 'orange', done: false}
iterator.next();
{value: 'mango', done: false}
iterator.next(); // 끝.
{value: undefined, done: true}

//반복문 사용
while(true) {
    const v = iterator.next();
    if(v.done){
        break;
    }
    console.log(v);
}

//for of 이터레이터 사용
for (const fruit of iterator){
    console.log(fruit);
}

//객체를 그냥 넣은 for of 사용
for (const fruit of fruits){
    console.log(fruit);
}
```

<br><br>

## 제너레이터
- 대용량 데이터 처리 시에 유용함.
- 대용량의 데이터를 쪼개서 사용 및 반환을 반복한다.(저사양에서 대용량을 사용가능.)
- 제너레이터 형태 객체
    - function* 함수명() {
        yeild 반환값;
        yeild 반환값;
        yeild 반환값;
        ...
    }

## 객체 내부 함수 정의 시 속성 축약표현
```
ES5
const person = {
    name : "이름",
    age : 40,
    showInfo : function() {
        console.log(this.name, this.age);
    }
}

ES6+
const person ={
    name : "이름",
    age : 40,
    showInfo() { // function 키워드 생략
        console.log(this.name, this. age)
    }
}
```