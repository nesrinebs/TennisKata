package com.total.digitalfactory.tenniskata;

import java.util.HashMap;
import java.util.Map;

/**
 * Game Class
 * 
 * @since 1.0
 * @author nesrine
 */
public class TennisGame {
	
	private Player _player1;
	private Player _player2;
	
	public TennisGame(Player player1, Player player2) {
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
	
	public Map<Player, TennisGameScore> getScore() {
		Map<Player, TennisGameScore> map = new HashMap<>();
		
		if ((_player1.getScore() >= 3) && _player2.getScore() >= 3) {
			
			if (Math.abs(_player1.getScore() - _player2.getScore()) == 1) {
				map.put(getPlayerWithWinScore(), TennisGameScore.advantage);
				map.put(getPlayerWithLooseScore(), TennisGameScore.customValueOf(getPlayerWithLooseScore().getScore()));
				return map;
			}
			if (_player1.getScore() == _player2.getScore()) {
				map.put(_player1, TennisGameScore.deuce);
				map.put(_player2, TennisGameScore.deuce);
				return map;
			}
		}
		
		if (_player1.getScore() >= 4 || _player2.getScore() >= 4) {
			if (Math.abs(_player1.getScore() - _player2.getScore()) >= 2) {
				map.put(getPlayerWithWinScore(), TennisGameScore.wingame);
				map.put(getPlayerWithLooseScore(), TennisGameScore.customValueOf(getPlayerWithLooseScore().getScore()));
				return map;
			}
			
		}
		
		map.put(_player1, TennisGameScore.customValueOf(_player1.getScore()));
		map.put(_player2, TennisGameScore.customValueOf(_player2.getScore()));
		return map;
		
	}
	
	public Player getPlayerWithWinScore() {
		return (_player1.getScore() >= _player2.getScore()) ? _player1 : _player2;
		
	}
	
	public Player getPlayerWithLooseScore() {
		return (_player1.getScore() <= _player2.getScore()) ? _player1 : _player2;
		
	}
}
