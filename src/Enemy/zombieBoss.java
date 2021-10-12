package Enemy;
import java.awt.image.BufferedImage;

import Dot.greenWarrior;
import Dot.whiteWarrior;
import movingObject.*;

/**
 * The small zombie Boss class extend enemy
 * @author cuifu
 */
public class zombieBoss extends Enemy{
	private int die = 0;
	
	/**
	 * small zombie boss constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 * @param bgImage background image
	 */
	public zombieBoss(int x, int y, BufferedImage image, BufferedImage bgImage) {
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.image = image;
		this.bgImage = bgImage;
		this.speed = 2;
	}
	
	/**
	 * since the small zombie boss has 300 HP
	 * override shootBy method
	 */
	@Override
    public boolean shootBy(MovingObject m){
        int tempx = m.getX();
        int tempy = m.getY();
        if (this.x<=tempx && tempx<=this.x+width
        				&& this.y<=tempy && tempy<=this.y+height){
        	if (m instanceof greenWarrior || m instanceof whiteWarrior) {
            	return true;
            } else {
	        	this.die++;
	        	if (die > 300) {
	            	return true;
	            } else {
	            	return false;
	            }
            }
        }
		return false;
	}
}