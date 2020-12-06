package com.total.digitalfactory.tenniskata;

/**
 * Game Class
 * 
 * @since 
 */
public class TennisGame {
	
	private Player _player1;
	private Player _player2;
	
	
	
	
	
	public TennisGame(Player player1, Player player2) {
		super();
		_player1 = player1;
		_player2 = player2;
		// set score 0;
		_player1.initScore();
		_player1.initScore();
		
	}




	public Player getPlayer1() {
		return _player1;
	}




	public void setPlayer1(Player player1) {
		_player1 = player1;
	}




	public Player getPlayer2() {
		return _player2;
	}




	public void setPlayer2(Player player2) {
		_player2 = player2;
	}




	public TennisGameScore getScore() {
		
		
		
		
		
		
		return null;
		
		
	}
	
	
}
