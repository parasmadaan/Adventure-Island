package com.game.adventure.spriteloader;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteLoader {
BufferedImage bfi,throwhammer,fruit;
BufferedImage loadenemy;
public SpriteLoader() {
loadSprite();
}
	public void loadSprite(){
		try {
			bfi=ImageIO.read(SpriteLoader.class.getResource("playersprite.png"));
			throwhammer=ImageIO.read(SpriteLoader.class.getResource("enemy.png"));
			fruit=ImageIO.read(SpriteLoader.class.getResource("fruit.png"));
		} catch (IOException e) {
			System.out.println("error");
			
			
		}
	}
		public BufferedImage[] loadDefaultImage(){
			BufferedImage[] img=new BufferedImage[2];
					
		img[0]=bfi.getSubimage(161, 40, 16, 32);
			img[1]=bfi.getSubimage(186, 40, 16, 32);
			return img;
		}
			
		public BufferedImage[] loadBars()
		{
			BufferedImage[] img=new BufferedImage[1];
		img[0]=fruit.getSubimage(172, 40, 3, 8);
		return img;
		}
		
			public BufferedImage[] loadDefaultImageLeft()
			{
				BufferedImage[] img=new BufferedImage[2];
			img[0]=bfi.getSubimage(135, 40, 16, 32);
			img[1]=bfi.getSubimage(110, 40, 16, 32);

			return img;
			}

	
			public BufferedImage[] Eggpower()
			{
				BufferedImage bf[]=new BufferedImage[3];
				bf[0]=fruit.getSubimage(161, 40, 16, 32);
				bf[1]=fruit.getSubimage(186, 40, 16, 32);
				bf[2]=fruit.getSubimage(186, 40, 16, 32);
				return bf;
			}				
	public BufferedImage[] loadFireImage(){
		BufferedImage[] img=new BufferedImage[2];
				
	img[0]=bfi.getSubimage(212, 43, 22, 29);
		img[1]=bfi.getSubimage(243, 42, 22, 30);
		return img;
	}
	
	public BufferedImage[] loadFireImageLeft()
	{
		BufferedImage[] img=new BufferedImage[2];
				
	img[0]=bfi.getSubimage(78, 43, 22, 29);
		img[1]=bfi.getSubimage(47, 42, 22, 30);
		return img;
	}

	public BufferedImage[] throwHammerImage(){
		BufferedImage[] img=new BufferedImage[4];
				
	img[0]=throwhammer.getSubimage(168, 61, 16, 15);
		img[1]=throwhammer.getSubimage(189, 60, 15, 16);
		img[2]=throwhammer.getSubimage(209, 61, 16, 15);
		img[3]=throwhammer.getSubimage(232, 60, 15, 16);
	
		return img;
	}
	
	public BufferedImage[] throwHammerImageLeft()
	{
		BufferedImage[] img=new BufferedImage[4];
				
		img[0]=throwhammer.getSubimage(142, 61, 16, 15);
		img[1]=throwhammer.getSubimage(122, 60, 15, 16);
		img[2]=throwhammer.getSubimage(101, 61, 16, 15);
		img[3]=throwhammer.getSubimage(79, 60, 15, 16);
	
		String a="aaa";
		
		return img;
		
	
		
	}

	public BufferedImage[] loadSnake(){
		BufferedImage[] img=new BufferedImage[2];
				
		img[0]=throwhammer.getSubimage(102, 8, 15, 23);
		img[1]=throwhammer.getSubimage(82, 8, 15, 23);
		return img;
	}
		
	
		public BufferedImage[] loadFrog()
		{
			BufferedImage[] img=new BufferedImage[3];
		img[0]=throwhammer.getSubimage(112, 129, 24, 11);
		img[1]=throwhammer.getSubimage(92, 124, 17, 16);
		img[2]=throwhammer.getSubimage(73, 124, 17, 16);
		return img;
		}

		public BufferedImage[] loadtortoise(){
			BufferedImage[] img=new BufferedImage[2];
					
		img[0]=throwhammer.getSubimage(26, 7, 24, 24);
			img[1]=throwhammer.getSubimage(53,15, 24, 16);
			return img;
		}

		
		public BufferedImage[] fruit1()
		{
			BufferedImage[] img=new BufferedImage[1];
					
			img[0]=fruit.getSubimage(54, 6, 14, 12);
			return img;
		}
		public BufferedImage[] fruit2()
		{
			BufferedImage[] img=new BufferedImage[1];
					
			img[0]=fruit.getSubimage(69, 4, 14, 14);
			return img;
		}
		public BufferedImage[] fruit3()
		{
			BufferedImage[] img=new BufferedImage[1];
					
			img[0]=fruit.getSubimage(86, 2, 12, 16);
			return img;
		}
		public BufferedImage[] fruit4()
		{
			BufferedImage[] img=new BufferedImage[1];
					
			img[0]=fruit.getSubimage(101, 2, 10, 16);
			return img;
		}
		public BufferedImage[] fruit5()
		{
			BufferedImage[] img=new BufferedImage[1];
					
			img[0]=fruit.getSubimage(114, 4, 16, 14);
			return img;
		}
						
}

