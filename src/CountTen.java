import java.util.Scanner;

public class CountTen {

	static public void main(String [] args) {
		Thread th = new Thread(new CountingThread());//������ ��ü ����
		th.start();//������ ����
		System.out.println("�ƹ� Ű�� �Է� >> ");
		
		try {
			th.join();
		}
		
		catch(InterruptedException e) {
		}
		System.out.println(" ");
		System.out.println("������ ����");		
	}
}

class CountingThread implements Runnable {
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String c = scanner.next();
		System.out.println("������ ���� ����");
		for(int i=1; i<=10; i++)//1���� 10���� ���
			System.out.print(i + " ");
	}
} 