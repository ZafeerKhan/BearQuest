/* Package: bearGameMerge
 * Class: BadPlayer
 * Programmer: ICS4U
 * Date Created: January 18, 2016
 * Description: Bad guy for bear game, hunter
 */
package bearGameMerge2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BadPlayer  {
	
	//Draw hunter
	public static void draw(Graphics g, int x, int y, BufferedImage hunterPhoto) {
		g.drawImage(hunterPhoto, x, y, null);
	}

}