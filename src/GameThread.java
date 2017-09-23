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
	public final static int BEGIN_SCREEN = 0;
	public final static int PLAY_SCREEN = 1;
	public final static int OVER_SCREEN = 2;
	public static int currentScreen;
	public boolean enableText=false;
	public long timeText=0;
	
	Animation animation;
	long changedTime=0;
	public GameThread(Animation anim) {
		currentScreen= BEGIN_SCREEN;
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
	        tx1.rotate(Math.toRadians(-45), imageDraw.getWidth() / 2, imageDraw.getHeight() / 2);
	        AffineTransformOp op = new AffineTransformOp(tx1,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	        imageDraw = op.filter(imageDraw, null);
	        g2.drawImage(imageDraw, (int)Flappy.bird.getPosX(), (int)Flappy.bird.getPosY(), null);		
		}
		else g2.drawImage(animation.images[animation.currentFrame],(int)Flappy.bird.getPosX() ,(int)Flappy.bird.getPosY(), this);
		Flappy.ground.paint(g2);
		Flappy.twinChimney.paint(g2);
		
		if(currentScreen==BEGIN_SCREEN && enableText) {
			g.setFont(g.getFont().deriveFont(30.0f));
			g.setColor(Color.red);
			g.drawString("Press space to play", 250, 250);
		}
		else if(currentScreen==OVER_SCREEN) {
			g.setFont(g.getFont().deriveFont(30.0f));
			g.setColor(Color.red);
			g.drawString("GAME OVER", 265, 220);
			g.setFont(g.getFont().deriveFont(25.0f));
			if(enableText) g.drawString("Press space to restart", 250, 250);
		}
		
	}
	public void run() {
		while(true) {
			repaint(animation.currentFrame);
			if(currentScreen==BEGIN_SCREEN) {
				if(System.currentTimeMillis()-timeText>600) {
					enableText=!enableText;
					timeText=System.currentTimeMillis();
				}
			}
			else if(currentScreen==PLAY_SCREEN) {
				animation.updateFrame(System.currentTimeMillis());	
				Flappy.bird.update();
				Flappy.ground.update();
				Flappy.twinChimney.update();
				if(Flappy.bird.getPosY()+Flappy.bird.getHeight()>=Flappy.ground.getHeight())
					currentScreen=OVER_SCREEN;
				if(Flappy.checkCrash()) {
					currentScreen=OVER_SCREEN;
				}	
			}
			else{
				if(System.currentTimeMillis()-timeText>600) {
					enableText=!enableText;
					timeText=System.currentTimeMillis();
				}
			}
//			repaint(animation.currentFrame);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}

	}
	
}
