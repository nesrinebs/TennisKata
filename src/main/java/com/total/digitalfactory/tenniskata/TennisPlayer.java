package com.total.digitalfactory.tenniskata;

/**
 * Tennis Player Class.
 * 
 * @since 1.0
 * @author nesrine
 */
public class TennisPlayer
implements
Player {
	
	private static String[] scoreDescription = {
		TennisGameScore.love.name(),
		TennisGameScore.fiftheen.name(),
		TennisGameScore.thirty.name(),
		TennisGameScore.forty.name(),
		TennisGameScore.advantage.name(),
		TennisGameScore.wingame.name()
	};
	
	private String _name;
	private int _score;
	
	public TennisPlayer(String name) {
		super();
		_name = name;
		_score = 0;
	}
	
	@Override
	public String getName() {
		return _name;
	}
	
	@Override
	public void winBall() {
		
		_score++;
		
		// TODO test when score ==3.
		
	}
	
	@Override
	public int getScore() {
		return _score;
	}
	
	public String getScoreDescription() {
		if (_score <= 4) return scoreDescription[_score];
		else return "";
		
	}
	
	@Override
	public void initScore() {
		_score = 0;
	}
	
}
