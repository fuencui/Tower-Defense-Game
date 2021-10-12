import javax.swing.JFrame;

import gameControl.*;

/**
 * The hero vs zombie game driver
 * @author cuifu
 * cs5004 final project
 */
public class Driver{
	public static void main(String [] args) {
		JFrame frame = new JFrame("Final project");
		gameControl game = new gameControl(frame);
		game.startGame();
	}
}