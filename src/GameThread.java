import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameThread extends JPanel implements Runnable {
	Animation animation;
	long changedTime=0;
	public GameThread(Animation anim) {
		animation=anim;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.fillRect(50, 50, 500, 500);
		g2.drawImage(animation.images[animation.currentFrame],(int)Flappy.bird.getPosX() ,(int)Flappy.bird.getPosY(), this);
	}
	public void run() {
		while(true) {
			animation.updateFrame(System.currentTimeMillis());	
			Flappy.bird.update();
			repaint(animation.currentFrame);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
			
		}

	}
}
