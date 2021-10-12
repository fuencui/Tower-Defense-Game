package movingObject;

import java.awt.image.BufferedImage;

/**
 * The Dot object is the Hero's Bullet implements movingObject
 * @author cuifu
 */
public abstract class Dot implements MovingObject{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean remove = false;
	protected BufferedImage image;
	
	/**
	 * get X coordinate
	 * @return x corrdinate
	 */
	public int getX() {
        return x;
    }
	
	/**
	 * set X coordinate
	 */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
	 * get Y coordinate
	 * @return y corrdinate
	 */
    public int getY() {
        return y;
    }
    
    /**
	 * set Y coordinate
	 */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
	 * getter of width
	 * @return int of width
	 */
    public int getWidth() {
        return width;
    }
    
    /**
	 * setup the object width
	 * @param width int of width
	 */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
	 * getter of Height
	 * @return int of Height
	 */
    public int getHeight() {
        return height;
    }
    
    /**
	 * setup the object Height
	 * @param width int of Height
	 */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
	 * get the bufferedImage
	 * @return A Image file of this object
	 */
    public BufferedImage getImage() {
        return image;
    }
    
    /**
     * setup the bufferedImage
     * @param image the bufferedImage setup
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * check is the object need to remove from the game
     * @return true if the object is needed to remove
     */
    public boolean getRemove() {
		return this.remove;
	}
    
    /**
     * check if the object is shoot by other moving object
     * @param m another moving object
     * @return true if the this object is shoot by moving object m
     */
    @Override
    public boolean shootBy(MovingObject m){
        int x = m.getX();
        int y = m.getY();
        return remove = x<this.x+width && y<this.y+height;
    }
}
