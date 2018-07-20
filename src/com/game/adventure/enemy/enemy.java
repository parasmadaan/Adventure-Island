package com.game.adventure.enemy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.adventure.Player.Player;
import com.game.adventure.constants.EnemyNumber;
import com.game.adventure.constants.GameConstants;
import com.game.adventure.constants.Sprite;
import com.game.adventure.spriteloader.SpriteLoader;

public class enemy extends Sprite implements GameConstants,EnemyNumber {
Player player=new Player();
int currentmove=0;
int maxmove;
SpriteLoader loader=new SpriteLoader();
BufferedImage[] enemyimg;
boolean visible;

	public boolean isVisible() {
	return visible;
}
public void setVisible(boolean visible) {
	this.visible = visible;
	
	
}
	public enemy(int x,int choose,int gap)
	{  visible=true;
		//   chooseEnemy(choose);
	this.w=34;
	this.x=x+(450*gap);
	this.h=34;
	speed=10;
	this.y=FLOOR-h;
	chooseEnemy(choose);
	}
//public	void checkmove(){
		//if(player.isMoving()==true)
	//		move();
	//	player.setMoving(false);
//}
	void chooseEnemy(int choose)
	{
			switch (choose){
			case FROG: 
		{		enemyimg=loader.loadFrog();
				maxmove=3;
				
				
				break;
		}
				case SNAKE: 
		{		enemyimg=loader.loadSnake();
				maxmove=2;
				break;
		}	
				case TORTOISE: 
		{		enemyimg=loader.loadtortoise();
				maxmove=2;
				break;
		}
	
			}		
	}	

	public void drawEnemy(Graphics g){
		g.drawImage(enemyimg[currentmove], x,y, w, h, null); 
	currentmove++;
	if(currentmove>1)
		currentmove=0;
	
	}
public void	move(){

	x=x-speed;
//System.out.println("enemy x pos "+x);

}

}
