package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoard extends JFrame {
	private JButton[][] buttons;
	
	TicTacToe t = new TicTacToe();
	
	private JFrame mainBoard = new JFrame("Tic Tac Toe");
	
	public GameBoard()
	{
		buttons = new JButton[3][3];
		buildGameBoard();
	}
	
	public static void main(String[] args)
	{
		GameBoard board = new GameBoard();
	}
	
	private void buildGameBoard()
	{
		mainBoard.setSize(300,300);
		mainBoard.setLayout(new GridLayout(3,3));
		mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int keepPosition = 1;
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				buttons[row][col] = new JButton("");
				buttons[row][col].setName("Location" + row + col);
				buttons[row][col].addActionListener(new ButtonListener(row,col));
				buttons[row][col].setFont(new Font("", Font.PLAIN, 72));
				mainBoard.add(buttons[row][col]);
				keepPosition++;
			}
		}
		mainBoard.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener 
	{
		private int row;
		private int col;
		
		public ButtonListener(int r, int c)
		{
			row = r;
			col = c;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			buttonPress(row, col);
		}
	}
	
	public void buttonPress(int row, int col)
	{
		JOptionPane optionPane = new JOptionPane();
		
		t.setMark(row, col);
		
		if(t.getMark(row,col) == TicTacToe.Mark.XMARK)
		{
			buttons[row][col].setLabel("X");
		}
		else if(t.getMark(row, col) == TicTacToe.Mark.OMARK)
		{
			buttons[row][col].setLabel("O");
		}
		
		if(t.getStatus() == TicTacToe.gameStatus.XWIN)
		{
				optionPane.showMessageDialog(optionPane, "The winner is X", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(t.getStatus() == TicTacToe.gameStatus.OWIN)
		{
				optionPane.showMessageDialog(optionPane, "The winner is O", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		if(t.getStatus() == TicTacToe.gameStatus.DRAW)
		{
				optionPane.showMessageDialog(optionPane, "The winner is TIE", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}