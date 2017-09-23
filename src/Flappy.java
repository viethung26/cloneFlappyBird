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
	public static Ground ground;
	public static Bird bird;
	public static TwinChimney twinChimney;
	public static float gravity=0.1f;
	public Flappy() {
		bird=new Bird();
		ground = new Ground();
		twinChimney= new TwinChimney();
		try {
			birdSprite= ImageIO.read(new File("Assets/bird_sprite.png"));
		} catch (IOException e) {}
		gameScreen=new GameScreen();
		animation = new Animation(50);
		animation.addFrame(birdSprite.getSubimage(0, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(60, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(120, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(60, 0, 60, 60));
		gThread = new GameThread(animation);
		gameScreen.add(gThread);
	}
	public static boolean checkCrash() {
		float bx=bird.getPosX();
		float by=bird.getPosY();
		for(int i=0;i<6;i++) {
			float x=twinChimney.getChimney(i).getPosX();
			float y=twinChimney.getChimney(i).getPosY();
			if(i%2==0 && bx+55>x && bx<x+74 && by+55>y) return true; 
			else if (i%2==1 && bx+55>x && bx<x+69 && by<y+395) return true;
			}
		return false;
	}
	public static void main(String[] args) {
		new Flappy();
	}
}
