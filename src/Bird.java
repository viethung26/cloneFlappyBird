import game2dpackage.Object;

public class Bird extends Object{
	private float velocity = 0;
	private boolean isFlying=false;
	public Bird() {
		super(350,250,60,60);
	}
	public void update() {
		velocity+=Flappy.gravity;
		this.setPosY(this.getPosY()+velocity);
		if(velocity<0) isFlying=true;
		else isFlying=false;
	}
	public boolean getIsFlying() {
		return this.isFlying;
	}
	public void fly() {
		velocity=-4;
	}
	
	
}
