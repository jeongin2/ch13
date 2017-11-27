import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class VibratingFrame extends JFrame{
	public VibratingFrame() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setLocation(100,100);
		setVisible(true);
		
		VibratingThread thread = new VibratingThread(this);//스레드 생성
		thread.start();
	}

	class VibratingThread extends Thread {
		Component comp;
		public VibratingThread(Component comp) {
			this.comp = comp;
		}
		public void run() {
			Random r = new Random();//랜덤 r 생성
			int y = comp.getY();
			int x = comp.getX();
			
			while(true) {//무한루프
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException e){
					return;
				}
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x + r.nextInt(5)*sign;

				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpY = y + r.nextInt(5)*sign;
				
				comp.setLocation(tmpX, tmpY);
			}
		}

	}
	public static void main(String [] args) {
		new VibratingFrame();
	}
} 
