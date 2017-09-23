import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Ground {
	BufferedImage img;
	private int x1,x2,y1,y2;
	public Ground() {
		try {
			img = ImageIO.read(new File("Assets/ground.png"));
		}catch(Exception e) {}
		x1=0;
		y1=y2=500;
		x2=830;
	}
	public int getHeight() {
		return this.y1;
	}
	public void update() {
		x1-=2;
		x2-=2;
		if(x2<=0) x1=x2+830;
		if(x1<=0) x2=x1+830;
		
	}
	public void paint(Graphics2D g2) {
		g2.drawImage(img, x1, y1, null);
		g2.drawImage(img, x2, y2, null);
	}
}
