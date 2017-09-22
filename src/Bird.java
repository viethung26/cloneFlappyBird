
public class Bird extends Object{
	private float velocity = 0;
	public Bird(int x,int y, int width, int height) {
		super(x,y,width,height);
	}
	
	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public void update() {
		velocity+=Flappy.gravity;
		setPosY(getPosY()+(int)velocity);
	}
	
	
}
