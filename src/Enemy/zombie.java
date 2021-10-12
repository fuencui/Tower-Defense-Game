package Enemy;
import java.awt.image.BufferedImage;
import movingObject.*;

/**
 * zombie object class extend enemy
 * @author cuifu
 */
public class zombie extends Enemy{
	
	/**
	 * zombie constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 * @param bgImage background image
	 */
	public zombie(int x, int y, BufferedImage image, BufferedImage bgImage) {
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.image = image;
		this.bgImage = bgImage;
		this.speed = 3;
	}
	
}
