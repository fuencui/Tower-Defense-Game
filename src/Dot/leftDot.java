package Dot;

import java.awt.image.BufferedImage;

import movingObject.*;

/**
 * The leftDot class extends Dot
 * @author cuifu
 */
public class leftDot extends Dot{
	private int speed = 2;
	
	/**
	 * leftDot constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 */
	public leftDot(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.image = image;
	}
	
	/**
	 * check comment in the Dot interface
	 */
	@Override
    public void move(){   
        x-=speed;
    }
	
	/**
	 * check comment in the Dot interface
	 */
	@Override
    public boolean outOfBounds() {
        return x<0;
    }
}