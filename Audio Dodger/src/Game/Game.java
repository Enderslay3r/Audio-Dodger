package Game;

import java.awt.event.KeyEvent;

import Player.Controller;;

public class Game {
	public int time;
	public Controller controls;
	
	public Game() {
		controls = new Controller();
		
	}

	public void tick(boolean[] key) {
		time++;
		boolean up = key[KeyEvent.VK_W];
		boolean down = key[KeyEvent.VK_S];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		boolean attack = key[KeyEvent.VK_SPACE];
		boolean ult = key[KeyEvent.VK_R];
		boolean shield = key[KeyEvent.VK_Q];

		controls.tick(up, down, left, right, attack, ult, shield);
	}
}
