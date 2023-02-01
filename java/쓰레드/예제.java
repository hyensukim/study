
//interrupt() 관련 예제
import javax.swing.JOptionPane;

public class ThreadEx08 {
	public static void main(String[] args) {
		ThreadEx08_1 th1 = new ThreadEx08_1();
		th1.start();
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println(input);
		th1.interrupt();
		System.out.println("isInterrupted() : " + th1.isInterrupted());
		
	}
}

class ThreadEx08_1 extends Thread{
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(int x=0; x<2500000000L; x++); // 시간 지연
		}
		System.out.println("카운터가 종료되었습니다.");
	}
}
