import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TestJPanel extends JPanel {
	TestJPanel(){
		repaint();
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(50, 50, 500, 500);
	}
}
