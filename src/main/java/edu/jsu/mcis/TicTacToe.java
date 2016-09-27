package edu.jsu.mcis;

public class TicTacToe {

	public enum Mark {XMARK, OMARK, EMPTY};
	
	public boolean xTurn;
	
	public Mark[][] board;
	
	public enum gameStatus {XWIN, OWIN, DRAW, KEEPGOING};
	
	public gameStatus Status; 
	
	public int countsTheMoves;
	
	public TicTacToe () {
		board = new Mark[3][3];
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				board[row][col] = Mark.EMPTY;
			}
		}
		countsTheMoves = 0;
		Status = gameStatus.KEEPGOING;
		xTurn = true;
	}

	public Mark getMark(int row, int col)
	{
		return board[row][col];
	}

	public void setMark(int row, int col)
	{
		Mark mark = Mark.EMPTY;
		if(board[row][col] == Mark.EMPTY)
		{
			if(xTurn)
			{	
				mark = Mark.XMARK;
				board[row][col] = mark;
				
			}
			else
			{
				mark = Mark.OMARK;
				board[row][col] = mark;
				
			}
			xTurn = !xTurn;
			countsTheMoves++;
			WinLoseDraw(row,col,mark);
		}
	}
	
	public void WinLoseDraw(int row, int col, Mark mark){

			for(int i = 0; i < board.length; i++)
			{
				if(board[row][i] != mark)
					break;
				if(i == board.length - 1)
				{
					if(mark == Mark.XMARK)
					{
						Status = gameStatus.XWIN;
					}
					else 
					{
						Status = gameStatus.OWIN;
					}
				}
			}
			
			for(int i = 0; i < board[row].length; i++)
			{
				if(board[i][col] != mark)
					break;
				if(i == board[row].length - 1)
				{
					if(mark == Mark.XMARK)
					{
						Status = gameStatus.XWIN;
					}
					else 
					{
						Status = gameStatus.OWIN;
					}
				}
			}
			if(row == col)
			{
				for(int i = 0; i < board.length; i++)
				{
					if(board[i][i] != mark)
						break;
					if(i == board.length - 1)
					{
						if(mark == Mark.XMARK)
					{
						Status = gameStatus.XWIN;
					}
					else 
					{
						Status = gameStatus.OWIN;
					}
					}
				}
				
				for(int i = 0; i < board.length; i++)
				{
					if(board[i][(board.length - 1) - i] != mark)
						break;
					if(i == board.length - 1){
						if(mark == Mark.XMARK)
					{
						Status = gameStatus.XWIN;
					}
					else 
					{
						Status = gameStatus.OWIN;
					}
					}
				}
			}
		if(countsTheMoves == (board.length * board.length))
			Status = gameStatus.DRAW;
	}
	
	public gameStatus getStatus(){
		return Status;
	}
	
	public static void main(String[] args) {
		GameBoard frame = new GameBoard();
	}
}
