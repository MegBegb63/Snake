package ru.progclub.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GameField extends JPanel {
	private GameLogic game;	// ������� ������
	
	private Timer tmDraw;	// ������ ��������� 
	
	private Image bckgrnd, body, head, feed, gameOver;	// �������
	
	private JLabel lbScore;	// ����� � ������������� ������
	
	private JButton btnNew, btnExit;	// ������ ������ ����� ���� � ������
	
	public GameField(){
		loadResources();	// ��������� ������� � ���� �������
		
		// �������������� ���������� game � ��������� ������� ������		
		game = new GameLogic();
		game.start();
		
		
		//������� � ��������� ������ ���������
		tmDraw = new Timer(20, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
			}
		});
		tmDraw.start();
		
		setLayout(null);
		
		
		// ������� ������� � ������
		lbScore = new JLabel("����: -");	// �������������� � ��������� ��������� ��������
		lbScore.setForeground(Color.WHITE);	// ������������� ���
		lbScore.setFont(new Font("serif", 0, 30));	// �����
		lbScore.setBounds(630, 200, 150, 50);	// ���� ������������ � ������
		add(lbScore); // ��������� ������� � �������
		
		
		// ������ ����� ����
		btnNew = new JButton();			// ��������������
		btnNew.setText("New Game");		// ������ ����� ������
		btnNew.setForeground(Color.BLUE);	// ����
		btnNew.setFont(new Font("serif", 0, 20));	// �����
		btnNew.setBounds(630, 30, 150, 50);			// ��� ��������� � ������
		btnNew.addActionListener(new ActionListener() { // ���������� ��

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.start();	// ������� ��������� ����
			}	
			
		});
		add(btnNew);	// ��������� ������ � �������
		
		
		// ������ ������
		btnExit = new JButton();
		
		
		
		
		
		
	}
	
	/**
	 * ��������� ����������� ��� ���� �������
	 */
	private void loadResources(){
		try{
			// ��������� � ������ �������
			this.bckgrnd = ImageIO.read(new File("sprites\\bg.png"));
			this.body = ImageIO.read(new File("sprites\\body.png"));
			this.head = ImageIO.read(new File("sprites\\head.png"));
			this.feed = ImageIO.read(new File("sprites\\feed.png"));
			this.gameOver = ImageIO.read(new File("sprites\\gameover.png"));
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		
		gr.drawImage(bckgrnd, 0, 0, 800, 600, null);
		
		for(int i=0; i < game.DEFAULT_HEIGHT; i++){		// height = ������
			for(int j = 0; j< game.DEFAULT_WIDTH; j++){	// width = �������
				
				if(game.getValue(j, i) != 0){
					if(game.getValue(j, i) == 1){
						gr.drawImage(head, 10+j*20, 10+i*20, 20, 20, null);
					}
					else if(game.getValue(j, i) == -1){
						gr.drawImage(feed, 10+j*20, 10+i*20, 20, 20, null);
					}
				}				
			}
		}
		gr.setColor(Color.BLUE);
		for(int i=0; i<=game.DEFAULT_WIDTH; i++){
			gr.drawLine(10+i*20, 10, 10+i*20, 610);
			gr.drawLine(10, 10+i*20, 610, 10+i*20);
		}
	}


}
