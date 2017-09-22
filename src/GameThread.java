import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 900, 900);
		if(Flappy.bird.getIsFlying()) {
			BufferedImage imageDraw = (BufferedImage)animation.images[animation.currentFrame];
			AffineTransform tx1 = new AffineTransform();
	        tx1.rotate(Math.toRadians(-30), imageDraw.getWidth() / 2, imageDraw.getHeight() / 2);
	        AffineTransformOp op = new AffineTransformOp(tx1,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	        imageDraw = op.filter(imageDraw, null);
	        g2.drawImage(imageDraw, (int)Flappy.bird.getPosX(), (int)Flappy.bird.getPosY(), null);		
		}
		else g2.drawImage(animation.images[animation.currentFrame],(int)Flappy.bird.getPosX() ,(int)Flappy.bird.getPosY(), this);
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
