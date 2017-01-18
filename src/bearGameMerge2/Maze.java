/* Package: bearGameMerge
 * Class: Maze
 * Programmer: ICS4U
 * Date Created: January , 2016
 * Description: All the maps for the game
 */
package bearGameMerge2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Maze {
	public static final int CELL = 64;
	public static final int ROWS = 11;
	public static final int COLS = 22;
	public static final int POINTS = 5;
	
	//Get all 25 maps
		static String [] currMazeOne = new String[ROWS];
		static String [] currMazeTwo= new String[ROWS];;
		static String [] currMazeThree = new String[ROWS];
		static String [] currMazeFour = new String[ROWS];;
		static String [] currMazeFive = new String[ROWS];
		static String [] currMazeSix =  new String[ROWS];
		static String [] currMazeSeven = new String[ROWS];
		static String [] currMazeEight = new String[ROWS];
		static String [] currMazeNine =new String[ROWS];
		static String [] currMazeTen = new String[ROWS];
		static String [] currMazeEleven =new String[ROWS];
		static String [] currMazeTwelve = new String[ROWS];
		static String [] currMazeThirteen =new String[ROWS];
		static String [] currMazeFourteen = new String[ROWS];
		static String [] currMazeFifteen = new String[ROWS];
		static String [] currMazeSixteen =new String[ROWS];
		static String [] currMazeSeventeen = new String[ROWS];
		static String [] currMazeEighteen =new String[ROWS];
		static String [] currMazeNinteen = new String[ROWS];
		static String [] currMazeTwenty= new String[ROWS];
		static String [] currMazeTwentyOne = new String[ROWS];
		static String [] currMazeTwentyTwo = new String[ROWS];
		static String [] currMazeTwentyThree = new String[ROWS];
		static String [] currMazeTwentyFour = new String[ROWS];
		static String [] currMazeTwentyFive = new String[ROWS];
	
	public static void mapReset() {
		String temp = "";
		for (int i=0; i< Maze.ROWS; i++) {
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeOne[i].charAt(j);
			}
		currMazeOne[i] = temp;
		temp = "";
		}
		
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwo[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwo[i].charAt(j);
			}
		currMazeTwo[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeThree[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeThree[i].charAt(j);
			}
		currMazeThree[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeFour[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeFour[i].charAt(j);
			}
		currMazeFour[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeFive[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeFive[i].charAt(j);
			}
		currMazeFive[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeSix[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeSix[i].charAt(j);
			}
		currMazeSix[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeSeven[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeSeven[i].charAt(j);
			}
		currMazeSeven[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeEight[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeEight[i].charAt(j);
			}
		currMazeEight[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeNine[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeNine[i].charAt(j);
			}
		currMazeNine[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTen[i].charAt(j);
			}
		currMazeTen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeEleven[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeEleven[i].charAt(j);
			}
		currMazeEleven[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwelve[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwelve[i].charAt(j);
			}
		currMazeTwelve[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeThirteen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeThirteen[i].charAt(j);
			}
		currMazeThirteen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeFourteen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeFourteen[i].charAt(j);
			}
		currMazeFourteen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeFifteen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeFifteen[i].charAt(j);
			}
		currMazeFifteen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeSixteen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeSixteen[i].charAt(j);
			}
		currMazeSixteen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeSeventeen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeSeventeen[i].charAt(j);
			}
		currMazeSeventeen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeEighteen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeEighteen[i].charAt(j);
			}
		currMazeEighteen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeNinteen[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeNinteen[i].charAt(j);
			}
		currMazeNinteen[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwenty[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwenty[i].charAt(j);
			}
		currMazeTwenty[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwentyOne[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwentyOne[i].charAt(j);
			}
		currMazeTwentyOne[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwentyTwo[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwentyTwo[i].charAt(j);
			}
		currMazeTwentyTwo[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwentyThree[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwentyThree[i].charAt(j);
			}
		currMazeTwentyThree[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwentyFour[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwentyFour[i].charAt(j);
			}
		currMazeTwentyFour[i] = temp;
		temp = "";
		}
		for (int i=0; i< Maze.ROWS; i++) {
			currMazeTwentyFive[i] = "GGGGGGGGGGGGGGGGGGGGGG";
			for (int j=0; j< Maze.COLS; j++) {
				temp += Map.mazeTwentyFive[i].charAt(j);
			}
		currMazeTwentyFive[i] = temp;
		temp = "";
		}
		
	}
	
	//Put pictures in parameter of draw method in order to use the pictures
	public static void draw(Graphics g, String[] maze, int mapNum, BufferedImage grassPhoto, BufferedImage treePhoto,
			BufferedImage berryBushPhoto, BufferedImage berryBushEmptyPhoto, BufferedImage waterPhoto,
			BufferedImage gWBPhoto, BufferedImage gWTPhoto, BufferedImage grassWatBotRigPhoto,
			BufferedImage grassWatTopRightPhoto, BufferedImage grassWatTopLeftPhoto, BufferedImage grassWatBotLeftPhoto,
			BufferedImage gWRPhoto, BufferedImage gWLPhoto, BufferedImage grassWatTopAndLefPhoto,
			BufferedImage grassWatTopAndRigPhoto, BufferedImage grassWatBotAndRigPhoto,
			BufferedImage grassWatBotAndLefPhoto, BufferedImage deerPhoto, BufferedImage gravePhoto,
			BufferedImage hunterPhoto, BufferedImage cave1Photo, BufferedImage cave2Photo, BufferedImage cave3Photo,
			BufferedImage cave4Photo, BufferedImage cave5Photo) {
		char curCode;
		boolean hunterFound = false;

		//Set map position equal to string maps
		
		
		
		
		if (mapNum == 1) {
			maze = currMazeOne;
		}
		if (mapNum == 2) {
			maze = currMazeTwo;
		}
		if (mapNum == 3) {
			maze = currMazeThree;
		}

		if (mapNum == 4) {
			maze = currMazeFour;
		}

		if (mapNum == 5) {
			maze = currMazeFive;
		}
		if (mapNum == 6) {
			maze = currMazeSix;
		}
		if (mapNum == 7) {
			maze = currMazeSeven;
		}
		if (mapNum == 8) {
			maze = currMazeEight;
		}
		if (mapNum == 9) {
			maze = currMazeNine;
		}
		if (mapNum == 10) {
			maze = currMazeTen;
		}
		if (mapNum == 11) {
			maze = currMazeEleven;
		}
		if (mapNum == 12) {
			maze = currMazeTwelve;
		}
		if (mapNum == 13) {
			maze = currMazeThirteen;
		}
		if (mapNum == 14) {
			maze = currMazeFourteen;
		}
		if (mapNum == 15) {
			maze = currMazeFifteen;
		}
		if (mapNum == 16) {
			maze = currMazeSixteen;
		}
		if (mapNum == 17) {
			maze = currMazeSeventeen;
		}
		if (mapNum == 18) {
			maze = currMazeEighteen;
		}
		if (mapNum == 19) {
			maze = currMazeNinteen;
		}
		if (mapNum == 20) {
			maze = currMazeTwenty;
		}
		if (mapNum == 21) {
			maze = currMazeTwentyOne;
		}
		if (mapNum == 22) {
			maze = currMazeTwentyTwo;
		}
		if (mapNum == 23) {
			maze = currMazeTwentyThree;
		}
		if (mapNum == 24) {
			maze = currMazeTwentyFour;
		}
		if (mapNum == 25) {
			maze = currMazeTwentyFive;
		}

		Map.maze = maze;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				curCode = maze[i].charAt(j);
				switch (curCode) {
				//All the different tiles for Game. Add the picture from the tiles class to each case.
				case 'G':
					Tiles.drawGrass(g, j * CELL, i * CELL, grassPhoto);
					break;
				case 'D':
					Tiles.drawDeer(g, j * CELL, i * CELL, deerPhoto);
					break;
				case 'J':
					Tiles.drawGrave(g, j * CELL, i * CELL, gravePhoto);
					break;
				case 'T':
					Tiles.drawTree(g, j * CELL, i * CELL, treePhoto);
					break;
				case 'B':
					Tiles.drawBerryBush(g, j * CELL, i * CELL, berryBushPhoto);
					break;
				case 'E':
					Tiles.drawBerryBushEmpty(g, j * CELL, i * CELL, berryBushEmptyPhoto);
					break;
				case 'W':
					Tiles.drawWater(g, j * CELL, i * CELL, waterPhoto);
					break;
				case 'X':
					Tiles.drawGWB(g, j * CELL, i * CELL, gWBPhoto);
					break;
				case 'Z':
					Tiles.drawGWT(g, j * CELL, i * CELL, gWTPhoto);
					break;
				case 'N':
					Tiles.drawGWBR(g, j * CELL, i * CELL, grassWatBotRigPhoto);
					break;
				case 'M':
					Tiles.drawGWTR(g, j * CELL, i * CELL, grassWatTopRightPhoto);
					break;
				case 'L':
					Tiles.drawGWTL(g, j * CELL, i * CELL, grassWatTopLeftPhoto);
					break;
				case 'K':
					Tiles.drawGWBL(g, j * CELL, i * CELL, grassWatBotLeftPhoto);
					break;
				case 'V':
					Tiles.drawGWR(g, j * CELL, i * CELL, gWRPhoto);
					break;
				case 'Q':
					Tiles.drawGWL(g, j * CELL, i * CELL, gWLPhoto);
					break;
				case 'z':
					Tiles.drawGWTRC(g, j * CELL, i * CELL, grassWatTopAndRigPhoto);
					break;
				case 'x':
					Tiles.drawGWTLC(g, j * CELL, i * CELL, grassWatTopAndLefPhoto);
					break;
				case 'v':
					Tiles.drawGWBRC(g, j * CELL, i * CELL, grassWatBotAndRigPhoto);
					break;
				case 'b':
					Tiles.drawGWBLC(g, j * CELL, i * CELL, grassWatBotAndLefPhoto);
					break;

				case 'C':
					Tiles.drawCave1(g, j * CELL, i * CELL, cave1Photo);
					break;
				case 'c':
					Tiles.drawCave2(g, j * CELL, i * CELL, cave2Photo);
					break;
				case 'A':
					Tiles.drawCave3(g, j * CELL, i * CELL, cave3Photo);
					break;
				case 'a':
					Tiles.drawCave4(g, j * CELL, i * CELL, cave4Photo);
					break;
				case 'd':
					Tiles.drawCave5(g, j * CELL, i * CELL, cave5Photo);
					break;
				case 'H':
					hunterFound = true;
					BadPlayer.draw(g, j * CELL, i * CELL, hunterPhoto);
					// Set bullet start position
					Bullet.origin(j, i);
					break;
				}
			}
		}
		if (!hunterFound) {
			Bullet.origin(-1, -1);
		}
	}
}
