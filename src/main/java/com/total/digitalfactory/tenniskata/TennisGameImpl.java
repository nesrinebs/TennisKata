package com.total.digitalfactory.tenniskata;

import java.util.HashMap;
import java.util.Map;

/**
 * Game Class
 * 
 * @since 1.0
 * @author nesrine
 */
public class TennisGameImpl {
	
	private IPlayer _player1;
	private IPlayer _player2;
	
	public TennisGameImpl(IPlayer player1, IPlayer player2) {
		_player1 = player1;
		_player2 = player2;
		// set score 0;
		_player1.initScore();
		_player1.initScore();
		
	}
	
	public IPlayer getPlayer1() {
		return _player1;
	}
	
	public void setPlayer1(IPlayer player1) {
		_player1 = player1;
	}
	
	public IPlayer getPlayer2() {
		return _player2;
	}
	
	public void setPlayer2(IPlayer player2) {
		_player2 = player2;
	}
	
	public Map<IPlayer, TennisGameScoreEnum> getScore() {
		Map<IPlayer, TennisGameScoreEnum> map = new HashMap<>();
		
		if ((_player1.getScore() >= 3) && _player2.getScore() >= 3) {
			
			if (Math.abs(_player1.getScore() - _player2.getScore()) == 1) {
				map.put(getPlayerWithWinScore(), TennisGameScoreEnum.advantage);
				map.put(getPlayerWithLooseScore(), TennisGameScoreEnum.customValueOf(getPlayerWithLooseScore().getScore()));
				return map;
			}
			if (_player1.getScore() == _player2.getScore()) {
				map.put(_player1, TennisGameScoreEnum.deuce);
				map.put(_player2, TennisGameScoreEnum.deuce);
				return map;
			}
		}
		
		if (_player1.getScore() >= 4 || _player2.getScore() >= 4) {
			if (Math.abs(_player1.getScore() - _player2.getScore()) >= 2) {
				map.put(getPlayerWithWinScore(), TennisGameScoreEnum.wingame);
				map.put(getPlayerWithLooseScore(), TennisGameScoreEnum.customValueOf(getPlayerWithLooseScore().getScore()));
				return map;
			}
			
		}
		
		map.put(_player1, TennisGameScoreEnum.customValueOf(_player1.getScore()));
		map.put(_player2, TennisGameScoreEnum.customValueOf(_player2.getScore()));
		return map;
		
	}
	
	public IPlayer getPlayerWithWinScore() {
		return (_player1.getScore() >= _player2.getScore()) ? _player1 : _player2;
		
	}
	
	public IPlayer getPlayerWithLooseScore() {
		return (_player1.getScore() <= _player2.getScore()) ? _player1 : _player2;
		
	}
}
