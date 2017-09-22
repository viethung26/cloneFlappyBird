
public class Object {
	private float posX, posY;
    private float width, height;
    public Object(){
    	posX = posY = width = height = 0;
    }
    public Object(int x, int y, int width, int height) {
    	posX = x;
    	posY = y;
    	this.width = width;
    	this.height = height;
    }
	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
    
}
