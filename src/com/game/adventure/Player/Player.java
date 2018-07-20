package com.game.adventure.Player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.adventure.constants.GameConstants;
import com.game.adventure.constants.PlayerState;
import com.game.adventure.constants.Sprite;
import com.game.adventure.spriteloader.SpriteLoader;
import com.game.adventure.throwhammer.ThrowHammer;
public class Player extends Sprite implements GameConstants,PlayerState {
SpriteLoader loader= new SpriteLoader();
BufferedImage []defaultMove;
BufferedImage []fireAttack;

int acc;
boolean isjump;
ArrayList<ThrowHammer> hammerlist = new ArrayList<>();

int currentState=DEFAULT_WALK;
 int currentmove=0;
 int firemove=0;
 boolean facing=true;
 boolean visible;
 public boolean isVisible() {
	return visible;
}
public void setVisible(boolean visible) {
	this.visible = visible;
}
public boolean isFacing() {
 	return facing;
 }
 public void setFacing(boolean facing) {
 	this.facing = facing;
 }
boolean moving;
 public Player(){
	moving=false; 
	visible=true;
	 setImage();
	 x = 40;
		h =37;
		w=33;
		y=FLOOR-h;
	speed=20;
}

 public void drawHammer(){
		hammerlist.add(new ThrowHammer((x+w/2),(y+h/2)));

 }
public ArrayList<ThrowHammer> getHammerlist() {
	return hammerlist;
}
public void setHammerlist(ArrayList<ThrowHammer> hammerlist) {
	this.hammerlist = hammerlist;
}
public void setImage(){
	if(facing==true)
	{
		 defaultMove=loader.loadDefaultImage();	
fireAttack=loader.loadFireImage();
	}	if(facing==false)
	{
		defaultMove=loader.loadDefaultImageLeft();	
fireAttack=loader.loadFireImageLeft();
	}
	}	
 
	public void drawPlayer(Graphics g){
if(currentState==DEFAULT_WALK)
		drawDefaultImage(g);
if(currentState==FIRE_ATTACK)
	drawFireAttack(g);
	}

	
	
	public void drawDefaultImage(Graphics g){
		g.drawImage(defaultMove[currentmove], x,y, w, h, null); 
	currentmove++;
	if(currentmove>1)
		currentmove=0;
	}
	
	public void SetFireAttack(){
		firemove=0;
		currentState=FIRE_ATTACK;
	}
	
	int fireMove = 0;
	public void drawFireAttack(Graphics g){
		g.drawImage(fireAttack[fireMove],x,y,w,h,null);
		fireMove++;
		move();
		if(fireMove>1){
			fireMove=0;
			speed = 0;
			currentState = DEFAULT_WALK;
			currentmove = 0;
		}
	}
	
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public void move()
	{
		x=x+speed;
		System.out.println(x);
	}
	
	public void jump()
	{
		if(!isjump){
			acc=-10;
			y=y+acc;
			isjump=true;
		}
	}
	
	public void fall(){
		if(y<(FLOOR-(h))){
			acc= acc+GRAVITY;
			y=y+acc;
		}
		if(y>=(FLOOR-(h))){
				y=FLOOR-(h);
				isjump=false;
				
		}
	}  		

}