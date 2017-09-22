
public class Bird extends Object{
	private float velocity = 0;
	private boolean isFlying=false;
	public Bird(int x,int y, int width, int height) {
		super(x,y,width,height);
	}
	public void update() {
		velocity+=Flappy.gravity;
		setPosY(getPosY()+(int)velocity);
		if(velocity<0) isFlying=true;
		else isFlying=false;
	}
	public boolean getIsFlying() {
		return this.isFlying;
	}
	public void fly() {
		velocity=-3;
	}
	
	
}
