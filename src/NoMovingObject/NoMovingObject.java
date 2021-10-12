package NoMovingObject;

/**
 * Represents interfaces for all immovable objects
 */
import java.awt.image.BufferedImage;

public interface NoMovingObject {
	
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
	 * get the bufferedImage
	 * @return A Image file of this object
	 */
    public BufferedImage getImage();
    
    /**
     * setup the bufferedImage
     * @param image the bufferedImage setup
     */
    public void setImage(BufferedImage image);
}
