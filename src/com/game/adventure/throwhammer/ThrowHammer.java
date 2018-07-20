package com.game.adventure.throwhammer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.adventure.Player.Player;
import com.game.adventure.constants.GameConstants;
import com.game.adventure.constants.Sprite;
import com.game.adventure.spriteloader.SpriteLoader;

public class ThrowHammer extends Sprite implements GameConstants {
	SpriteLoader loader= new SpriteLoader();
	BufferedImage bi[];
	Player player=new Player();
	private boolean isVisible;
int acc=-5;
	public ThrowHammer(int x,int y){
		this.x = x;
		this.y = y;
		this.w = this.h = 30;
		this.speed = 10;
		this.isVisible = true;
	}
	
	public void SetImage()
	{
		if(player.isFacing()==true)
			bi=loader.throwHammerImage();
		if(player.isFacing()==false)
			bi=loader.throwHammerImageLeft();
	}
	public boolean isVisible() {
		return isVisible;
	}


	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}


	public void drawHammer(Graphics g){
	throwHammerAttack(g);
		move();
		
	}
	public void move(){
		x+=15*GRAVITY;
			y=y+acc;
			acc++;
	}

	int fireMove = 0;
	public void throwHammerAttack(Graphics g){
		g.drawImage(bi[fireMove],x,y,w,h,null);
		fireMove++;
		move();
		if(fireMove>3){
			fireMove=0;
			speed = 0;
			}
	}
}
