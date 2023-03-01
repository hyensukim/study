public class InnerTest {

	public static void main(String[] args) {
		//instance Inner class 객체 생성
		//외부 클래스 내부 요소처럼 사용 -> 외부 객체 생성한 뒤 사용.
		Outer.InstanceInner instanceIn = new Outer().new InstanceInner();
		instanceIn.method();
		instanceIn.staicMethod();
		
		System.out.println();
		
		//static Inner class 객체 생성
		//외부 클래스의 정적 요소처럼 사용 -> 클래스명으로 접근 -> 객체 생성과 상관없음.
		Outer.StaticInner staticIn = new Outer.StaticInner();
		staticIn.method();
		staticIn.staticMethod();
		
		
	}

}