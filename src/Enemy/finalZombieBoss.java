package Enemy;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import gameControl.gameControl;
import movingObject.*;

/**
 * The final zombie boss object 
 * extends Enemy
 * @author cuifu
 */
public class finalZombieBoss extends Enemy{
	private int which = 1;
    public static BufferedImage zw1;
    public static BufferedImage zw2;
    public static BufferedImage zw3;
    public static BufferedImage zw4;
    public static BufferedImage zw5;
    public static BufferedImage zw6;
    public static BufferedImage zw7;
    public static BufferedImage zw8;
    public static BufferedImage zw9;
    public static BufferedImage zw10;
    public static BufferedImage za1;
    public static BufferedImage za2;
    public static BufferedImage za3;
    public static BufferedImage za4;
    public static BufferedImage za5;
    public static BufferedImage za6;
    public static BufferedImage za7;
    public static BufferedImage za8;
    
    static {
        try {
        	 zw1 = ImageIO.read(gameControl.class.getResource("png/zw1.png"));
             zw2 = ImageIO.read(gameControl.class.getResource("png/zw2.png"));
             zw3 = ImageIO.read(gameControl.class.getResource("png/zw3.png"));
             zw4 = ImageIO.read(gameControl.class.getResource("png/zw4.png"));
             zw5 = ImageIO.read(gameControl.class.getResource("png/zw5.png"));
             zw6 = ImageIO.read(gameControl.class.getResource("png/zw6.png"));
             zw7 = ImageIO.read(gameControl.class.getResource("png/zw7.png"));
             zw8 = ImageIO.read(gameControl.class.getResource("png/zw8.png"));
             zw9 = ImageIO.read(gameControl.class.getResource("png/zw9.png"));
             zw10 = ImageIO.read(gameControl.class.getResource("png/zw10.png"));
             za1 = ImageIO.read(gameControl.class.getResource("png/za1.png"));
             za2 = ImageIO.read(gameControl.class.getResource("png/za2.png"));
             za3 = ImageIO.read(gameControl.class.getResource("png/za3.png"));
             za4 = ImageIO.read(gameControl.class.getResource("png/za4.png"));
             za5 = ImageIO.read(gameControl.class.getResource("png/za5.png"));
             za6 = ImageIO.read(gameControl.class.getResource("png/za6.png"));
             za7 = ImageIO.read(gameControl.class.getResource("png/za7.png"));
             za8 = ImageIO.read(gameControl.class.getResource("png/za8.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
	
    /**
     * final zombie boss constructor
	 * @param x x coordinates
	 * @param y y coordinates
     * @param bgImage background image
     */
	public finalZombieBoss(int x, int y, BufferedImage bgImage) {
		this.x = x;
		this.y = y;
		this.width = zw1.getWidth();
		this.height = zw1.getHeight();
		this.bgImage = bgImage;
		this.speed = 1;
	}
	
	/**
	 * Check comments from the interface
	 */
	@Override
	public void move() {
		if (which < 70) {
			y += speed;
		}
	}
	
	/**
	 * Check comments from the interface
	 */
	@Override
	public void right() {
		if (which < 70) {
			x += speed;
		}
	}
	
	/**
	 * Check comments from the interface
	 */
	@Override
	public void up() {
		if (which < 70) {
			y -= speed;
		}
	}
	
	/**
	 * Check comments from the interface
	 */
	@Override
	public BufferedImage getImage() {
		if (which <= 5) {
			this.which++;
			return zw1;
		} else if (which <= 10){
			this.which++;
			return zw2;
		} else if (which <= 15){
			this.which++;
			return zw3;
		} else if (which <= 20){
			this.which++;
			return zw4;
		} else if (which <= 25){
			this.which++;
			return zw5;
		} else if (which <= 30){
			this.which++;
			return zw6;
		} else if (which <= 35){
			this.which++;
			return zw7;
		} else if (which <= 40){
			this.which++;
			return zw8;
		} else if (which <= 50){
			this.which++;
			return zw9;
		} else if (which <= 60) {
			this.which++;
			return zw10;
		} else if (which <= 70){
			this.which++;
			return za1;
		} else if (which <= 80){
			this.which++;
			return za2;
		} else if (which <= 90){
			this.which++;
			return za3;
		} else if (which <= 100){
			this.which++;
			return za4;
		} else if (which <= 110){
			this.which++;
			return za5;
		} else if (which <= 120){
			this.which++;
			return za6;
		} else if (which <= 130){
			this.which++;
			return za7;
		} else {
			this.which = 1;
			return za8;
		}
    }

	/**
	 * since the final zombie boss has 70000 HP
	 * override shootBy method
	 */
	@Override
    public boolean shootBy(MovingObject m){
        int tempx = m.getX();
        int tempy = m.getY();
        if (this.x<=tempx && tempx<=this.x+width
        				&& this.y<=tempy && tempy<=this.y+height){
        	this.HP--;
        	if (this.HP <= 0) {
    			return true;
    		} else {
    			return false;
    		}
        }
		return false;		 
	}
}