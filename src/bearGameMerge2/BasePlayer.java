/* Package: bearGameMerge
 * Class: BasePlayer
 * Programmer: ICS4U
 * Date Created: January , 2016
 * Description: Setting directions and positions of good player
 */
package bearGameMerge2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public abstract class BasePlayer {
	//Set up direction variables
	protected static final int INIT_DIR = 0;
	protected static final int NORTH = 1;
	protected static final int EAST = 2;
	protected static final int SOUTH = 3;
	protected static final int WEST = 4;
	
	//Position Variables
	protected int row;
	protected int col;
	protected int dir;

	public BasePlayer() {
		dir = 3;
		col = 4;
		row = 1;

	}
	public char move() {
		return ' ';
	}

	//Add in different pictures for each direction of the bear
	public void draw(Graphics g, BufferedImage bearFrontPhoto, BufferedImage bearBackPhoto, BufferedImage bearLeftPhoto,
			BufferedImage bearRightPhoto) {
		switch (dir) {
		case NORTH:
			drawUp(g, col * Maze.CELL, row * Maze.CELL, bearBackPhoto);
			break;
		case EAST:
			drawRight(g, col * Maze.CELL, row * Maze.CELL, bearRightPhoto);
			break;
		case SOUTH:
			drawDown(g, col * Maze.CELL, row * Maze.CELL, bearFrontPhoto);
			break;
		case INIT_DIR:
		case WEST:
			drawLeft(g, col * Maze.CELL, row * Maze.CELL, bearLeftPhoto);
			break;
		}
	}

	public abstract void drawUp(Graphics g, int x, int y, BufferedImage bearBackPhoto);

	public abstract void drawRight(Graphics g, int x, int y, BufferedImage bearRightPhoto);

	public abstract void drawDown(Graphics g, int x, int y, BufferedImage bearFrontPhoto);

	public abstract void drawLeft(Graphics g, int x, int y, BufferedImage bearLeftPhoto);

	// Setters
	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public int getDir() {
		return dir;
	}

	// Setters
	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int setDir(int dir) {
		int result = 0;
		this.dir = dir;
		return result;
	}
}
