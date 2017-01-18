/* Package: bearGameMerge
 * Class: GoodPlayer
 * Programmer: ICS4U
 * Date Created: January , 2016
 * Description: Movement for the bear character
 */
package bearGameMerge2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GoodPlayer extends BasePlayer {
	private boolean front = true;

	public GoodPlayer() {

		super();
	}

	public char move(int moveDir) {
		char pos;
		char retcode = ' ';
		int tempCol = 0;
		int tempRow = 0;

		switch (moveDir) {
		
		//Check for valid moves within a map, and change maps once the end is crossed 
		//Movement for bear
		case NORTH:
			MainGame.mapPos -= 5;
			tempRow = row;
			row = 10;
			if (tempRow - 1 >= 0) {
				MainGame.mapPos += 5;
				row = tempRow;
				pos = Map.maze[row - 1].charAt(col);

				if (validMove(pos)) {
					row -= 1;
					dir = NORTH;
					retcode = pos;
				}
			}
			break;
		case SOUTH:
			MainGame.mapPos += 5;
			tempRow = row;
			row = 0;
			if (tempRow + 1 < Maze.ROWS) {
				MainGame.mapPos -= 5;
				row = tempRow;
				pos = Map.maze[row + 1].charAt(col);

				if (validMove(pos)) {
					row += 1;
					dir = SOUTH;
					retcode = pos;
				}
			}
			break;
		case EAST:
			MainGame.mapPos += 1;
			tempCol = col;
			col = 0;
			if (tempCol + 1 < Maze.COLS) {
				MainGame.mapPos -= 1;
				col = tempCol;
				pos = Map.maze[row].charAt(col + 1);

				if (validMove(pos)) {
					col += 1;
					dir = EAST;
					retcode = pos;
				}
			}
			break;
		case WEST:
			MainGame.mapPos -= 1;
			tempCol = col;
			col = 21;
			if (tempCol - 1 >= 0) {
				MainGame.mapPos += 1;
				col = tempCol;
				pos = Map.maze[row].charAt(col - 1);

				if (validMove(pos)) {
					col -= 1;
					dir = WEST;
					retcode = pos;
				}
			}
		}
		return retcode;
	}

	//Invalid Tiles
	public boolean validMove(char code) {
		boolean result = true;
		if ((code == 'T') || (code == 'H') || (code == 'W')||(code == 'C')||(code == 'c')||(code == 'A')
			||(code == 'a')||(code == 'd')) {
			result = false;
		}
		return result;
	}

	public void toggleLight() {
		front = !front;
	}

	public void drawUp(Graphics g, int x, int y, BufferedImage bearBackPhoto) {
		g.drawImage(bearBackPhoto, x, y, null);
	}

	public void drawRight(Graphics g, int x, int y,  BufferedImage bearRightPhoto) {
		g.drawImage(bearRightPhoto, x, y, null);
	}

	public void drawDown(Graphics g, int x, int y,  BufferedImage bearFrontPhoto) {
		g.drawImage(bearFrontPhoto, x, y, null);
	}

	public void drawLeft(Graphics g, int x, int y,  BufferedImage bearLeftPhoto) {
		g.drawImage(bearLeftPhoto, x, y, null);
	}
}
