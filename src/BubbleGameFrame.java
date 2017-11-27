import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BubbleGameFrame extends JFrame{
	public BubbleGameFrame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300,300);	
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new BubbleGameFrame();
	}
}
class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {//마우스를 눌렀을때 스레드 시작
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();
			}
		});
	}	
	class BubbleThread extends Thread {
		JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("C:\\Users\\1001\\Desktop\\images\\head.jpg");//이미지의 위치
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);//레이블 위치 설정
			add(bubble); //레이블 추가
			repaint();
		}
		public void run() {
			while(true) {
				int x = bubble.getX();
				int y = bubble.getY() - 5; 
				
				if(y < 0) {
					remove(bubble);
					repaint();
					return; 
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}