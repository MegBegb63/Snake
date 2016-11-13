package ru.progclub.snake;

public class GameLogic {
	public static final int DEFAULT_WIDTH = 30;	// ����������� ������ ����
	public static final int DEFAULT_HEIGHT = 30;	// ����������� ������ ����
	
	private int direction;	// ����������� �������� ������ 0-�; 1-�; 2-�;3-�
	
	private int gX, gY;	// ���������� ������
	
	private int score;	// ���������� �����
	
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
		this.clear();		// ������� ������� ����
		
		this.direction=0;	// ������������� ����������� �������� �����
		
		this.score = 0;		// �������� ����
		
		this.gX = this.gY = 15;	// ������ ���������� ������
		
		this.field[15][15] = 1;	// ������� ������
		
		generateFeed();	// ������� ���
		
	}
	
	/**
	 * ���������� ������ ������ �� �������� ����
	 */
	public void moveHead(){
		this.field[gX][gY] = 0;	// ����� 
		
		
		switch(direction){
			case 0:
				gX = gX-1 >= 0 ? gX-1 : 29;
				break;
			case 1:
				gY = gY-1 >= 0 ? gY-1 : 29;
				break;
			case 2:
				gX = gX+1 <= 29 ? gX+1 : 0;
				break;
			case 3:
				gY = gY+1 <= 29 ? gY+1 : 0;
				break;
		}
		
		if(field[gY][gX]==-1){
			generateFeed();
			score+=10;
		}
		
		field[gY][gX] = 1;
		
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
