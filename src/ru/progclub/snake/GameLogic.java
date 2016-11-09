package ru.progclub.snake;

public class GameLogic {
	public static final int DEFAULT_WIDTH = 30;	// ����������� ������ ����
	public static final int DEFAULT_HEIGHT = 30;	// ����������� ������ ����
	
	
	private int[][] field;	// ������, �� �������� ������������ ���� ������
	
	/**
	 * ����������� ���������
	 */
	public GameLogic(){
		field = new int[DEFAULT_WIDTH][DEFAULT_HEIGHT];	// ������� ����������� ����
	}
	
	/**
	 * ����������, ��������� ���� ��������� ������ � ������
	 * @param width ������ ����
	 * @param height ������ ����
	 */
	public GameLogic(int width, int height){
		field = new int[width>0 ? width : DEFAULT_WIDTH][height>0 ? height : DEFAULT_HEIGHT];
	}
	
	/**
	 * ���������� ���� ��� ������
	 */
	private void generateFeed(){
		int x,y;	// ���������� ���������
		
		while(true){
			x=(int)(Math.random()*DEFAULT_WIDTH);	// �������� � � �������� 0-30
			y=(int)(Math.random()*DEFAULT_HEIGHT);	// �������� � � �������� 0-30
			
			if(field[y][x] == 0){	// ���� ������ �����
				field[y][x] = -1;	// ������ � ��� ���
				break;				// � ������ ����
			}
		}
	}
	
	public void start(){
		this.clear();
		
		field[DEFAULT_WIDTH/2][DEFAULT_HEIGHT/2] = 1;
		
		generateFeed();
		
	}
	
	/**
	 * ������� ������� ����
	 */
	private void clear(){
		for(int i=0; i<DEFAULT_HEIGHT; i++){
			for(int j=0; j<DEFAULT_WIDTH; j++){
				field[i][j] = 0;
			}
		}
	}
	
	/**
	 * ���������� �������� � ������� �� �����������
	 * @param col
	 * @param row
	 * @return
	 */
	public int getValue(int col, int row){
		return this.field[col][row];
	}
}
