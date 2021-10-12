package NoMovingObject;

import java.awt.image.BufferedImage;
import java.util.List;



import movingObject.*;

/**
 * The Hero class implements NoMivingObject
 * @author cuifu
 */
public abstract class Hero implements NoMovingObject{
	protected List<Dot> dots;
	protected int x;
	protected int y;
	protected BufferedImage image;
	
	/**
	 * check the NoMovingObject interface comment
	 * @return check the interface comment
	 */
	public int getX() {
        return x;
    }
	
	/**
	 * check the NoMovingObject interface comment
	 */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
	 * check the NoMovingObject interface comment
	 * @return check the interface comment
	 */
    public int getY() {
        return y;
    }

    /**
	 * check the NoMovingObject interface comment
	 */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Hero object include a list of Dot
     * @return List<Dot> Hero's Bullet
     */
    public List<Dot> getDotsList(){
    	return this.dots;
    }
    
    /**
	 * check the NoMovingObject interface comment
	 * @return check the interface comment
	 */
    public BufferedImage getImage() {
        return image;
    }
    
    /**
	 * check the NoMovingObject interface comment
	 */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
