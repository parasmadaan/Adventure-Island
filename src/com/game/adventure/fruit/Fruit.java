package com.game.adventure.fruit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.adventure.constants.EnemyNumber;
import com.game.adventure.constants.GameConstants;
import com.game.adventure.constants.Sprite;
import com.game.adventure.spriteloader.SpriteLoader;

public class Fruit extends Sprite implements GameConstants,FruitNumber{
	int currentmove=0;
	
	SpriteLoader loader=new SpriteLoader();
	BufferedImage[] fruitimg;
	boolean visible;

	public boolean isVisible() {
	return visible;
}
public void setVisible(boolean visible) {
	this.visible = visible;
}

	
		public Fruit(int x,int choose,int gap)
		{  visible =true;
			//   chooseEnemy(choose);
		this.w=24;
		this.x=x+(400*gap);
		speed=9;
		this.h=24;
		this.y=550;
		chooseFruit(choose);
		}
		
		void chooseFruit(int choose)
		{
				switch (choose){
				case FRUIT1: 
			{		fruitimg=loader.fruit1();
					break;
			}
					case FRUIT2: 
			{		fruitimg=loader.fruit2();
					break;
			}	
					case FRUIT3: 
			{
				fruitimg=loader.fruit3();
					break;
			}
		
					case FRUIT4: 
					{		fruitimg=loader.fruit4();
							break;
					}
				
				
					case FRUIT5: 
					{		fruitimg=loader.fruit5();
							break;
					}
				}		
		}	

		public void drawFruit(Graphics g){
			g.drawImage(fruitimg[currentmove], x,y, w, h, null); 
			currentmove=0;
		}
	
public void move(){
	x=x-speed;
}
}
