import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Flappy {
	Animation animation;
	GameScreen gameScreen;
	GameThread gThread;
	BufferedImage birdSprite;
	public static Bird bird;
	public static float gravity=0.2f;
	public Flappy() {
		bird=new Bird(300,300,60,60);
		try {
			birdSprite= ImageIO.read(new File("Assets/bird_sprite.png"));
		} catch (IOException e) {}
		gameScreen=new GameScreen(1000,1000);
		animation = new Animation(100);
		animation.addFrame(birdSprite.getSubimage(0, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(60, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(120, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(60, 0, 60, 60));
		gThread = new GameThread(animation);
		gameScreen.add(gThread);
		
		
		
	}
	public static void main(String[] args) {
		new Flappy();
	}
}
