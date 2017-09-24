import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
public class GameScreen extends JFrame implements KeyListener{
	public GameScreen() {
		setSize(800,635);
		setTitle("Flappy Bird");
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public GameScreen(int x,int y) {
		addKeyListener(this);
		setSize(x,y);
		setTitle("Flappy");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(GameThread.currentScreen==GameThread.BEGIN_SCREEN) {
				GameThread.currentScreen=GameThread.PLAY_SCREEN;
			}
			else if(GameThread.currentScreen==GameThread.PLAY_SCREEN) {
				Flappy.bird.fly();
			}
			else {
				Flappy.bird= new Bird();
				Flappy.ground = new Ground();
				Flappy.twinChimney= new TwinChimney();
				GameThread.currentScreen=GameThread.PLAY_SCREEN;
			}
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
