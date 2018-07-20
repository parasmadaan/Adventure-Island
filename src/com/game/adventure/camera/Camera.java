package com.game.adventure.camera;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.imageio.ImageIO;

import com.game.adventure.Player.Player;
import com.game.adventure.constants.GameConstants;
import com.game.adventure.enemy.enemy;

public class Camera implements GameConstants {
		int x;
		int y;
		boolean lastscreen=false;
		public boolean isLastscreen() {
			return lastscreen;
		}

		public void setLastscreen(boolean lastscreen) {
			this.lastscreen = lastscreen;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}





		int h;
		int w;
		int speed;
		BufferedImage bi;
		
		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public Camera(){
			try{
				bi = ImageIO.read(Camera.class.getResource(BG_MAP));
				System.out.println();
			}
			catch(Exception e)
			{
					System.out.println("Game Would n't Work Someone Delete the BackGround...");
					System.out.println("Thanks for Using");
					System.exit(0);
				}
		}
		
		public void left()
		{
			if(x>10)
			{
			move();
			}
		}
		
		public void right()
		{
			if(x<(4500-Board_width))
			{
			move();
			}
		}
		
		public void move()
		{
			
			x+=speed;
		}
		
		
		
		
		
		public void drawBG(Graphics g){
			BufferedImage subImage = bi.getSubimage(x, y, Board_width, Board_height);
		//	System.out.println("X "+x+" Y "+y );
			g.drawImage(subImage,0,0,Board_width,Board_height,null);
		}
}
