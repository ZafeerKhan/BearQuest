/* Package: bearGameMerge
 * Class: MainGame
 * Programmer: ICS4U
 * Date Created: January 4, 2016
 * Description: Main applet of bear game.
 */
package bearGameMerge2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Timer;

import javax.imageio.ImageIO;

//import in_out.Out;

public class MainGame extends Applet implements Runnable, MouseListener {

	private static final long serialVersionUID = 1L;

	//Variables for images
	BufferedImage grassPhoto = null;
	BufferedImage treePhoto = null;
	BufferedImage deerPhoto = null;
	BufferedImage gravePhoto = null;
	BufferedImage berryBushPhoto = null;
	BufferedImage berryBushEmptyPhoto = null;
	BufferedImage waterPhoto = null;
	BufferedImage gWBPhoto = null;
	BufferedImage gWTPhoto = null;
	BufferedImage grassWatBotRigPhoto = null;
	BufferedImage grassWatTopRightPhoto = null;
	BufferedImage grassWatTopLeftPhoto = null;
	BufferedImage grassWatBotLeftPhoto = null;
	BufferedImage gWRPhoto = null;
	BufferedImage gWLPhoto = null;
	BufferedImage grassWatTopAndRigPhoto = null;
	BufferedImage grassWatTopAndLefPhoto = null;
	BufferedImage grassWatBotAndRigPhoto = null;
	BufferedImage grassWatBotAndLefPhoto = null;
	BufferedImage hunterPhoto = null;
	BufferedImage cave1Photo = null;
	BufferedImage cave2Photo = null;
	BufferedImage cave3Photo = null;
	BufferedImage cave4Photo = null;
	BufferedImage cave5Photo = null;
	BufferedImage bearFrontPhoto = null;
	BufferedImage bearBackPhoto = null;
	BufferedImage bearLeftPhoto = null;
	BufferedImage bearRightPhoto = null;
	BufferedImage mainMenuPhoto = null;
	BufferedImage buttonScorePhoto = null;
	BufferedImage buttonInstPhoto = null;
	BufferedImage buttonPlayPhoto = null;
	BufferedImage instructionsPhoto = null;
	BufferedImage highScoresPhoto = null;
	BufferedImage returnToMenuPhoto = null;
	BufferedImage losePhoto = null;
	BufferedImage winScreenPhoto = null;
	BufferedImage gretelPhoto = null;
	BufferedImage loadingPhoto = null;
	BufferedImage backButtonPhoto = null;
	
	// Mouse Clicking
	int xpos;
	int ypos;
	int x;
	int y;
	int letterPos = 0;
	boolean mouseEntered;
	boolean buttonScoreClicked;
	boolean buttonInstClicked;


	// Graphics/image/dimensions - used to reduce flicker
	Graphics bufferGraphics;
	Image offscreen;
	Dimension dim;
	URL url;
	AudioClip onlyTime, everyBreath, click, step, berryEat, deerEat, whatLove, dontStop;

	// Variables for game.
	Timer timer;
	GoodPlayer goodPlayer;
	int health = 100;
	int points = 0;
	int timeLeft = 500;
	int ticks = 0;
	static int mapPos = 1;
	boolean paused = false;
	boolean help = false;
	boolean gameOver = false;
	boolean start = true;
	boolean gameWon = false;
	static boolean berriesOnBush = true;
	boolean mapFinal = false;
	int scoresMax;

	//Girl Bear x and y
	int gretelx = 1216;
	int gretely = 448;
	
	//Music Counters
	int counter1= 0;
	int counter= 0;
	int musicCounter = 0;
	int musicCounter2 = 0;
	int musicCounter3 = 0;
	
	// Layering Frames
	boolean startMenu = true;
	boolean game = false;
	boolean scorePage = false;
	boolean instPage = false;

	// Arrays for getting user name and score
	String name = "";
	int finalPoints = 0;
	static int[] scoreArray = new int[100];
	static String[] nameArray = new String[100];
	static int arrayNum;

	Thread t = null; // Animation thread
	boolean threadSuspended;
	
	public void init() {
		this.setSize(1408, 768);
		dim = getSize();
		offscreen = createImage(dim.width, dim.height);
		bufferGraphics = offscreen.getGraphics();
		addKeyListener(new KL());
		this.setSize(1408, 764);
		addMouseListener(this);
		 //Get all the sound files
		onlyTime = getAudioClip(getCodeBase(), "onlyTime.wav");
		everyBreath = getAudioClip(getCodeBase(), "everyBreath.wav");
		step = getAudioClip(getCodeBase(), "step.wav");
		click = getAudioClip(getCodeBase(), "click.wav");
		berryEat = getAudioClip(getCodeBase(), "berryEat.wav");
		deerEat = getAudioClip(getCodeBase(), "deerEat.wav");
		//dontStop = getAudioClip(getCodeBase(), "Music/dontStop.wav");
        //whatLove = getAudioClip(getCodeBase(), "Music/whatLove.wav");

	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			threadSuspended = false;
			t.start();
		} else {
			if (threadSuspended) {
				threadSuspended = false;
				synchronized (this) {
					notify();
				}
			}
		}
	}

	public void stop() {
		threadSuspended = true;
	}

	public void run() {
		
		try {
			
			//Get all the pictures
			URL grassURL = new URL(getCodeBase(), "Grass.png");
			grassPhoto = ImageIO.read(grassURL);

			URL treeURL = new URL(getCodeBase(), "tree.png");
			treePhoto = ImageIO.read(treeURL);

			URL berryBushURL = new URL(getCodeBase(), "bush_berries.png");
			berryBushPhoto = ImageIO.read(berryBushURL);

			URL berryBushEmptyURL = new URL(getCodeBase(), "bush_no_berries.png");
			berryBushEmptyPhoto = ImageIO.read(berryBushEmptyURL);

			URL deerURL = new URL(getCodeBase(), "Deer.png");
			deerPhoto = ImageIO.read(deerURL);

			URL graveURL = new URL(getCodeBase(), "grave.png");
			gravePhoto = ImageIO.read(graveURL);

			URL waterURL = new URL(getCodeBase(), "Water.png");
			waterPhoto = ImageIO.read(waterURL);

			URL gWBURL = new URL(getCodeBase(), "GWB.png");
			gWBPhoto = ImageIO.read(gWBURL);

			URL gWTURL = new URL(getCodeBase(), "GWT.png");
			gWTPhoto = ImageIO.read(gWTURL);

			URL grassWatBotRigURL = new URL(getCodeBase(), "GWBR.png");
			grassWatBotRigPhoto = ImageIO.read(grassWatBotRigURL);

			URL grassWatTopRightURL = new URL(getCodeBase(), "GWTR.png");
			grassWatTopRightPhoto = ImageIO.read(grassWatTopRightURL);

			URL grassWatTopLeftURL = new URL(getCodeBase(), "GWTL.png");
			grassWatTopLeftPhoto = ImageIO.read(grassWatTopLeftURL);

			URL grassWatBotLeftURL = new URL(getCodeBase(), "GWBL.png");
			grassWatBotLeftPhoto = ImageIO.read(grassWatBotLeftURL);

			URL gWRURL = new URL(getCodeBase(), "GWR.png");
			gWRPhoto = ImageIO.read(gWRURL);

			URL gWLURL = new URL(getCodeBase(), "GWL.png");
			gWLPhoto = ImageIO.read(gWLURL);

			URL grassWatTopAndRightURL = new URL(getCodeBase(), "GWTRC.png");
			grassWatTopAndRigPhoto = ImageIO.read(grassWatTopAndRightURL);

			URL grassWatTopAndLeftURL = new URL(getCodeBase(), "GWTLC.png");
			grassWatTopAndLefPhoto = ImageIO.read(grassWatTopAndLeftURL);

			URL grassWatBotAndRigURL = new URL(getCodeBase(), "GWBRC.png");
			grassWatBotAndRigPhoto = ImageIO.read(grassWatBotAndRigURL);

			URL grassWatBotAndLefURL = new URL(getCodeBase(), "GWBLC.png");
			grassWatBotAndLefPhoto = ImageIO.read(grassWatBotAndLefURL);

			URL hunterURL = new URL(getCodeBase(), "Hunter.png");
			hunterPhoto = ImageIO.read(hunterURL);

			URL cave1URL = new URL(getCodeBase(), "cave1.png");
			cave1Photo = ImageIO.read(cave1URL);

			URL cave2URL = new URL(getCodeBase(), "cave2.png");
			cave2Photo = ImageIO.read(cave2URL);

			URL cave3URL = new URL(getCodeBase(), "cave3.png");
			cave3Photo = ImageIO.read(cave3URL);

			URL cave4URL = new URL(getCodeBase(), "cave4.png");
			cave4Photo = ImageIO.read(cave4URL);

			URL cave5URL = new URL(getCodeBase(), "cave5.png");
			cave5Photo = ImageIO.read(cave5URL);

			URL bearFrontURL = new URL(getCodeBase(), "bearFront.png");
			bearFrontPhoto = ImageIO.read(bearFrontURL);

			URL bearBackURL = new URL(getCodeBase(), "bearBack.png");
			bearBackPhoto = ImageIO.read(bearBackURL);

			URL bearLeftURL = new URL(getCodeBase(), "bearLeft.png");
			bearLeftPhoto = ImageIO.read(bearLeftURL);

			URL bearRightURL = new URL(getCodeBase(), "bearRight.png");
			bearRightPhoto = ImageIO.read(bearRightURL);

			URL mainMenuURL = new URL(getCodeBase(), "mainMenu.png");
			mainMenuPhoto = ImageIO.read(mainMenuURL);

			URL buttonScoreURL = new URL(getCodeBase(), "buttonScores.png");
			buttonScorePhoto = ImageIO.read(buttonScoreURL);

			URL buttonInstURL = new URL(getCodeBase(), "buttonInst.png");
			buttonInstPhoto = ImageIO.read(buttonInstURL);

			URL buttonPlayURL = new URL(getCodeBase(), "buttonPlay.png");
			buttonPlayPhoto = ImageIO.read(buttonPlayURL);

			URL instructionsURL = new URL(getCodeBase(), "instructions.png");
			instructionsPhoto = ImageIO.read(instructionsURL);

			URL highScoresURL = new URL(getCodeBase(), "highScores.png");
			highScoresPhoto = ImageIO.read(highScoresURL);

			URL returnToMenuURL = new URL(getCodeBase(), "returnToMenu.png");
			returnToMenuPhoto = ImageIO.read(returnToMenuURL);

			URL loseURL = new URL(getCodeBase(), "loseScreen.png");
			losePhoto = ImageIO.read(loseURL);
			
			URL gretelURL = new URL(getCodeBase(),"gretel.png");
	         gretelPhoto = ImageIO.read(gretelURL);
	         
	        URL winScreenURL = new URL(getCodeBase(),"winScreen.png");
	         winScreenPhoto = ImageIO.read(winScreenURL);
	         
	        URL loadingURL = new URL(getCodeBase(),"loadingScreen.png");
	        loadingPhoto = ImageIO.read(loadingURL);
	        
	        URL backButtonURL = new URL(getCodeBase(),"backButton.png");
	        backButtonPhoto = ImageIO.read(backButtonURL);

	       
		} catch (IOException e) {
			System.out.println("Problem reading the file");
		}
		requestFocus();
		try {
			while (true) {
				if (start) {
					// Create good player
					goodPlayer = new GoodPlayer();
					start = false;
				}
				if (threadSuspended) {
					synchronized (this) {
						while (threadSuspended) {
							wait();
						}
					}
				}
				
				timeLeft--;
				//On last map move girl bear and win game
				if(mapFinal){
					counter++;
					if(counter <=5){
						gretelx = gretelx - 64;
						step.play();
					}
					else if(counter <= 9) {
						gameWon = true;
					}
				}

				// Reduce time every second
				if (ticks % 5 == 0) {
					if (timeLeft > 0)
						timeLeft--;
					else
						gameOver = true;
				}

				goodPlayer.toggleLight();
				// Move bullets
				Bullet.counter();
				// Check for bullet hit
				if (Bullet.collision(goodPlayer.getRow(), goodPlayer.getCol())) {
					if (health > 0)
						health -= 5;
					else
						gameOver = true;
				}

				repaint();

				Thread.sleep(200); // interval given in milliseconds
				ticks++;
			}
		} catch (InterruptedException e) {
		}
	}

	class KL implements KeyListener {
		char retcode = ' ';

		public void keyPressed(KeyEvent e) {
			
			//Get user name
			if (startMenu) {
				if ((e.getKeyCode() == KeyEvent.VK_DELETE) || (e.getKeyCode() == KeyEvent.VK_LEFT) ||
						(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
					if (name.length() > 0)
						name = name.substring(0,  name.length()-1);
				}				
				else {
					if (name.length() < 26)
						name += (char) e.getKeyCode();
				}
				
			}
			
			//Help, Pause and code for if the bear is on the last map
			if (game && !gameOver) {
				if (help)
					help = false;
				else if (paused)
					paused = false;
				else if (mapPos == 25){
					if(counter1 <= 5){
						retcode = goodPlayer.move(BasePlayer.EAST);
					}
				}
				else {
					// Move good guy based on keystroke
					switch (e.getKeyCode()) {
					case KeyEvent.VK_W:
					case KeyEvent.VK_UP: // UP ARROW, MOVES UP
						retcode = goodPlayer.move(BasePlayer.NORTH);
						step.play();
						break;
					case KeyEvent.VK_S:
					case KeyEvent.VK_DOWN: // DOWN ARROW, MOVES DOWN
						retcode = goodPlayer.move(BasePlayer.SOUTH);
						step.play();
						break;
					case KeyEvent.VK_A:
					case KeyEvent.VK_LEFT: // LEFT ARROW, MOVES LEFT
						retcode = goodPlayer.move(BasePlayer.WEST);
						step.play();
						break;
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT: // RIGHT ARROW, MOVES RIGHT
						step.play();
						retcode = goodPlayer.move(BasePlayer.EAST);
						break;
					case KeyEvent.VK_H:
						// help
						help = true;
						click.play();
						break;
					case KeyEvent.VK_P:

						paused = true;
						click.play();

						break;
					}
				}

				switch (retcode) {
				case 'F': // Finish
					break;
				//Landing on a berry, get points, switch tile to empty berry, and queue eating sound effect
				case 'B':
					String newString = "";
					berryEat.play();
					points += 10;
					if (mapPos == 1) {
						for (int i = 0; i < Maze.currMazeOne[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeOne[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeOne[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 2) {
						for (int i = 0; i < Maze.currMazeTwo[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwo[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwo[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 3) {
						for (int i = 0; i < Maze.currMazeThree[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeThree[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeThree[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 4) {
						for (int i = 0; i < Maze.currMazeFour[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeFour[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFour[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 5) {
						for (int i = 0; i < Maze.currMazeFive[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeFive[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFive[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 6) {
						for (int i = 0; i < Maze.currMazeSix[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeSix[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSix[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 7) {
						for (int i = 0; i < Maze.currMazeSeven[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeSeven[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSeven[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 8) {
						for (int i = 0; i < Maze.currMazeEight[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeEight[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeEight[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 9) {
						for (int i = 0; i < Maze.currMazeNine[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeNine[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeNine[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 10) {
						for (int i = 0; i < Maze.currMazeTen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 11) {
						for (int i = 0; i < Maze.currMazeEleven[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeEleven[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeEleven[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 12) {
						for (int i = 0; i < Maze.currMazeTwelve[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwelve[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwelve[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 13) {
						for (int i = 0; i < Maze.currMazeThirteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeThirteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeThirteen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 14) {
						for (int i = 0; i < Maze.currMazeFourteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeFourteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFourteen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 15) {
						for (int i = 0; i < Maze.currMazeFifteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeFifteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFifteen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 16) {
						for (int i = 0; i < Maze.currMazeSixteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeSixteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSixteen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 17) {
						for (int i = 0; i < Maze.currMazeSeventeen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeSeventeen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSeventeen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 18) {
						for (int i = 0; i < Maze.currMazeEighteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeEighteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeEighteen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 19) {
						for (int i = 0; i < Maze.currMazeNinteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeNinteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeNinteen[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 20) {
						for (int i = 0; i < Maze.currMazeTwenty[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwenty[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwenty[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 21) {
						for (int i = 0; i < Maze.currMazeTwentyOne[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwentyOne[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyOne[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 22) {
						for (int i = 0; i < Maze.currMazeTwentyTwo[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwentyTwo[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyTwo[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 23) {
						for (int i = 0; i < Maze.currMazeTwentyThree[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwentyThree[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyThree[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 24) {
						for (int i = 0; i < Maze.currMazeTwentyFour[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwentyFour[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyFour[goodPlayer.getRow()] = newString;
					}
					if (mapPos == 25) {
						for (int i = 0; i < Maze.currMazeTwentyFive[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								newString += 'E';
							} else {
								newString += Maze.currMazeTwentyFive[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyFive[goodPlayer.getRow()] = newString;
					}
					break;
				case 'D':
					//Landing on a deer, get points, switch tile to tomb stone, and queue eating sound effect
					String deerString = "";
					deerEat.play();
					points += 50;
					if (mapPos == 1) {
						for (int i = 0; i < Maze.currMazeOne[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeOne[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeOne[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 2) {
						for (int i = 0; i < Maze.currMazeTwo[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwo[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwo[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 3) {
						for (int i = 0; i < Maze.currMazeThree[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeThree[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeThree[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 4) {
						for (int i = 0; i < Maze.currMazeFour[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeFour[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFour[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 5) {
						for (int i = 0; i < Maze.currMazeFive[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeFive[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFive[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 6) {
						for (int i = 0; i < Maze.currMazeSix[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeSix[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSix[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 7) {
						for (int i = 0; i < Maze.currMazeSeven[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeSeven[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSeven[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 8) {
						for (int i = 0; i < Maze.currMazeEight[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeEight[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeEight[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 9) {
						for (int i = 0; i < Maze.currMazeNine[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeNine[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeNine[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 10) {
						for (int i = 0; i < Maze.currMazeTen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 11) {
						for (int i = 0; i < Maze.currMazeEleven[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeEleven[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeEleven[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 12) {
						for (int i = 0; i < Maze.currMazeTwelve[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwelve[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwelve[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 13) {
						for (int i = 0; i < Maze.currMazeThirteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeThirteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeThirteen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 14) {
						for (int i = 0; i < Maze.currMazeFourteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeFourteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFourteen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 15) {
						for (int i = 0; i < Maze.currMazeFifteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeFifteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeFifteen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 16) {
						for (int i = 0; i < Maze.currMazeSixteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeSixteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSixteen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 17) {
						for (int i = 0; i < Maze.currMazeSeventeen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeSeventeen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeSeventeen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 18) {
						for (int i = 0; i < Maze.currMazeEighteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeEighteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeEighteen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 19) {
						for (int i = 0; i < Maze.currMazeNinteen[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeNinteen[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeNinteen[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 20) {
						for (int i = 0; i < Maze.currMazeTwenty[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwenty[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwenty[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 21) {
						for (int i = 0; i < Maze.currMazeTwentyOne[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwentyOne[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyOne[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 22) {
						for (int i = 0; i < Maze.currMazeTwentyTwo[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwentyTwo[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyTwo[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 23) {
						for (int i = 0; i < Maze.currMazeTwentyThree[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwentyThree[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyThree[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 24) {
						for (int i = 0; i < Maze.currMazeTwentyFour[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwentyFour[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyFour[goodPlayer.getRow()] = deerString;
					}
					if (mapPos == 25) {
						for (int i = 0; i < Maze.currMazeTwentyFive[goodPlayer.getRow()].length(); i++)
							if (i == goodPlayer.getCol()) {
								deerString += 'J';
							} else {
								deerString += Maze.currMazeTwentyFive[goodPlayer.getRow()].charAt(i);
							}
						Maze.currMazeTwentyFive[goodPlayer.getRow()] = deerString;
					}
					break;
				}

				repaint();
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	public void paint(Graphics g) {
		//Read Scores File for current scores.
		try {
			FileReader fr = new FileReader("Scores.txt");
			BufferedReader br =  new BufferedReader(fr);
	
			int score;
			int a = 0;
			int count = 0;
			
			String name = br.readLine();
			while (name != null)
			{
				//Store reference numbers and book titles into the arrays
				score = Integer.parseInt(name);
	            scoreArray[a] = score;
	            nameArray[a] = br.readLine();
	            
	            if((nameArray[a] == "") || (nameArray[a] == null))
	            {
	            	nameArray[a] = "unnamed user";
	            }          
	           a++;
	            name = br.readLine();
			}
			
			for(int i = 0; i < scoreArray.length-1; i++)
			{
				if(scoreArray[i] != 0)
				{
					count++;
				}
			}
			arrayNum = count;
			
			fr.close();
			br.close();
		}
		catch (IOException e)
		{
			//Out.println("I/O error");
		}
		catch (NumberFormatException e)
		{
			//Out.println("Number Format Error");
		}
		
		//Story the name into the array
		//nameArray[arrayNum] = name;
		if ((name != "") || (name != null) || (name != " "))
		{
			nameArray[arrayNum] = name;
		}
		else{
			nameArray[arrayNum] = "unnamed user";
		}
		
		System.out.println("nameArray[arrayNum]" + " is " + nameArray[arrayNum]);
		System.out.println("arrayNum" + " is " + arrayNum);
		
		
		music();
		
		//Draw the starting menu
		if (startMenu) {
			Maze.mapReset();
			bufferGraphics.drawImage(mainMenuPhoto, 0, 0, 1408, 768, null);

			Font statusFont = new Font("Arial", Font.BOLD, 28);
			bufferGraphics.setFont(statusFont);
			
			bufferGraphics.drawString("Enter name:", 70, 420);
			bufferGraphics.setColor(Color.BLACK);
			bufferGraphics.fillRect(250, 390, 500, 40);
			bufferGraphics.setColor(Color.WHITE);			
			bufferGraphics.drawString(name, 270, 420);
			
			
			bufferGraphics.drawImage(buttonScorePhoto, 316, 615, 373, 65, null);
			bufferGraphics.drawImage(buttonInstPhoto, 316, 535, 373, 65, null);
			bufferGraphics.drawImage(buttonPlayPhoto, 316, 455, 373, 65, null);
		
		}
		//Draw the instructions Menu
		else if (instPage) {
			bufferGraphics.drawImage(instructionsPhoto, 0, 0, 1408, 768, null);
			bufferGraphics.drawImage(backButtonPhoto, 20, 700, 300, 50, null);
		}
		//Draw the Score Page
		else if (scorePage) {
			bufferGraphics.drawImage(highScoresPhoto, 0, 0, 1408, 768, null);
			bufferGraphics.drawImage(backButtonPhoto, 20, 700, 300, 50, null);
			bufferGraphics.setColor(Color.white);
			bufferGraphics.drawString("User Name", 450, 250);
			bufferGraphics.drawString("Score", 800, 250);
			selectionSort(scoreArray, nameArray);
			
			//No more than 10 scores at once
			if(arrayNum > 10)
			{
				scoresMax = 10;
			}
			else
			{
				scoresMax = arrayNum;
			}
			
			//Set positions of scores on the scores screen
			int[] yCord = new int[100];
			for(int i = 0; i < scoresMax; i++)
			{
				if(i == 0)
				{
					yCord[i] = 0;
				}
				else
				{	
					yCord[i] = yCord[i-1] + 40;
				}
				bufferGraphics.drawString(nameArray[i], 450, 290 + yCord[i]);
				bufferGraphics.drawString(String.valueOf(scoreArray[i]), 800, 290 + yCord[i]);
			}
			
			bufferGraphics.setColor(Color.red);
			bufferGraphics.drawLine(450, 251, 600, 251);
			bufferGraphics.drawLine(800, 251, 880, 251);
		}
		//Game screen
		else if (game) {
			//Draw the maze
			Maze.draw(bufferGraphics, Map.maze, mapPos, grassPhoto, treePhoto, berryBushPhoto, berryBushEmptyPhoto,
					waterPhoto, gWBPhoto, gWTPhoto, grassWatBotRigPhoto, grassWatTopRightPhoto, grassWatTopLeftPhoto,
					grassWatBotLeftPhoto, gWRPhoto, gWLPhoto, grassWatTopAndLefPhoto, grassWatTopAndRigPhoto,
					grassWatBotAndRigPhoto, grassWatBotAndLefPhoto, deerPhoto, gravePhoto, hunterPhoto, cave1Photo,
					cave2Photo, cave3Photo, cave4Photo, cave5Photo);

			if (health < 0)
				health = 0;
			//Draw Status Bar
			StatusBar.draw(bufferGraphics, health, points, timeLeft);

			if (!start) {
				//Reset variables, draw lose screen when you lose
				if ((health <= 0) || (timeLeft <= 0)) {
					gameOver = true;
					goodPlayer.col = 4;
					goodPlayer.row = 1;
					mapPos = 1;
					g.setColor(Color.white);
					g.drawRect(0, 0, 1408, 768);
					bufferGraphics.drawImage(losePhoto, 0, 0, 1408, 768, null);
					bufferGraphics.drawImage(returnToMenuPhoto, 20, 700, 300, 50, null);
				}

				if (help) {
					HelpScreen.draw(bufferGraphics);
				} else if (!gameOver) {
					goodPlayer.draw(bufferGraphics, bearFrontPhoto, bearBackPhoto, bearLeftPhoto, bearRightPhoto);
					Bullet.draw(bufferGraphics);
				}

			}
			else {
				Loading.drawLoading(g, 1414, 768, berryBushPhoto);
			}
		}
		//Reset variables, draw win screen if you win
		if(gameWon){
			goodPlayer.col = 4;
			goodPlayer.row = 1;
			mapPos = 1;
			bufferGraphics.drawImage(winScreenPhoto,0,0, 1408, 768, null);
			bufferGraphics.drawImage(returnToMenuPhoto, 20, 700, 300, 50, null);
			if(musicCounter2 < 1){
				//whatLove.loop();
			}
			musicCounter2++;
			
		}
		
		if(startMenu){
			if(musicCounter < 1){
				//dontStop.play();
			}
			musicCounter ++;
		}
		//Stop music on map 25
		if(mapPos == 24){
			 everyBreath.stop();
		}
		//Draw the girl Bear
		if(mapPos == 25 && !gameWon){
			 bufferGraphics.drawImage(gretelPhoto,gretelx, gretely, 64, 64, null);
			 mapFinal = true;
		}

		// Draw graphics of image onto screen
		g.drawImage(offscreen, 0, 0, this);
	}

	public final synchronized void update(Graphics G) {
		paint(G);
	}

	public void mouseClicked(MouseEvent me) {
		xpos = me.getX();
		ypos = me.getY();
		// Scores Button
		if (xpos > 316 && xpos < 316 + 373 && ypos > 615 && ypos < 615 + 65) {
			buttonScoreClicked = true;
			startMenu = false;
			instPage = false;
			scorePage = true;
			game = false;
			click.play();
		}
		// Instructions Button
		else if (xpos > 316 && xpos < 316 + 373 && ypos > 535 && ypos < 535 + 65) {
			buttonInstClicked = true;
			startMenu = false;
			instPage = true;
			scorePage = false;
			game = false;
			click.play();
		}
		// Game button
		else if (xpos > 316 && xpos < 316 + 373 && ypos > 455 && ypos < 455 + 65) {
			startMenu = false;
			instPage = false;
			scorePage = false;
			game = true;
			click.play();
			everyBreath.loop();
			timeLeft = 500;
			gameOver = false;
			points = 0;
			health = 100;
			counter = 0;
			gretelx = 1216;
			mapFinal = false;
		}
		// Return to Menu button after the game
		else if (xpos > 20 && xpos < 20 + 300 && ypos > 700 && ypos < 700 + 50 && game) {
			
			startMenu = true;
			instPage = false;
			scorePage = false;
			game = false;
			gameWon = false;
			click.play();
			everyBreath.loop();
			finalPoints = points;
			scoreArray[arrayNum] = finalPoints;
			
			//Print out arrays onto the scores.txt
			try {
				FileWriter fw = new FileWriter("Scores.txt");
				PrintWriter pw =  new PrintWriter(fw);
				
				for(int i = 0; i < scoreArray.length; i++)
				{
					pw.println(scoreArray[i]);
					pw.println(nameArray[i]);
				}
				System.out.println(nameArray[0] + " was the first user and got " + scoreArray[0] + " points");
				System.out.println(nameArray[1] + " was the second user and got " + scoreArray[1] + " points");
				System.out.println(nameArray[2] + " was the third user and got " + scoreArray[2] + " points");
				
				fw.close();
				pw.close();
			}
			catch (IOException e)
			{
				//Out.println("I/O error");
			}
			arrayNum++;
			name = "";
		}
		//return to menu button after viewing instruction or score screen
		if (xpos > 20 && xpos < 20 + 300 && ypos > 700 && ypos < 700 + 50 && !game) {
			buttonScoreClicked = true;
			startMenu = true;
			instPage = false;
			scorePage = false;
			game = false;
			click.play();
			
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void music() {

		/*if ((!startMenu) && (!game) && (name != "")) {
			onlyTime.loop();
		}
		if (!game) {
			everyBreath.loop();
		}
		 */
	}
	
	//Sorting for the highscores
	public static void selectionSort (int[] scoreArray, String[] nameArray)
	{
		
		for (int top = arrayNum-1; top > 0; top--)
		{
			int largeLoc = 0;
			for (int i = 1; i<= top; i++)
			{
				if (scoreArray[i] < scoreArray[largeLoc])	//Check for the smallest number in the array
				{
					largeLoc = i;					
				}
				//Swap the biggest number with the location of "top"
				int tempNum = scoreArray[top];
				scoreArray[top] = scoreArray[largeLoc];
				scoreArray[largeLoc] = tempNum;
				
				String tempString = nameArray[top];
				nameArray[top] = nameArray[largeLoc];
				nameArray[largeLoc] = tempString;
				
			}
		}
	} 

}
