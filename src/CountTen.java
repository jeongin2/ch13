import java.util.Scanner;

public class CountTen {

	static public void main(String [] args) {
		Thread th = new Thread(new CountingThread());//스레드 객체 생성
		th.start();//스레드 시작
		System.out.println("아무 키나 입력 >> ");
		
		try {
			th.join();
		}
		
		catch(InterruptedException e) {
		}
		System.out.println(" ");
		System.out.println("스레드 종료");		
	}
}

class CountingThread implements Runnable {
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String c = scanner.next();
		System.out.println("스레드 실행 시작");
		for(int i=1; i<=10; i++)//1부터 10까지 출력
			System.out.print(i + " ");
	}
} 