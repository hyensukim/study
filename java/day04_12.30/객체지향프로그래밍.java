/* this 예제 */
class BirthDay {
	int day;
	int month;
	int year;
	
	public void setYear(int year) {
		this.year = year;  // bDay.year = year;와 같음
	}
	
	public void printThis( ) {
		System.out.println(this); // System.out.println(bDay);와 같음
	}
}

public class ThisExample {
	public static void main(String[] args) {
		BirthDay bDay = new BirthDay();
		bDay.setYear(2000);
		System.out.println(bDay);
		bDay.printThis();
	}
}


실행결과

day05_07.thisex.BirthDay@5e91993f
day05_07.thisex.BirthDay@5e91993f