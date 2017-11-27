import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RandomCircle extends JFrame { 
	public RandomCircle() {
		setTitle("원이 랜덤한 위치로 이동");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		final MyPanel panel = new MyPanel();
		setContentPane(panel);

		setSize(300,300);
		setVisible(true);
	}		


public class MyPanel extends JPanel {
	public MyPanel() {
		new Thread (new Runnable() {//스레드 생성
			public void run() {
				try {
					while(true) {
						repaint();
						Thread.sleep(400);
					}
				} 
				catch(Exception e) {//예외가 발생하면 스레드 종료
					return;
				}
			}
		}).start();
	}
	public void paintComponent(Graphics g) { //circle 생성
		Random r = new Random();
		int x = r.nextInt(getWidth()-50);
		int y = r.nextInt(getHeight()-50);
		g.clearRect(0,0,getWidth(),getHeight());
		g.drawOval(x,y,50,50);		
	 }
    }
    public static void main(String[] args) {
    	  new RandomCircle();
      }
    }
   