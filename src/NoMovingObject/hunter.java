package NoMovingObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Dot.*;
import movingObject.*;

/**
 * Hunter object extends Hero class
 * @author cuifu
 */
public class hunter extends Hero{
	
	/**
	 * Hunter constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 * @param ld ld image of the four bullets
	 * @param rd rd image of the four bullets
	 */
	public hunter(int x, int y, BufferedImage image, BufferedImage ld,
			                             BufferedImage rd) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.dots = setDot(x, y, ld, rd);
	}
	
	/**
	 * setup hunter dot list 
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param ld ld image of the four bullets
	 * @param rd rd image of the four bullets
	 * @return List<Dot> for gameController to use
	 */
	public List<Dot> setDot(int x, int y,
			               BufferedImage ld, BufferedImage rd) {
		List<Dot> dots = new ArrayList<>();
		dots.add(new leftDot(x - 20, y - 20, ld));
		dots.add(new leftDot(x - 20, y, ld));
		dots.add(new leftDot(x - 20, y + 20, ld));
		dots.add(new leftDot(x - 20, y + 40, ld));
		dots.add(new leftDot(x - 20, y + 60, ld));
		dots.add(new rightDot(x + 20, y - 20, rd));
		dots.add(new rightDot(x + 20, y, rd));
		dots.add(new rightDot(x + 20, y + 20, rd));
		dots.add(new rightDot(x + 20, y + 40, rd));
		dots.add(new rightDot(x + 20, y + 60, rd));
		return dots;
	}
	
}