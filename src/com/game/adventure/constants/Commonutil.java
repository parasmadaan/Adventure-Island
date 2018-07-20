package com.game.adventure.constants;

import java.util.Random;

public class Commonutil  {
	Random r = new Random();

	public int getRandom(int range){
		int random_no = r.nextInt(range);
		return random_no;
	}
}
