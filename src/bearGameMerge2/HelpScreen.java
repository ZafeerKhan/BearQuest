/* Package: bearGameMerge
 * Class: HelpScreen
 * Programmer: ICS4U
 * Date Created: January , 2016
 * Description: Create Help Screen
 */

package bearGameMerge2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HelpScreen {
	public static int x = 300;
	public static int y = 100;
	
	public static void draw(Graphics g) {
		//Set colour of help panel 
		Color hBG = new Color(100,100,250);
		g.setColor(hBG);
		//Fill help panel.
		g.fillRect(x, y, 800, 480);
		
		//Set Font for heading
		g.setColor(Color.GREEN);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		g.drawString("Help Menu", x+288, y+55);
		
		// Set font for subheading
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		g.drawString("Keystrokes:", x+55, y+95);
		g.drawString("Basic Game Principles:", x+55, y+265);
		g.drawString("Press 'H' to close.",x+55, y+455);

		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		g.setColor(Color.GREEN);
		g.drawString("W", x+120, y+128);
		g.drawString("S", x+440, y+128);
		g.drawString("A", x+120, y+152);
		g.drawString("D", x+440, y+152);
		g.drawString("H", x+120, y+175);
		g.drawString("P", x+440, y+175);
		
		g.setColor(Color.BLACK);
		g.drawString("- Move Forward", x+150, y+128);
		g.drawString("- Move Backward", x+470, y+128);
		g.drawString("- Move Left", x+150, y+152);
		g.drawString("- Move Right", x+470, y+152);
		g.drawString("- Help", x+150, y+175);
		g.drawString("- Pause", x+470, y+175);
		g.drawString("Arrow keys can also be used to navigate.", x+125, y+210);

		//Description on help screen
		g.drawString(
				"A bear needs to collect food for hibernation.",
				x+130, y+295);
		g.drawString("The objective of the game is to collect enough food ",
				x+100, y+325);
		
		g.drawString("to hibernate and to get back to the cave before winter.",
				x+90, y+355);
		g.drawString("Move the bear to start the game. ", x+190, y+385);
		
		
	}
}
