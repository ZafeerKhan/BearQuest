/* Package: bearGameMerge
 * Class: Bullet
 * Programmer: ICS4U
 * Date Created: January 18, 2016
 * Description: Controls hunter bullets.
 */
package bearGameMerge2;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	public static int row = -1;
	public static int col = -1;
	final static int BULLETS = 7;
	public static int bullet_y[] = { 0, 0, 0, 0, 0, 0, 0};
	public static int bullet_x[] = { 0, 0, 0, 0, 0, 0, 0};
	public static boolean hit[] = { false, false, false, false, false, false, false };
	public static int horz = -12;
	public static int vert = 13;
	public static int delay = 0;
	public static int dir;
	public static boolean fire = false;

	// Hunter position set when drawing maze
	public static void origin(int huntercol, int hunterrow) {
		// Set bullet start cell, checks for new hunter position (new map)
		if ((hunterrow != row) && (huntercol != col)) {
			row = hunterrow;
			col = huntercol;
			// If hunter is on lower half of maze, shoot up, otherwise shoot
			// down
			if (row > Maze.ROWS / 2)
				dir = -1;
			else
				dir = 1;
			fire = false;
		}
	}

	// Bear collision
	public static boolean collision(int bearrow, int bearcol) {
		boolean result = false;

		if (fire) {
			// Check for collision with bear
			for (int i = 0; i < BULLETS; i++) {
				if ((bullet_x[i] > bearcol * Maze.CELL) && (bullet_y[i] > bearrow * Maze.CELL)
						&& (bullet_x[i] < bearcol * Maze.CELL + Maze.CELL)
						&& (bullet_y[i] < bearrow * Maze.CELL + Maze.CELL)) {
					hit[i] = true;
					result = true;
				}
			}
		}

		return result;
	}

	public static void counter() {
		// Count seconds
		delay++;

		// If not firing and game has started, set bullet start positions
		if ((!fire) && (row >= 0) && (col >= 0)) {

			// Fire bullets, restart delay
			fire = true;
			delay = 0;

			// Set start positions of bullets
			for (int i = 0; i < BULLETS; i++) {
				// + 30 to move towards centre of cell
				bullet_x[i] = col * Maze.CELL + 30;
				// Move bullet towards edge of cell (up or down), based of
				// direction facing
				bullet_y[i] = row * Maze.CELL + 30 + dir * 40;
				hit[i] = false;
			}
		} else if (fire && (row >= 0) && (col >= 0)) {
			// Move bullet, each bullet delays start and increases vertical
			// speed
			bullet_x[0] += horz;
			bullet_y[0] += vert * dir;

			if (delay > 3) {
				bullet_x[1] += horz + 5;
				bullet_y[1] += (vert + 3) * dir;
			}

			if (delay > 6) {
				bullet_x[2] += horz + 10;
				bullet_y[2] += (vert + 6) * dir;
			}

			if (delay > 9) {
				bullet_x[3] += horz + 20;
				bullet_y[3] += (vert + 8) * dir;
			}
			
			if (delay > 12) {
				bullet_x[4] -= horz + 5;
				bullet_y[4] += (vert + 3) * dir;
			}

			if (delay > 15) {
				bullet_x[5] -= horz + 10;
				bullet_y[5] += (vert + 6) * dir;
			}

			if (delay > 18) {
				bullet_x[6] -= horz + 20;
				bullet_y[6] += (vert + 8) * dir;
			}
			

			for (int i = 0; i < BULLETS; i++) {
				// Stop bullets, if bullet is out of bounds or on invalid cell
				if ((bullet_x[i] > Maze.COLS * Maze.CELL - 30) || (bullet_y[i] > Maze.ROWS * Maze.CELL - 30)
						|| bullet_x[i] < 0 || (bullet_x[i] < 0)) {
					fire = false;
				}

				int temprow = bullet_y[i] / Maze.CELL;
				int tempcol = bullet_x[i] / Maze.CELL;

				char code = Map.maze[temprow].charAt(tempcol);

				if ((code == 'T') || (code == 'H') || (code == 'W') || (code == 'C')) {
					hit[i] = true;
				}
			}
		}
	}

	public static void draw(Graphics g) {

		if (fire && (row >= 0) && (col >= 0)) {
			// Draw bullets
			for (int i = 0; i < BULLETS; i++) {
				// Draw bullet if still active
				if (!hit[i]) {
					g.setColor(Color.YELLOW);
					g.fillOval(bullet_x[i], bullet_y[i], 6, 6);
				}
			}
		}
	}

}
