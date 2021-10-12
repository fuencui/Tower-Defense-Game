package movingObject;

import java.awt.image.BufferedImage;

/**
 * Interfaces represent all moving objects
 * @author cuifu
 */
public interface MovingObject {
	
	/**
	 * get X coordinate
	 * @return x corrdinate
	 */
	public int getX();
	
	/**
	 * set X coordinate
	 */
	public void setX(int x);
	
	/**
	 * get Y coordinate
	 * @return y corrdinate
	 */
	public int getY();
	
	/**
	 * set Y coordinate
	 */
	public void setY(int y);
	
	/**
	 * setup the object width
	 * @param width int of width
	 */
	public void setWidth(int width);
	
	/**
	 * getter of width
	 * @return int of width
	 */
	public int getWidth();
	
	/**
	 * setup the object Height
	 * @param width int of Height
	 */
	public void setHeight(int height);
   
    
    /**
	 * getter of Height
	 * @return int of Height
	 */
	public int getHeight();
	
	/**
	 * get the bufferedImage
	 * @return A Image file of this object
	 */
    public BufferedImage getImage();
    
    /**
     * setup the bufferedImage
     * @param image the bufferedImage setup
     */
    public void setImage(BufferedImage image);
    
    /**
     * check if the object is out of background bounds
     * @return ture if the object is out of background
     */
    public boolean outOfBounds();
    
    /**
     * Each frame moves the object
     * change the x and y coordinate
     */
    public void move();
    
    /**
     * check if the object is shoot by other moving object
     * @param m another moving object
     * @return true if the this object is shoot by moving object m
     */
    public boolean shootBy(MovingObject m);
}
