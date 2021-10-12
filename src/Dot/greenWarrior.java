package Dot;

import java.awt.image.BufferedImage;

import movingObject.*;

/**
 * The attack Soldier is the green warrior object extends Dot
 * The green soldier is a bullet that cannot be destroyed
 * @author cuifu
 */
public class greenWarrior extends Dot{
	private int speed = 2;
	private int which = 1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage image8;
	private BufferedImage image9;
	private BufferedImage image10;

	/**
	 * attack Soldier constructor
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
	 */
	public greenWarrior(int x, int y, BufferedImage image, BufferedImage image2,
				BufferedImage image3,BufferedImage image4,BufferedImage image5,
				BufferedImage image6,BufferedImage image7,BufferedImage image8,
				BufferedImage image9,BufferedImage image10){
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
	}
	
	/**
	 * move left
	 */
	@Override
    public void move(){
		x -= speed;
    }
	
	/**
	 * change the image every 5-10 frames
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
	 * if the object is moving to 0
	 * return true if the object is moving to 0
	 */
	@Override
    public boolean outOfBounds() {
        return this.x < 0;
    }
	
	/**
	 * the attack soldier is never be shoot
	 */
	@Override
	public boolean shootBy(MovingObject m){
		return false;
	}
}
