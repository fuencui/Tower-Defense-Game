package NoMovingObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Dot.*;
import movingObject.*;

/**
 * The warrior object extends Hero class
 * @author cuifu
 */
public class warrior extends Hero{
	
	/**
	 * warrior constructor
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 * @param s weapon image
	 */
	public warrior(int x, int y, BufferedImage image, BufferedImage s) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.dots = setDot(x, y, s);
	}
	
	/**
	 * setup hero Dot list
	 * @param x x coordinates
	 * @param y y coordinates
	 * @param image object image
	 * @return List<Dot> for gameController to use
	 */
	public List<Dot> setDot(int x, int y, BufferedImage s){
		List<Dot> dots = new ArrayList<>();	
		dots.add(new leftMeleeDot(x + 75, y - 70, s));
		return dots;
	}
	
}