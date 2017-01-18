/* Package: bearGameMerge
 * Class: Collision
 * Programmer: ICS4U
 * Date Created: January 18, 2016
 * Description: Check collision of good player and the bullet.
 */

package bearGameMerge2;

import java.util.ArrayList;

public class Collision {
	public static boolean crash(ArrayList<BadPlayer> badPlayers,
			GoodPlayer goodPlayer) {
		boolean crash = false;
		//Collision is true if bullet hits good player
		for (int i = 0; i < badPlayers.size(); i++) {
			if (Bullet.collision(goodPlayer.row, goodPlayer.col))
			{
				crash = true;
			} 
		}
		return crash;

	}
}