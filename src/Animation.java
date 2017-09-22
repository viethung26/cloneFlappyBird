import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Animation{
	Image[] images;
	int numberOfFrame=0;
	int currentFrame=0;
	long measure,changedTime=0;
	
	Animation(long measure){
		this.measure=measure;
	}
	
	public void addFrame(Image img) {
		Image[] arr = images;
		images= new BufferedImage[numberOfFrame+1];
		images[numberOfFrame]=img;
		for(int i=0;i<numberOfFrame;i++) images[i]=arr[i];
		numberOfFrame++;
	}	
	
	public void updateFrame(long currentTime) {
		if(currentTime-changedTime>measure) {
			currentFrame++;
			if(currentFrame>=numberOfFrame) currentFrame=0;
			changedTime=currentTime;
		}
	}	
}
