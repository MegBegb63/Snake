package ru.progclub.snake;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	/**
	 * ����������� ���� �� ���������
	 */
	public GameWindow(){
		// ������� ������� ����
		GameField fld = new GameField();
		getContentPane().add(fld);	// ��������� ���� � ������� ����
		
		setTitle("������");			// ������ ���������
		
		setBounds(0,0,800,650);		// ������������� ��������� ���� � ��� �������
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// ������� ���������� ��� �������� ����
		
		setResizable(false);	// ��������� �������� ������ ����
		
		setVisible(true);		// �������� ������� ����
	}
	
}
