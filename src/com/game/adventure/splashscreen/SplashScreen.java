package com.game.adventure.splashscreen;
import com.game.adventure.mainmenu.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow {

	private JPanel contentPane;
	 private JProgressBar progressBar = new JProgressBar();
	 Timer timer;
	 private int currentprogress;
	 private boolean isvisible;
	 private void doAnimation(){
		 timer= new Timer(10,(e)->{
			progressBar.setValue(currentprogress);
			 currentprogress++;
			 if(currentprogress>100){
				 timer.stop();
				 SplashScreen.this.setVisible(false);
				 SplashScreen.this.dispose();
				 MainMenu mainmenu= new MainMenu();
				 mainmenu.setVisible(true);
			 }
			 isvisible=!isvisible;
		 });
		 timer.start();
	 }
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.doAnimation();
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setBackground(new Color(240,240, 240));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 480);
		//setSize(450, 382);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(0, 338, 635, 26);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("splash.JPG")));
		lblNewLabel.setBounds(0, 0,642,441);
		contentPane.add(lblNewLabel);
	}
}




