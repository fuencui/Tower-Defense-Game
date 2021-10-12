package gameControl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JFrame;
import javax.swing.JPanel;

import Dot.*;
import Enemy.*;

import javax.imageio.ImageIO;

import movingObject.*;
import NoMovingObject.*;
import bgm.PlayMusic;

/**
 * The gameControl of the game
 * Link each class into game implementing the game
 * @author cuifu
 */
@SuppressWarnings("serial")
public class gameControl extends JPanel{
	// Basic variable
	private Frame frame;
	private boolean placeHero = true;
	private boolean finalZombie = false;
	private int x;
	private int y;
	private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Dot> dotsList = new ArrayList<>();
    private ArrayList<Hero> HeroList= new ArrayList<>();
	// state and background variable
	public static int WIDTH = 0;
    public static int HEIGHT = 0;
    private int state;
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int GAME_OVER = 2;
    private static final int GAME_OVER_PLAYER = 3;
    // gaming variable
    private int money = 500;
    private int score = 0;
    private int life = 20;
    private Timer timer;
    private int intervel = 1000 / 100;
    // image variable
    public static BufferedImage background;
    public static BufferedImage start;
    public static BufferedImage gameover;
    public static BufferedImage gameoverplayer;
    public static BufferedImage dot;
    public static BufferedImage downdot;
    public static BufferedImage lifedot;
    public static BufferedImage rightdot;
    public static BufferedImage Larr;
    public static BufferedImage Rarr;
    public static BufferedImage sword;
    public static BufferedImage mage;
    public static BufferedImage ranged;
    public static BufferedImage warrior;
    public static BufferedImage zombie;
    public static BufferedImage orcs;
    public static BufferedImage zombieBoss;
    public static BufferedImage h1;
    public static BufferedImage h2;
    public static BufferedImage h3;
    public static BufferedImage h4;
    public static BufferedImage h5;
    public static BufferedImage h6;
    public static BufferedImage h7;
    public static BufferedImage h8;
    public static BufferedImage h9;
    public static BufferedImage h10;
    public static BufferedImage a1;
    public static BufferedImage a2;
    public static BufferedImage a3;
    public static BufferedImage a4;
    public static BufferedImage a5;
    public static BufferedImage a6;
    public static BufferedImage a7;
    public static BufferedImage a8;
    public static BufferedImage a9;
    public static BufferedImage a10;
    // read each image file
    static {
        try {
            background = ImageIO.read(gameControl.class.getResource("png/background.png"));
            start = ImageIO.read(gameControl.class.getResource("png/start.png"));
            gameover = ImageIO.read(gameControl.class.getResource("png/gameover.png"));
            gameoverplayer = ImageIO.read(gameControl.class.getResource("png/gameoverplayer.png"));
            zombie = ImageIO.read(gameControl.class.getResource("png/zombie.png"));
            dot = ImageIO.read(gameControl.class.getResource("png/dot.png"));
            downdot = ImageIO.read(gameControl.class.getResource("png/Dfiredot.png"));
            lifedot = ImageIO.read(gameControl.class.getResource("png/Lfiredot.png"));
            rightdot = ImageIO.read(gameControl.class.getResource("png/Rfiredot.png"));
            Larr = ImageIO.read(gameControl.class.getResource("png/Larr.png"));
            Rarr = ImageIO.read(gameControl.class.getResource("png/Rarr.png"));
            sword = ImageIO.read(gameControl.class.getResource("png/sword.png"));
            mage = ImageIO.read(gameControl.class.getResource("png/mage.png"));
            ranged = ImageIO.read(gameControl.class.getResource("png/ranged.png"));
            warrior = ImageIO.read(gameControl.class.getResource("png/warrior.png"));
            orcs = ImageIO.read(gameControl.class.getResource("png/Orc.png"));
            zombieBoss = ImageIO.read(gameControl.class.getResource("png/zombieBoss.png"));
            h1 = ImageIO.read(gameControl.class.getResource("png/h1.png"));
            h2 = ImageIO.read(gameControl.class.getResource("png/h2.png"));
            h3 = ImageIO.read(gameControl.class.getResource("png/h3.png"));
            h4 = ImageIO.read(gameControl.class.getResource("png/h4.png"));
            h5 = ImageIO.read(gameControl.class.getResource("png/h5.png"));
            h6 = ImageIO.read(gameControl.class.getResource("png/h6.png"));
            h7 = ImageIO.read(gameControl.class.getResource("png/h7.png"));
            h8 = ImageIO.read(gameControl.class.getResource("png/h8.png"));
            h9 = ImageIO.read(gameControl.class.getResource("png/h9.png"));
            h10 = ImageIO.read(gameControl.class.getResource("png/h10.png"));
            a1 = ImageIO.read(gameControl.class.getResource("png/a1.png"));
            a2 = ImageIO.read(gameControl.class.getResource("png/a2.png"));
            a3 = ImageIO.read(gameControl.class.getResource("png/a3.png"));
            a4 = ImageIO.read(gameControl.class.getResource("png/a4.png"));
            a5 = ImageIO.read(gameControl.class.getResource("png/a5.png"));
            a6 = ImageIO.read(gameControl.class.getResource("png/a6.png"));
            a7 = ImageIO.read(gameControl.class.getResource("png/a7.png"));
            a8 = ImageIO.read(gameControl.class.getResource("png/a8.png"));
            a9 = ImageIO.read(gameControl.class.getResource("png/a9.png"));
            a10 = ImageIO.read(gameControl.class.getResource("png/a10.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
	
    /**
     * gameControl constructor
     * @param frame GUI interface
     */
	public gameControl(Frame frame) {
		this.frame = frame;
		PlayMusic p = new PlayMusic();
		p.playMuisc();
		WIDTH = background.getWidth();
		HEIGHT = background.getHeight();
		
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
        frame.setAlwaysOnTop(true); 
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	/**
	 * Controls whether the game starts
	 */
	public void startGame() {
		this.action();
	}
	
	/**
	 * Check if the player is eligible to place a hero
	 * @return true if the player is able to place a hero
	 */
	public boolean placeHero() {
    	if (this.money >= 100) {
    		this.placeHero = true;
    	} else {
    		this.placeHero = false;
    	}
    	return this.placeHero;
    }
	
	/**
	 * add a hero to the game
	 * @param i Determine the hero identity variable
	 * @param x determine the hero location x coordinates
	 * @param y determine the hero location y coordinates
	 */
	public void addHero(char i, int x, int y) {
	   	if (!placeHero) {
	    		return;
    	}
	   	if (i == '1') {
	   		this.HeroList.add(new mage(x, y, mage, dot, downdot, lifedot, rightdot));
	    } else if (i == '2') {
	    	this.HeroList.add(new hunter(x, y, ranged, Larr, Rarr));
	   	}
	  	else if (i == '3') {
	    	this.HeroList.add(new warrior(x, y, warrior, sword));
	    }
	   	this.placeHero = false;
	   	this.money -= 100;
	}

	/**
	 * add a whiteWarrior hero to the game
	 * @param i Determine the hero identity variable
	 * @param x determine the hero location x coordinates
	 * @param y determine the hero location y coordinates
	 */
	public void addMoveHero(char i, int x, int y) {
		if (!placeHero) {
	   		return;
		}
		if (i == '4') {
		 this.dotsList.add(new whiteWarrior(x, y, h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,
				 			background.getWidth(), background.getHeight()));
		}
		this.placeHero = false;
	    this.money -= 100;
	}
	
	/**
	 * add a GreenWarrior hero to the game
	 * @param i Determine the hero identity variable
	 * @param x determine the hero location x coordinates
	 * @param y determine the hero location y coordinates
	 */
	public void addGreenWarrior(char i, int x, int y) {
		if (!placeHero) {
	    	return;
		}
		if (i == '5') {
			this.dotsList.add(new greenWarrior(x, y, a1,a2,a3,a4,a5,
					 							a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x, y - 100, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x, y + 100, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x, y - 200, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x, y + 200, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x - 100, y - 50, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
		    this.dotsList.add(new greenWarrior(x - 100, y + 50, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x - 100, y - 150, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x - 100, y + 150, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 100, y - 50, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 100, y + 50, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 100, y - 150, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 100, y + 150, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x - 200, y - 100, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x - 200, y + 100, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x - 200, y, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 200, y - 100, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 200, y + 100, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
			this.dotsList.add(new greenWarrior(x + 200, y, a1,a2,a3,a4,a5,
						a6,a7,a8,a9,a10));
		}
		this.placeHero = false;
	    this.money -= 100;
	}
	 
	/**
	 * Call the GUI paint method
	 * draw each frame under the following order
	 */
	@Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        paintHero(g);
        paintEnemy(g);
        paintDots(g);
        paintScore(g);
        paintState(g);
    }
	
	/**
	 * draw the score money and life
	 * if the final zombie boss in the game
	 * draw the left HP of zombie
	 * @param g graphics interface
	 */
	public void paintScore(Graphics g) {
        int x = 10;
        int y = 25;
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        g.setColor(new Color(250,50,50));
        g.setFont(font);
        g.drawString("SCORE:" + score, x, y);
        y += 20;
        g.drawString("LIFE:" + this.life, x, y);
        y += 20;
        g.drawString("GOLD:" + this.money, x, y);
        if (this.finalZombie && state == RUNNING) {
        	Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 70);
        	g.setColor(new Color(250,50,50));
            g.setFont(font2);
        	g.drawString("Zombie HP:" +
        			enemyList.get(enemyList.size() - 1).getHP(), 600, 100);
        }
    }

	/**
	 * draw the state of the game 
	 * @param g graphics interface
	 */
    public void paintState(Graphics g) {
        if (state == START) {
            g.drawImage(start, 0, 0, null);
        } else if (state == GAME_OVER) {
            g.drawImage(gameover, 0, 0, null);
        } else if (state == GAME_OVER_PLAYER) {
            g.drawImage(gameoverplayer, 0, 0, null);
        }
    }

    /**
     * method to draw each hero in the hero list
     * @param g graphics interface
     */
    public void paintHero(Graphics g) {
    	int i;
    	for (i = 0; i < this.HeroList.size(); i++) {
    		g.drawImage(this.HeroList.get(i).getImage(),
    				    this.HeroList.get(i).getX(), 
    				    this.HeroList.get(i).getY(), null);
    	}
    }
    
    /**
     * method to draw each enemy in the enemy list
     * @param g graphics interface
     */
    public void paintEnemy(Graphics g) {
    	int i;
    	for (i = 0; i < this.enemyList.size(); i++) {
    		g.drawImage(this.enemyList.get(i).getImage(),
    				    this.enemyList.get(i).getX(), 
    				    this.enemyList.get(i).getY(), null);
    	}
    }
    
    /**
     * method to draw each Dot in the Dot list
     * @param g graphics interface
     */
    public void paintDots(Graphics g) {
        for (int i = 0; i < this.dotsList.size(); i++) {
            g.drawImage(this.dotsList.get(i).getImage(), 
            			this.dotsList.get(i).getX(),
            			this.dotsList.get(i).getY(),
                        null);
        }
    }
    int dotsIndex = 0;
    public void enterAction() {
        if (dotsIndex % 100 == 0) {
            int i;
            int j;
            for (i = 0; i < this.HeroList.size(); i++) {
            	for (j = 0; j < this.HeroList.get(i).getDotsList().size(); j++) {
            		Dot tempDot = this.HeroList.get(i).getDotsList().get(j);
            		if (tempDot instanceof upDot) {
            			this.dotsList.add(new upDot(tempDot.getX(),
            					                    tempDot.getY(),
            					                    tempDot.getImage()));
            		} else if (tempDot instanceof downDot) {
            			this.dotsList.add(new downDot(tempDot.getX(),
            					                    tempDot.getY(),
            					                    tempDot.getImage()));
            		} else if (tempDot instanceof leftDot) {
            			this.dotsList.add(new leftDot(tempDot.getX(),
            					                    tempDot.getY(),
            					                    tempDot.getImage()));
            		} else if (tempDot instanceof rightDot) {
            			this.dotsList.add(new rightDot(tempDot.getX(),
			                    tempDot.getY(),
			                    tempDot.getImage()));
            		} else if (tempDot instanceof leftMeleeDot) {
            			this.dotsList.add(new leftMeleeDot(tempDot.getX(),
    		                    tempDot.getY(),
    		                    tempDot.getImage()));
                	}	
            	}
            	
            }
        }
        dotsIndex++;
    }
    
    /**
     * place a enemy to the enemyList in the gameControl
     * The higher the score the faster the zombies are be created
     * finally the zombie boss will be added then not other zombies is added
     */
    int enemyIndex = 0;
    public void enterEnemy() {
    	Random random = new Random();
    	int topX = random.nextInt(125) + 165;
    	enemyIndex++;
    	if (this.score < 200) {
			if (enemyIndex % 40 == 0) {
				this.enemyList.add(new zombie(topX, 0, zombie, background));
			}
			if (enemyIndex % 60 == 0) {
				this.enemyList.add(new orcs(topX, 0, orcs, background));
			}
    	} else if (this.score < 400 && this.score >= 200) {
    		if (enemyIndex % 10 == 0) {
				this.enemyList.add(new zombie(topX, 0, zombie, background));
			}
    		if (enemyIndex % 20 == 0) {
				this.enemyList.add(new orcs(topX, 0, orcs, background));
			}
    		if (enemyIndex % 40 == 0) {
				this.enemyList.add(new zombieBoss(topX, 0, zombieBoss, background));
			}
    	} else if (this.score < 1500 && this.score >= 400){
    		if (enemyIndex % 7 == 0) {
				this.enemyList.add(new zombie(topX, 0, zombie, background));
			}
    		if (enemyIndex % 7 == 0) {
				this.enemyList.add(new orcs(topX, 0, orcs, background));
			}
    		if (enemyIndex % 7 == 0) {
				this.enemyList.add(new zombieBoss(topX, 0, zombieBoss, background));
			}
    	} else if (this.score >= 1500){
    		if (!this.finalZombie) {
        		this.enemyList.add(new finalZombieBoss(150, 0, background));
        		this.finalZombie = true;
        	}
    	}
    }
    
    /**
     * Guide each zombie on a designed way to walk
     * since the zombie boss is too big
     * it has an unique Guide
     */
    public void stepAction() {
        for (int i = 0; i < dotsList.size(); i++) {
        	dotsList.get(i).move();
        }
        for (int j = 0; j < enemyList.size(); j++) {
        	Random random = new Random();
        	int r = random.nextInt(130) + 400;
        	Random random2 = new Random();
        	int u = random2.nextInt(130) + 590;
        	Random random3 = new Random();
        	int r2 = random3.nextInt(130) + 290;
        	Random random4 = new Random();
        	int m = random4.nextInt(120) + 1420;
        	Random random5 = new Random();
        	int r3 = random5.nextInt(110) + 420;
        	if (!(enemyList.get(j) instanceof finalZombieBoss)) {
	        	if (enemyList.get(j).getY() < r && enemyList.get(j).getX() < 300) {
	        		enemyList.get(j).move();
	        	} else if (enemyList.get(j).getY() > r  && enemyList.get(j).getX() < u){
	        		enemyList.get(j).right();
	        	} else if (enemyList.get(j).getY() > r2  && enemyList.get(j).getX() >= u 	                                 
			                                 && enemyList.get(j).getX() < 720) {
	        		enemyList.get(j).up();
	        	} else if (enemyList.get(j).getY() < r2  && enemyList.get(j).getX() < m) {
	        		enemyList.get(j).right();
	        	} else if (enemyList.get(j).getY() < r3  && enemyList.get(j).getX() >= m) {
	        		enemyList.get(j).move();
	        	} else if (enemyList.get(j).getY() > r3  && enemyList.get(j).getX() >= m
	        			&& enemyList.get(j).getX() < WIDTH) { 
	        		enemyList.get(j).right();
	        	}
        	} else {
        		if (enemyList.get(j).getY() < 400 && enemyList.get(j).getX() < 300) {
	        		enemyList.get(j).move();
	        	} else if (enemyList.get(j).getY() >= 400  && enemyList.get(j).getX() < 590){
	        		enemyList.get(j).right();
	        	} else if (enemyList.get(j).getY() > 290  && enemyList.get(j).getX() >= 590 	                                 
			                                 && enemyList.get(j).getX() < 720) {
	        		enemyList.get(j).up();
	        	} else if (enemyList.get(j).getY() < 300  && enemyList.get(j).getX() < 1420) {
	        		enemyList.get(j).right();
	        	} else if (enemyList.get(j).getY() < 500  && enemyList.get(j).getX() >= 1420) {
	        		enemyList.get(j).move();
	        	} else if (enemyList.get(j).getY() >= 500  && enemyList.get(j).getX() >= 1420
	        			&& enemyList.get(j).getX() < WIDTH) { 
	        		enemyList.get(j).right();
	        	}
        	}
        }
    }
    
    /**
     * check each zombie is shoot by a dot object
     * if the zombie is be shoot then it may needed to remove
     * if the zombie not be shoot or still has HP then it won't be remove
     */
    public void checkShoot() {
    	int i;
    	int j;
    	int eneIndex = -1;
    	int dotIndex = -1;
    	for (i = 0; i < enemyList.size(); i++) {
    		for (j = 0; j < dotsList.size(); j++) {
    			if (enemyList.get(i).shootBy(dotsList.get(j))) {
    				eneIndex = i;
    				dotIndex = j;
    				break;
    			}
    		}
    	}
    	// remove the zombie
    	if (eneIndex != -1) {
    		if (!(enemyList.get(eneIndex) instanceof finalZombieBoss)) {
    			enemyList.remove(eneIndex);
    		} else {
    			state = GAME_OVER_PLAYER;
    		}
    		if (!(dotsList.get(dotIndex) instanceof leftMeleeDot) 
    			&& !(dotsList.get(dotIndex) instanceof whiteWarrior)
    			&& !(dotsList.get(dotIndex) instanceof greenWarrior)){
    			dotsList.remove(dotIndex);
    		}
    		this.score += 5;
    		this.money += 5;
    	}
    }
    
    /**
     * check if the game is over
     * swith the state if game is over
     */
    public boolean isGameOver() {
    	if (this.life <= -1) {
    		this.state = GAME_OVER;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * check if a zombie is out of bound
     * if the zombie is out of bound then remove from the list
     * if the zombie boss is out of bound means the pleyer loss the game
     */
    public void outOfBoundsAction() {
    	 for (int i = 0; i < dotsList.size(); i++) {
    		 if (dotsList.get(i).outOfBounds()) {
    			 this.dotsList.remove(i);
    		 }
    	 }
    	 for (int j = 0; j < enemyList.size(); j++) {
    		 if (enemyList.get(j).outOfBounds()) {
    			 this.life--;
    			 if (!(enemyList.get(j) instanceof finalZombieBoss)) {
    				 this.enemyList.remove(j);
    			 } else {
    				 state = GAME_OVER;
    			 }
    		 }
    	 }
    }
    
    /**
     * check each frame
     * include keyboard listener and mouse listener
     * Pass player instructions to each method like add hero
     * call repaint by a timer draw each frame
     */
    public void action() {
		MouseAdapter l = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (state == RUNNING) {
                    x = e.getX();
                    y = e.getY();
                    if (placeHero) {
                    	KeyAdapter k = new KeyAdapter() {
                        	@Override
                        	public void keyPressed(KeyEvent key) {
                        		char c = key.getKeyChar();
                        		if (c == '1' || c == '2' || c == '3') {
                        			addHero(c, x, y);
                        		} else if(c == '4') {
                        			addMoveHero(c, x, y);
	                        	} else if(c == '5') {
	                        		addGreenWarrior(c,
	                        				background.getWidth(), y);
	                    		}
                        	}
                		};
                		frame.addKeyListener(k);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                switch (state) {
                case START:
                    state = RUNNING;
                    break;
                case GAME_OVER:
                	enemyList = new ArrayList<>();
                	dotsList = new ArrayList<>();
                	HeroList = new ArrayList<>();
                    break;
                case GAME_OVER_PLAYER:
                	enemyList = new ArrayList<>();
                	dotsList = new ArrayList<>();
                	HeroList = new ArrayList<>();
                    break;
                }
            }
        };
        this.addMouseListener(l);
        this.addMouseMotionListener(l);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state == RUNNING) {
                	placeHero();
                    enterAction();
                    enterEnemy();
                    stepAction();
                    checkShoot();
                    outOfBoundsAction();
                    isGameOver();
                }
                repaint();
            }

        }, intervel, intervel);
    }
    
    //getter for test
    /**
     * get EnemyList of the gameControl
     * @return this.enemyList 
     */
    public List<Enemy> getEnemyList(){
    	return this.enemyList;
    }
    
    /**
     * get dotsList of the gameControl
     * @return this.dotsList 
     */
    public List<Dot> getDotList(){
    	return this.dotsList;
    }
    
    /**
     * get HeroList of the gameControl
     * @return this.HeroList 
     */
    public List<Hero> getHeroList(){
    	return this.HeroList;
    }
}
