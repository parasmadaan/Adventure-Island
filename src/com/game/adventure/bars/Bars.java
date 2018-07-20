package com.game.adventure.bars;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.adventure.constants.GameConstants;
import com.game.adventure.constants.Sprite;
import com.game.adventure.spriteloader.SpriteLoader;

public class Bars extends Sprite implements GameConstants {
SpriteLoader loader=new SpriteLoader();
	BufferedImage[] bars=loader.loadBars();;
	boolean visible;//=true;
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Bars(int x,int gap)
	{  
		visible=true;
		
	
	this.w=15;
	this.x=x+(20*gap);
	this.h=20;
	this.y=200;
//	chooseEnemy(choose);
	}
public void drawBars(Graphics g){
	//if(this.visible==true)
g.drawImage(bars[0], x, y, w, h, null);
}
	
}
