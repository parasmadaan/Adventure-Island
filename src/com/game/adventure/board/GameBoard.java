package com.game.adventure.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.game.adventure.Player.Player;
import com.game.adventure.bars.Bars;
import com.game.adventure.camera.Camera;
import com.game.adventure.constants.Commonutil;
import com.game.adventure.constants.GameConstants;
import com.game.adventure.enemy.enemy;
import com.game.adventure.fruit.Fruit;
import com.game.adventure.spriteloader.SpriteLoader;
import com.game.adventure.throwhammer.ThrowHammer;

public class GameBoard extends JPanel implements GameConstants{
Camera camera= new  Camera();
String re="9";
Player player=new Player();
Commonutil util=new Commonutil();
int startgame=0;
int restart=0;
ArrayList<enemy>enemies=new ArrayList<>(max_no_of_Enemy);
ArrayList<Fruit>fruits=new ArrayList<>(max_no_of_fruit);
ArrayList<Bars>bars=new ArrayList<>(max_no_of_Bars);
SpriteLoader loader =new SpriteLoader();
boolean isGameOver;
boolean gameStart;
public  GameBoard() {
	KeyEventBinder();
	setSize(Board_width,Board_height);
	setFocusable(true);
	
	gameLoop();
	

	//Thread thread=new Thread();
	prepareEnemy();
	preparefruit();
	 prepareBars();
	checkFruitCollision();
}
Timer timer;
int counter =0;
private void gameLoop(){
	timer  = new Timer(50,(e)->{
		startgame++;
		
		if(startgame>150)
		{		
		repaint();
		checkFruitCollision();
		checkCollision();
		hammerEnemyCollision();
		player.fall();
		checkCompletion();
		}
		repaint();
		});
	timer.start();
}



private void prepareEnemy(){
	for(int i=0;i<max_no_of_Enemy;i++)
	{int q=util.getRandom(3);
		enemies.add( new enemy(500,q,i));
	}
}


private void prepareBars(){
	
	for(int i=0;i<max_no_of_Bars;i++)
	{
		bars.add( new Bars(480,i));
	}
}

void Drawstart(Graphics g){
	
	 if(startgame>0 && startgame<50)
	 {	g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,140));
			g.drawString("3", (Board_width/2)-160, 300);
	 }	 
	
	 else if(startgame>50 && startgame<100)
			 {
				 g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,140));
			g.drawString("2", (Board_width/2)-160, 300);
			 } 
	 else if(startgame>100 && startgame<140)
			 {		
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,140));
			g.drawString("1", (Board_width/2)-160, 300);
			 }
			 
			 else	{
				 g.setColor(Color.RED);
					g.setFont(new Font("Arial",Font.BOLD,140));
					g.drawString(" ", (Board_width/2)-160, 300);
					 }
					
			 } 
			 		 
boolean stop;


private void preparefruit(){
	for(int i=0;i<max_no_of_fruit;i++)
	{int q=util.getRandom(5);
		fruits.add( new Fruit(450,q,i));
		}
}


public void KeyEventBinder(){
	this.addKeyListener(new KeyAdapter() {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			
				camera.setSpeed(8);
				player.setFacing(true);
				player.setMoving(true);
				player.setImage();
						if(camera.getX()>(4500-Board_width))
						{
							//camera.setSpeed(0);
					//	player.setMoving(false);
					player.setSpeed(10);
							player.move();
					
						}
						
			}
			
			
			if(e.getKeyCode()==KeyEvent.VK_F){
			player.drawHammer();
			player.SetFireAttack();
			
			}
			
			
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			player.setFacing(false);
			player.setImage();
				}
	if(e.getKeyCode()==KeyEvent.VK_UP){
		camera.setSpeed(10);
		
		player.setMoving(true);
		player.jump();
		//player.fall();
		
	}
	if(e.getKeyCode()==KeyEvent.VK_SPACE){
		if(isGameOver==true)
		{
			stop=false;
			player.setMoving(false);
			restart=0;
			camera.setX(camera.getX()-100);
			for(enemy Enemy:enemies)
			{
				Enemy.setX(Enemy.getX()-50);
			}
			isGameOver=false;
		}
	}
	}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_UP)
				
				player.setMoving(false);
			
		}
	});
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		camera.drawBG(g);
		
		Drawstart(g);
		if(startgame>150)
		{
			if(player.isMoving()==true)
				camera.right();
			drawBars(g);	
			counter++;
			if(player.isVisible()==true)
			{
				System.out.println("player is drawing");
				if(stop==false)
				player.drawPlayer(g);
				
			}
			if(stop==false)
			{drawEnemy(g);
			drawFruit(g);
			drawHammer(g);
			drawBars(g);}
		removeBars();
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,40));
		g.drawString("Score "+score, Board_width-200, 70);
		
		
		if(isGameOver)
		{
		restart++;
		checkrestart();	
		Restart(g);	
		gameOver(g);
		return;
		}
		if(isLeveldone==true){
			levelCompleted(g);
			return;
		}
		}		
	}	
 
	
	
	//player.move();
	public void drawHammer(Graphics g){
		for(ThrowHammer hammer : player.getHammerlist()){
		hammer.SetImage();
		if(hammer.isVisible()==true)
			hammer.drawHammer(g);	
			if(hammer.getY()>FLOOR)	
				hammer.setVisible(false);
		}
		}
	
	
	 private  void drawEnemy(Graphics g)
	 {
		 for(enemy Enemy:enemies)
		 {if(Enemy.isVisible()==true)
		 { Enemy.drawEnemy(g);}
			 if(player.isMoving()==true)
			 {Enemy.move();}
			 
	 }
	 }
	 private  void drawFruit(Graphics g)
	 {
		 for(Fruit fruit:fruits)
		 {if(fruit.isVisible()==true)
		 { 
			 fruit.drawFruit(g);
		 }	 		
			 if(player.isMoving()==true)
			 {fruit.move();}
			 
		 }
	 }
	 
	 private  void drawBars(Graphics g)
	 {		 //System.out.println();
	 	for(Bars bar:bars)
	 	{ //System.out.println(bar.isVisible());
	 		if(bar.isVisible())
	 		{bar.drawBars(g);}
	 		
		 }
	 }
	 
	Graphics gh;
	 void removeBars() 
		
		{
		 switch(counter)	
		 {
		 case 100:
			 bars.get(0).setVisible(false);
			 break;
		 case 200:
			 bars.get(1).setVisible(false);
			 break;
		 case 300:
			 bars.get(2).setVisible(false);
			 break;
		 case 400:
			 bars.get(3).setVisible(false);
			 break;
		   case 500:
			 bars.get(4).setVisible(false);
			  isGameOver=true;
			  
			  timer.stop(); 
			  break;
		 }
		}
	 int score;
		
	
	int baradd=0;
	 void baradd(){
		
		 
		 for(int i=4;i>=0;i--)
		
		{		 {
			 	if (bars.get(i).isVisible()==false)
			 {
				 bars.get(i).setVisible(true);
				 counter=i*100;
						     ;
				 baradd++;
				 return;
			 }
			 }
		}
		}
	 
	 Rectangle a,b;
	
	 public boolean isCollision(Player player, enemy Enemy){
		
		 if (Enemy.isVisible()==true){
		  a=new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
		  b=new Rectangle(Enemy.getX(),Enemy.getY(),Enemy.getW(),Enemy.getH());
			
		}
		return	a.intersects(b);
	 }
	 Rectangle c,d;
	 public boolean ishammerCollision(ThrowHammer hammer, enemy Enemy){
		if(hammer.isVisible()==true)	 
		{
			c=new Rectangle(hammer.getX(),hammer.getY(),hammer.getW(),hammer.getH());
				 d=new Rectangle(Enemy.getX(),Enemy.getY(),Enemy.getW(),Enemy.getH());
	 
				 return	c.intersects(d);
		}
				return false;
	 }
		
	 
	 public boolean isCollisionFruit(Player player,Fruit fruit){
			if(fruit.isVisible()==true)	 
			{
		 	Rectangle a=new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
				Rectangle b=new Rectangle(fruit.getX(),fruit.getY(),fruit.getW(),fruit.getH());
				return	a.intersects(b);
			}
			return false;
	 }
		Boolean isLeveldone=false;
	 public void checkCollision(){
			
			for(enemy Enemy: enemies){
			//System.out.println(Enemy.getX());
				if(isCollision(player, Enemy)==true){
					isGameOver=true;
					//	Enemy.setVisible(false);
					stop=true;
					repaint();
			//	timer.stop();	
				}
				}
	 }	 
	 public void checkFruitCollision(){
			
			for(Fruit fruit: fruits){
		//		System.out.println(fruit.getX());//yatin.syal07@gmail.com
				if(isCollisionFruit(player,fruit)==true){
					
					score=score+100;
					fruit.setVisible(false);
				//if(baradd<1)
					baradd();
					System.out.println("food collided......");
					repaint();
					//timer.stop();
				}}
	 }	 

	 public void hammerEnemyCollision(){
			
		 for(enemy Enemy: enemies){
			
			  for(ThrowHammer hammer:player.getHammerlist())
				 { hammer.getX();
				 	if(ishammerCollision(hammer, Enemy)==true)
				 	{
				 		score=score+50;
						//enemies.remove(Enemy);
				 		Enemy.setVisible(false);
						hammer.setVisible(false);	
				 		repaint();
						//	timer.stop();	
					}
					}
		  }	 
	 }
	 
	 public void gameOver(Graphics g){
			g.setColor(Color.RED);
				g.setFont(new Font("Arial",Font.BOLD,60));
				g.drawString("Game Over",(Board_width/2)-40,(Board_height/2)-40);
		}
	 public void checkCompletion(){
		 System.out.println(isLeveldone);
		 if(player.getX()>1000)
		 {
			 System.out.println("player is disappeared.....");
			 player.setVisible(false);
			 isLeveldone=true;
			 timer.stop();
		 }
	 
	 }
public void levelCompleted(Graphics g){
{	g.setColor(Color.RED);
	g.setFont(new Font("Arial",Font.BOLD,60));
	g.drawString("Game Completed",(Board_width/2)-80,(Board_height/2)-40);
}

} 
void Restart(Graphics g){
	g.setColor(Color.RED);
	   
	g.setFont(new Font("Arial",Font.BOLD,40));
	g.drawString("Press double space to continue", Board_width/2-150, 470);
	
	g.drawString(re, (Board_width/2), 530);
	
}

void checkrestart(){
	if(restart==0)
		re=" ";
	else if(restart>0 && restart<=10)
 		re="9";

	else if(restart>10 && restart<=20)
		 		re="8";
		 else if(restart>20 && restart<=30)
				re="7";
			 else if(restart>30 && restart<=40)
					re="6";
				 else if(restart>40 && restart<=50)
						re="5";
	   
					 else if(restart>50 && restart<=60)
							re="4";
						 else if(restart>60 && restart<=70)
								re="3";
							 else if(restart>70 && restart<=80)
									re="2";
								 else if(restart>80 && restart<=90)
								 re="1";
									 else
			   					{   re=" ";
									timer.stop();
								}	 
}


}
