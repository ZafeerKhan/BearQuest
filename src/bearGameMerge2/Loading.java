/* Package: bearGameMerge
 * Class: Loading
 * Programmer: ICS4U
 * Date Created: January , 2016
 * Description: Loading screen before game starts
 */

package bearGameMerge2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Loading {
	public static void drawLoading(Graphics g, int x, int y, BufferedImage loadingPhoto) {
		g.drawImage(loadingPhoto, x, y, null);
	}
}
