<!--01/04-->
# 객체
## 객체 생성하기  
1. 객체 리터럴 방식  
`const a = {...}// new Object();`  
```
{
속성명 : 값,
속성명 : 값,
}
값 : 원시타입(숫자, 문자, null, undefined...), 객체타입  
    객체 : 함수 객체도 포함
```

2. 생성자 함수 객체 생성
- 생성자 함수 객체에서 생성된 객체에 prototype 체인을 통해 연결되면서 상속이 이뤄진다.
- [[Prototype]] == __ proto__
```
function Person() {...}
const p1 = new Person();
// 객체 생성(상속) 과정
const p1 = {}; -> 빈객체 생성.
Object.setPrototypeOf(p1, Person.prototype);-> prototype 체인에 연결.
Person.apply(p1); -> this를 p1으로 변경.
위 모든 과정이 객체 생성식을 통해 내부적으로 자동 이뤄짐.

일반적으로 내부에 정의된 메서든 prototype 객체 속성에 속성값으로 정의하면,  
생성되는 객체마다 정의된 메서드를 내부적으로 사용할 수 있게 된다.
```

<br><br>

3. Object.create로 객체 생성
- 속성의 속성값
    - getOwnPropertyDescriptor(obj,prop) : 객체 속성의 하기 속성상태 확인.
        value : 값  
        writable : 수정 가능 여부(true, false - 불가)
        enumerable : 반복 가능 여부(true, false - 불가)  
        configurable : 설정가능 여부(true, false - 설정을 바꿀 수 없음)
            - 유일하게 writable이 ture인 경우 false로 바꾸는 기능만 한번 가능함.(예외)
            - 삭제 불가.
    - Object.defineProperty : 속성의 상태 변경.
    - Object.defineProperties : 속성의 상태 복수 변경.
- 객체 생성
```
Object.create(Object.prototype({}),{
    속성명 : {
        value : 값,
        writable : true,
        enumerable : true,
        configurable : true,
    },
});
```

<br><br>

4. 접근자 프로퍼티(속성)
- 데이터 프로퍼티
    - 값
- 접근자 프로퍼티
    - set 함수 객체
    - get 함수 객체
    - 즉시실행함수 내 정의 시, 접근 제한 가능(정보은닉)
        - 함수내 정의된 변수는 안에서만 호출이 가능하기 때문!!
```
const person = (function (){
    let _name = '이름';
    let _age = 40;

    return{
        set name(name) {
            _name = name;
        },
        get name(){
            return _name;
        },

        set age(age) {
            _age = age;
        },
        get age(){
            return _age;
        }
        
    }

})();

```
