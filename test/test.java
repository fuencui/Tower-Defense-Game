import static org.junit.Assert.*;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import Dot.greenWarrior;
import Dot.whiteWarrior;
import Dot.upDot;
import Enemy.finalZombieBoss;
import Enemy.orcs;
import Enemy.zombie;
import Enemy.zombieBoss;
import NoMovingObject.Hero;
import gameControl.gameControl;
import movingObject.Dot;
import movingObject.Enemy;

/**
 * CS 5004 final project test file
 */
public class test {
	private gameControl gameControl;
	
	@Before
	public void testSetup() {
		JFrame frame = new JFrame("Final project");
		gameControl = new gameControl(frame);
	}

	
	/**
	 * testImageRead
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testImageRead() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(gameControl.class.getResource("png/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(image.getWidth(), gameControl.background.getWidth());
		assertEquals(image.getHeight(), gameControl.background.getHeight());
	}
	
	/**
	 * testPlaceHero
	 */
	@Test
	public void testPlaceHero() {
		assertEquals(gameControl.placeHero(), true);
		for (int i = 0; i < 5; i ++) {
			gameControl.addHero('1', 1, 1);
			gameControl.placeHero();
		}
		assertEquals(gameControl.placeHero(), false);
		gameControl.addHero('1', 0, 0);
		gameControl.addMoveHero('4', 0, 0);
		gameControl.addGreenWarrior('5', 0, 0);
		assertTrue(gameControl.getDotList().isEmpty());
	}

	/**
	 * testAddHero
	 */
	@Test
	public void testAddHero() {
		assertEquals(gameControl.getHeroList().size(), 0);
		gameControl.addHero('1', 1, 1);
		gameControl.placeHero();
		gameControl.addHero('2', 2, 1);
		gameControl.placeHero();
		gameControl.addHero('3', 1, 1);
		assertEquals(gameControl.getHeroList().size(), 3);
	}
	
	/**
	 * testHero
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testHero() {
		assertEquals(gameControl.getHeroList().size(), 0);
		gameControl.addHero('1', 1, 2);
		gameControl.placeHero();
		assertEquals(gameControl.getHeroList().size(), 1);
		Hero tempHero = gameControl.getHeroList().get(0);
		assertEquals(tempHero.getX(), 1);
		assertEquals(tempHero.getY(), 2);
		BufferedImage image = null;
		try {
			image = ImageIO.read(gameControl.class.getResource("png/mage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(image.getWidth(), gameControl.mage.getWidth());
		assertEquals(image.getHeight(), gameControl.mage.getHeight());
	}
	
	/**
	 * testDot
	 */
	@Test
	public void testDot() {
		assertEquals(gameControl.getHeroList().size(), 0);
		gameControl.addHero('1', 20, 20);
		gameControl.placeHero();
		assertEquals(gameControl.getHeroList().size(), 1);
		gameControl.enterAction();
		BufferedImage image = null;
		BufferedImage image2 = gameControl.getDotList().get(0).getImage();
		try {
			image = ImageIO.read(gameControl.class.getResource("png/dot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(gameControl.getDotList().get(0) instanceof upDot);
		assertEquals(gameControl.getDotList().get(0).getX(), 0);
		assertEquals(gameControl.getDotList().get(0).getY(), 20);
		assertEquals(gameControl.getDotList().get(0).getWidth(), image.getWidth());
		assertEquals(gameControl.getDotList().get(0).getHeight(), image.getHeight());
		assertEquals(image.getWidth(), image2.getWidth());
		assertEquals(image.getHeight(), image2.getHeight());
		assertFalse(gameControl.getDotList().get(0).getRemove());
		gameControl.getDotList().get(0).shootBy(gameControl.getDotList().get(0));
		assertTrue(gameControl.getDotList().get(0).getRemove());
		assertFalse(gameControl.getDotList().get(0).outOfBounds());
		for (int i = 0; i < 30; i++) {
			gameControl.getDotList().get(0).move();
		}
		assertTrue(gameControl.getDotList().get(0).outOfBounds());
	}
	
	/**
	 * testAddMoveHero
	 */
	@Test
	public void testAddMoveHero() {
		assertEquals(gameControl.getDotList().size(), 0);
		gameControl.addMoveHero('4', 1, 1);
		assertTrue(gameControl.getDotList().get(0) instanceof whiteWarrior);
		gameControl.getDotList().get(0).move();
		assertEquals(gameControl.getDotList().get(0).getX(), 3);
		assertEquals(gameControl.getDotList().get(0).getY(), 3);
		assertFalse(gameControl.getDotList().get(0).getRemove());
		assertFalse(gameControl.getDotList().get(0).shootBy(
								gameControl.getDotList().get(0)));
	}
	
	/**
	 * testAddAttackSoldier
	 */
	@Test
	public void testAddAttackSoldier() {
		assertEquals(gameControl.getDotList().size(), 0);
		gameControl.addGreenWarrior('5', 2, 2);
		assertTrue(gameControl.getDotList().get(0) instanceof greenWarrior);
		gameControl.getDotList().get(0).move();
		assertEquals(gameControl.getDotList().get(0).getX(), 0);
		assertEquals(gameControl.getDotList().get(0).getY(), 2);
		gameControl.getDotList().get(0).move();
		assertTrue(gameControl.getDotList().get(0).outOfBounds());
		assertFalse(gameControl.getDotList().get(0).shootBy(
								gameControl.getDotList().get(0)));
		for (int i = 0; i < 51; i++) {
			gameControl.getDotList().get(0).getImage();
		}
		BufferedImage image = null;
		try {
			image = ImageIO.read(gameControl.class.getResource("png/a10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(gameControl.getDotList().get(0).getImage().getWidth(),
															image.getWidth());
	}
	
	/**
	 * testEnterEnemy
	 */
	@Test
	public void testEnterEnemy() {
		for (int i = 0; i < 71; i++) {
			gameControl.enterEnemy();
		}
		assertTrue(gameControl.getEnemyList().get(0) instanceof zombie);
		assertTrue(gameControl.getEnemyList().get(1) instanceof orcs);
		assertEquals(gameControl.getEnemyList().get(0).getX(), 200, 100);
		assertEquals(gameControl.getEnemyList().get(0).getY(), 0, 10);
		assertEquals(gameControl.getEnemyList().get(1).getX(), 200, 100);
		assertEquals(gameControl.getEnemyList().get(1).getY(), 0, 10);
		gameControl.stepAction();
		assertEquals(gameControl.getEnemyList().get(0).getY(), 3);
		assertEquals(gameControl.getEnemyList().get(1).getY(), 4);
		BufferedImage image = null;
		try {
			image = ImageIO.read(gameControl.class.getResource("png/zombie.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(gameControl.getEnemyList().get(0).getImage().getWidth(),
				image.getWidth());
		assertEquals(gameControl.getEnemyList().get(0).getWidth(),
				image.getWidth());
		assertEquals(gameControl.getEnemyList().get(0).getHeight(),
				image.getHeight());
		
		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(gameControl.class.getResource("png/Orc.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(gameControl.getEnemyList().get(1).getImage().getWidth(),
				image2.getWidth());
		
		for (int i = 0; i < 500; i++) {
			gameControl.enterEnemy();
			gameControl.stepAction();
		}
		assertEquals(gameControl.getEnemyList().size(), 23);
	}
	
	/**
	 * testCheckShoot
	 */
	@Test
	public void testCheckShoot() {
		for (int i = 0; i < 51; i++) {
			gameControl.enterEnemy();
		}
		for (int i = 0; i < 5; i ++) {
			gameControl.addHero('3', 125 + (i * 8), 100);
			gameControl.placeHero();
		}
		assertTrue(gameControl.getEnemyList().get(0) instanceof zombie);
		for (int i = 0; i < 101; i++) {
			gameControl.enterAction();
			gameControl.stepAction();
			gameControl.checkShoot();
			gameControl.outOfBoundsAction();
		}
		assertEquals(gameControl.getEnemyList().size(), 0);
		assertEquals(gameControl.getHeroList().size(), 5);
	}
	
	/**
	 * testZombieBoss
	 */
	@Test
	public void testZombieBoss() {
		BufferedImage image = null;
		BufferedImage zombieBoss = null;
		try {
			zombieBoss = 
					ImageIO.read(gameControl.class.getResource("png/zombieBoss.png")); 
			image = ImageIO.read(gameControl.class.getResource("png/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enemy zombie = new zombieBoss(50, 50, zombieBoss, image);
		Dot upDot = new upDot(50, 50, zombieBoss);
		assertFalse(zombie.shootBy(upDot));
		for (int i = 0; i < 300; i++) {
			zombie.shootBy(upDot);
		}
		assertEquals(zombie.shootBy(zombie), true);
	}
	
	/**
	 * testFinalZombieBoss
	 */
	@Test
	public void testFinalZombieBoss() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(gameControl.class.getResource("png/dot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		Enemy zombie = new finalZombieBoss(500, 500, image);
		Dot upDot = new upDot(501, 500, image);
		zombie.move();
		assertEquals(zombie.getY(), 501);
		zombie.right();
		assertEquals(zombie.getX(), 501);
		zombie.up();
		assertEquals(zombie.getY(), 500);
		assertFalse(zombie.shootBy(upDot));
		for (int i = 0; i < 70000; i++) {
			zombie.shootBy(upDot);
			zombie.getImage();
		}
		assertEquals(zombie.shootBy(zombie), true);
		
		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(gameControl.class.getResource("png/zw1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(zombie.getImage().getWidth(), image2.getWidth());
	}
	
	
	/**
	 * having trouble on testing listener
	 */
	/*
	@Test
	public void testAction() throws AWTException{
		
		gameControl.setFocusable(true);
		gameControl.requestFocus();
		Robot robot = new Robot();
		robot.mouseMove(500, 500);
		robot.mousePress(0);
		robot.mouseRelease(0);
		robot.mousePress(0);
		robot.mouseRelease(0);
		robot.mouseMove(1, 1);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		assertEquals(gameControl.getHeroList().size(), 1);
		
	}*/
}
