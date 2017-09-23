import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import game2dpackage.QueueList;

public class TwinChimney {
	Chimney chimney;
	BufferedImage image,image2;
	QueueList<Chimney> twinChimney;
	public TwinChimney() {
		try {
			image=ImageIO.read(new File("Assets/chimney.png"));
			image2=ImageIO.read(new File("Assets/chimney2.png"));
		}catch(Exception e) {}	
		twinChimney = new QueueList<Chimney>();
		for(int i=0;i<3;i++) {
			Random random = new Random();
			int ran = random.nextInt(10);
			chimney = new Chimney(700+i*300,490-ran*35);
			twinChimney.push(chimney);
			chimney = new Chimney(700+i*300,-70-ran*35);
			twinChimney.push(chimney);
		}
	}
	public Chimney getChimney(int index) {
		return twinChimney.get(index);
	}
	public void update() {
		for(int i=0;i<6;i++) {
			twinChimney.get(i).setPosX(twinChimney.get(i).getPosX()-2);
		}
		if(twinChimney.get(0).getPosX()<-74) {
			Random random = new Random();
			int ran = random.nextInt(10);
			twinChimney.pop();
			chimney = new Chimney(twinChimney.get(4).getPosX()+300,100+ran*40);
			twinChimney.push(chimney);
			twinChimney.pop();
			chimney = new Chimney(twinChimney.get(4).getPosX(),-455+ran*40);
			twinChimney.push(chimney);
		}
		
	}
	public void paint(Graphics2D g2) {
		for(int i=0;i<6;i++) {
			if(i%2==0) {
				g2.drawImage(image,(int)twinChimney.get(i).getPosX(),(int)twinChimney.get(i).getPosY(),null);
			}
			else g2.drawImage(image2,(int)twinChimney.get(i).getPosX(),(int)twinChimney.get(i).getPosY(),null);
		}
		
	}
	
}
