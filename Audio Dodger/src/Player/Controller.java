package Player;

import Game.Game;

public class Controller {
	public double xmove, ymove;
	public int health = 3;
	public int shields = 1;
	public void tick(boolean up, boolean down, boolean left, boolean right, boolean ult, boolean shield,
			boolean attack) {
		if (up) {
			ymove++;
			System.out.println("Up");
		}
		if (down) {
			ymove--;
			System.out.println("Down");
		}
		if (left) {
			xmove--;
			System.out.println("Left");
		}
		if (right) {
			xmove++;
			System.out.println("Right");
		}
		if (shield) {
			health = health + shields;
			System.out.println("Shields up");
		}
	}
}
