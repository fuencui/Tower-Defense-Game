package NoMovingObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Dot.*;
import movingObject.*;

public class mage extends Hero{
	
	/**
	 * Mage constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 * @param d  d image of the four bullets
	 * @param dd dd image of the four bullets
	 * @param ld ld image of the four bullets
	 * @param rd rd image of the four bullets
	 */
	public mage(int x, int y, BufferedImage image, BufferedImage d, BufferedImage dd,
			BufferedImage ld, BufferedImage rd) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.dots = setDot(x, y, d, dd, ld, rd);
	}
	
	/**
	 * setup hero Dot list
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param d  d image of the four bullets
	 * @param dd dd image of the four bullets
	 * @param ld ld image of the four bullets
	 * @param rd rd image of the four bullets
	 * @return List<Dot> for gameController to use
	 */
	public List<Dot> setDot(int x, int y, BufferedImage d, BufferedImage dd,
			BufferedImage ld, BufferedImage rd) {
		List<Dot> dots = new ArrayList<>();
		dots.add(new upDot(x - 20, y, d));
		dots.add(new upDot(x, y, d));
		dots.add(new upDot(x + 20, y, d));
		dots.add(new downDot(x - 20, y + 50, dd));
		dots.add(new downDot(x, y + 50, dd));
		dots.add(new downDot(x + 20, y + 50, dd));
		dots.add(new leftDot(x - 20, y, ld));
		dots.add(new leftDot(x - 20, y + 20, ld));
		dots.add(new leftDot(x - 20, y + 40, ld));
		dots.add(new rightDot(x + 20, y, rd));
		dots.add(new rightDot(x + 20, y + 20, rd));
		dots.add(new rightDot(x + 20, y + 40, rd));
		
		return dots;
	}
	
}
