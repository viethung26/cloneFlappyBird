package game2dpackage;

public class Object {
	private float posX, posY;
    private int width, height;
    public Object(){
    	posX = posY = width = height = 0;
    }
    public Object(float x, float y, int width, int height) {
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
	public int getHeight() {
		return height;
	}
	
 
}
