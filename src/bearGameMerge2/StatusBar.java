/* Package: bearGameMerge
 * Class: StatusBar
 * Programmer: ICS4U
 * Date Created: January , 2016
 * Description: Create StatusBar for the game
 */

package bearGameMerge2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StatusBar {
	private static int x = 0;
	private static int y = 705;
	private static int width = 1414;
	private static int height = 64;

	public static void draw(Graphics g, int health, int points, int timeLeft) {
		// Draw bar
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);

		Font statusFont = new Font("Arial", Font.BOLD, 28);

		g.setColor(Color.BLACK);
		g.setFont(statusFont);
		g.drawString("Health: ", x + 10, y + 40);
		g.drawString("Points: ", x + 360, y + 40);
		g.drawString("Time Left: ", x + 710, y + 40);
		g.setColor(Color.YELLOW);
		g.drawString("" + timeLeft, x + 860, y + 40);

		// Draw health bar	
		g.setColor(Color.WHITE);
		g.fillRect(x + 120, y + 10, 200, 38);
		
		if (health < 30)
			g.setColor(Color.RED);
		else if (health < 60)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.GREEN);
		
		g.fillRect(x + 120, y + 10, health * 200 / 100, 38);

		// Draw points bar
		//points=2;
		g.setColor(Color.WHITE);
		g.fillRect(x + 470, y + 10, 200, 38);
		
		g.setColor(Color.YELLOW);

		g.fillRect(x + 470, y + 10, points * 200 / 530, 38);

		
	}
}
