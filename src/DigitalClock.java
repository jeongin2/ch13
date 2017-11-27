import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClock extends JFrame {
	public DigitalClock() {
		setTitle("디지탈 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyLabel());
		setSize(300,300);
		setVisible(true);
	}
	class MyLabel extends JLabel implements Runnable {
		boolean bPaused = true;
		Thread th = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			th = new Thread(MyLabel.this);
			th.start();
		}
		public String makeClockText() {//시계 생성
			Calendar c = Calendar.getInstance();			
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			return clockText;
		}
		public void run() {
			while(true) {//무한루프
				try {
					Thread.sleep(1000);//1초 동안 잠을 잔다
				}
				catch(InterruptedException e){
					return;
				}
				setText(makeClockText());
			}
		}
	}
	public static void main(String [] args) {
		new DigitalClock();
	}
} 
