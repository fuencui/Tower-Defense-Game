package Dot;

import java.awt.image.BufferedImage;

import movingObject.*;

/**
 * The leftMeleedOT class extends Dot
 * @author cuifu
 */
public class leftMeleeDot extends Dot{
	private int speed = 1;
	private int timer = 0;
	
	/**
	 * leftMeleeDot constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 */
	public leftMeleeDot(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.image = image;
	}
	
	/**
	 * The melee dot has limit attack range
	 * check comment in the Dot interface
	 */
	@Override
    public void move(){   
        if (timer <= 100) {
        	x-=speed;
        	timer += 1;
        }
    }
	
	/**
	 * The melee dot has limit attack range
	 * check comment in the Dot interface
	 */
	@Override
    public boolean outOfBounds() {
        return timer > 99;
    }
}