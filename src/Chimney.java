import java.awt.Rectangle;

import game2dpackage.Object;

public class Chimney extends Object {
	private Rectangle rect;
	Chimney(float x,float y){
		super(x,y,74,400);
		rect = new Rectangle((int)x,(int) y, 74, 4);
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	public void update() {
		this.setPosX(getPosX()-2);
		rect.setLocation((int)getPosX(),(int) getPosY());
	}
	
	
}
