import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

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
		AffineTransform tx = new AffineTransform();
		if(Bir)
        tx.rotate(rotation, imageDraw.getWidth() / 2, imageDraw.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx,
            AffineTransformOp.TYPE_BILINEAR);
        imageDraw = op.filter(imageDraw, null);
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
