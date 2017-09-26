import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import javax.imageio.ImageIO;

import game2dpackage.SoundPlayer;
public class Flappy {
	Animation animation;
	GameScreen gameScreen;
	GameThread gThread;
	BufferedImage birdSprite;
	public static SoundPlayer fallSound,getPointSound,fapSound;
	public static Ground ground;
	public static Bird bird;
	public static TwinChimney twinChimney;
	public static float gravity=0.1f;
	private static int bestScore;
	public Flappy() {
		File f = new File("Data/data.txt");
		if (f.exists()){
			try {
				Scanner scanner = new Scanner(f);
				bestScore = scanner.nextInt();
				scanner.close();
			} catch (FileNotFoundException e) {}
		}
		else bestScore=0;
		fallSound = new SoundPlayer(getClass().getResource("/assets/fall.wav"));
		getPointSound = new SoundPlayer(getClass().getResource("assets/getpoint.wav"));
		fapSound = new SoundPlayer(getClass().getResource("/assets/fap.wav"));
		bird=new Bird();
		ground = new Ground();
		twinChimney= new TwinChimney();
		try {
			birdSprite= ImageIO.read(getClass().getResource("/assets/bird_sprite.png"));
		} catch (IOException e) {}
		gameScreen=new GameScreen();
		animation = new Animation(50);
		animation.addFrame(birdSprite.getSubimage(0, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(60, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(120, 0, 60, 60));
		animation.addFrame(birdSprite.getSubimage(60, 0, 60, 60));
		gThread = new GameThread(animation);
		gameScreen.add(gThread);
		gameScreen.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Formatter f = new Formatter("Data/data.txt");
					f.format("%d", Flappy.bestScore);
					f.close();
				} catch (FileNotFoundException e1) {}
			}
			
		});
	}
	public static void setBestScore() {
		if(Flappy.bestScore<bird.getScore())
		Flappy.bestScore=bird.getScore();
	}
	public static int getBestScore() {
		return Flappy.bestScore;
	}
	public static boolean checkCrash() {
		float bx=bird.getPosX();
		float by=bird.getPosY();
		if(by+bird.getHeight()>=ground.getHeight()) return true;//crash ground
		if(by<=0) return true; // crash sky
		
		for(int i=0;i<6;i++) {
			float x=twinChimney.getChimney(i).getPosX();
			float y=twinChimney.getChimney(i).getPosY();	
			if(i%2==0 && bx+55>x && bx<x+74 && by+55>y) return true; 
			else if (i%2==1 && bx+55>x && bx<x+69 && by<y+395) return true;
//			if(bird.getRect().intersects(twinChimney.getChimney(i).getRect())) System.out.println("debug"+i);
			}
		return false;
		
	}
	public static void main(String[] args) {
		new Flappy();
	}
}
