package com.game.adventure.frame;
import java.awt.Color;

import javax.swing.JFrame;

import com.game.adventure.board.GameBoard;
import com.game.adventure.constants.GameConstants;
import com.game.adventure.mainmenu.MainMenu;

public class Frame extends JFrame implements GameConstants{
 
	public Frame(){
		setSize(Frame_width,Frame_height);
		
		setResizable(false);
		setTitle("Super Mario");
		GameBoard board =new GameBoard();
		add(board);
		setVisible(true);
	}
public static void main(String[] args) {
	MainMenu menu=new MainMenu();
	menu.setVisible(false);
	Frame frame=new Frame();
	}
}
