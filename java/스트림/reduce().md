# reduce() 최종 연산
## Optional<T> reduce(BinaryOperator<T> accumulator)
- 스트림의 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소와 연산을 한다.
- 이 과정에서 요소를 하나씩 소모하게 되고, 모든 요소를 소모하면 결과를 반환한다.

## T reduce(T identity, BinaryOperator<T> accumulator)
- 초기값(identity)과 스트림의 첫번째 요소로 연산을 시작한다.
- 스트림 요소가 하나도 없는 경우, 초기값이 반환되므로 반환타입이 Optional<T>가 아니라 T이다.

## reduce()
- count()와 sum() 등은 내부적으로 모두 reduce()를 이용해서 작성되어 있다.
```
int count = intStream.reduce(0,(a,b) -> a+1 );
int sum = intStream.reduce(0,(a,b) -> a + b);
int max = intStream.reduce(Integer.MIN_VALUE,(a,b) -> a>b?a:b)
int max = intStream.reduce(Integer.MAX_VALUE,(a,b) -> a<b?a:b)
```

- reduce()의 내부 동작
```
T reduce(T identity, BinaryOperator<T> accumulator){
    T a = identity
    for(T b : stream)
        a = accumulator.apply(a,b);
    return a;
}
```