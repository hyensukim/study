# Comparable과 Comparator
- Comparable과 Comparator 모두 인터페이스로 컬렉션을 정렬하는데 필요한 메서드를 정의한다.
- 즉, Comparable을 구현한 클래스는 정렬이 가능하다.
- Comparable과 Comparator의 실제 소스
```
public interface Comparator{
    int compare(Object o1, Object o2);
    boolean equals(Object obj);
}

public interface Comparable{
    public int compareTo(Object o);
}
```
- 두 인터페이스의 추상 메서드는 각각 Comparator -> copare(), Comparable -> compareTo이며, 두 메서드 모두 객체를 비교하는 기능으로 고안되었다.
- *구현 시 두 객체가 같으면 0, 비교하는 값보다 작으면 음수, 크면 양수를 반환하도록 구현해야 한다.*
- **일반적으로 Comparable은 기본 정렬기준을 구현하는데 사용하고, Comparator는 기본 정렬기준 외에 다른 정렬기준을 정할때 구현한다.**
- **따라서, 정렬 시 별도의 Comparator를 지정하지 않으면 Comparable 기준으로 정렬이되고, Comparable이 구현되지 않은 클래스 타입의 객체는 정렬이 불가능하다.**