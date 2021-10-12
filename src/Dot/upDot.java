package Dot;

import java.awt.image.BufferedImage;

import movingObject.*;

/**
 * The upDot class extends Dot
 * @author cuifu
 */
public class upDot extends Dot{
	private int speed = 2;
	
	/**
	 * upDot constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 */
	public upDot(int x, int y, BufferedImage image) {
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
        y-=speed;
    }
	
	/**
	 * check comment in the Dot interface
	 */
	@Override
    public boolean outOfBounds() {
        return y<0;
    }	
}
