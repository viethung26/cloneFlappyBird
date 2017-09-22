import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
public class GameScreen extends JFrame implements KeyListener{
	public GameScreen() {
		setSize(900,900);
		setTitle("Flappy");
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
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			Flappy.bird.setVelocity(-3);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
