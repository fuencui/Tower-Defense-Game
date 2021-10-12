package Dot;

import java.awt.image.BufferedImage;

import movingObject.*;

/**
 * The whiteWarrior object extends Dot
 * The white soldier is a bullet that cannot be destroyed
 * @author cuifu
 */
public class whiteWarrior extends Dot{
	private int speed = 2;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage image8;
	private BufferedImage image9;
	private BufferedImage image10;
	private boolean moveX = false;
	private boolean moveY = false;
	private int which = 1;
	private int rangeX;
	private int rangeY;
	
	/**
	 * whiteWarrior constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image under different frame
	 * @param image2 object image under different frame
	 * @param image3 object image under different frame
	 * @param image4 object image under different frame
	 * @param image5 object image under different frame
	 * @param image6 object image under different frame
	 * @param image7 object image under different frame
	 * @param image8 object image under different frame
	 * @param image9 object image under different frame
	 * @param image10 object image under different frame
	 * @param rangeX Moving range x
	 * @param rangeY Moving range Y
	 */
	public whiteWarrior(int x, int y, BufferedImage image, BufferedImage image2,
				BufferedImage image3,BufferedImage image4,BufferedImage image5,
				BufferedImage image6,BufferedImage image7,BufferedImage image8,
				BufferedImage image9,BufferedImage image10,
					  int rangeX, int rangeY){
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.image7 = image7;
		this.image8 = image8;
		this.image9 = image9;
		this.image10 = image10;
		this.rangeX = rangeX;
		this.rangeY = rangeY;
	}
	
	/**
	 * random move on the map
	 */
	@Override
    public void move(){
		checkCondition();
        if (moveX) {
        	x += speed;
        } else {
        	x -= speed;
        }
        if (moveY) {
        	y += speed;
        } else {
        	y -= speed;
        }
    }
	
	/**
	 * Check to move in what direction
	 */
	public void checkCondition() {
		if (x - 2 <= 2) {
			moveX = true;
		} else if (rangeX - x <= 100) {
			moveX = false;
		}
		if (y - 2 <= 2) {
			moveY = true;
		} else if (rangeY - y <= 100){
			moveY = false;
		}
	}
	
	
	/**
	 * get image of the object
	 * each 5-10 frame change the image
	 */
	@Override
	public BufferedImage getImage() {
		if (which <= 5) {
			this.which++;
			return image;
		} else if (which <= 10){
			this.which++;
			return image2;
		} else if (which <= 15){
			this.which++;
			return image3;
		} else if (which <= 20){
			this.which++;
			return image4;
		} else if (which <= 25){
			this.which++;
			return image5;
		} else if (which <= 30){
			this.which++;
			return image6;
		} else if (which <= 35){
			this.which++;
			return image7;
		} else if (which <= 40){
			this.which++;
			return image8;
		} else if (which <= 50){
			this.which++;
			return image9;
		} else {
			this.which = 1;
			return image10;
		}
    }
	
	/**
	 * the whiteWarrior never out if Bounds
	 */
	@Override
    public boolean outOfBounds() {
        return false;
    }
	
	/**
	 * the whiteWarrior never be shoot by m
	 */
	@Override
	public boolean shootBy(MovingObject m){
		return false;
	}
}
