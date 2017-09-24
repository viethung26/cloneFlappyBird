import java.awt.Rectangle;

import game2dpackage.Object;

public class Bird extends Object{
	private float velocity = 0;
	private boolean isFlying=false;
	private Rectangle rect;
	private int score;
	public Bird() {
		super(350,250,60,60);
		rect= new Rectangle(350, 250, 60, 60);
		score=0;
	}
	public void updateScore() {
		this.score++;
		Flappy.getPointSound.play();
	}
	public int getScore() {
		return score; 	
	}
	public Rectangle getRect() {
		return rect;
	}

	public void update() {
		velocity+=Flappy.gravity;
		this.setPosY(this.getPosY()+velocity);
		if(velocity<0) isFlying=true;
		else isFlying=false;
		rect.setLocation((int)this.getPosX(), (int)this.getPosY());	
	}
	public boolean getIsFlying() {
		return this.isFlying;
	}
	public void fly() {
		velocity=-4;
		Flappy.fapSound.play();
	}
	
	
}
