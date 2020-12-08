package com.total.digitalfactory.tenniskata;

/**
 * Tennis Player Class.
 * 
 * @since 1.0
 * @author nesrine
 */
public class TennisPlayerImpl
implements
IPlayer {
	
	private static String[] scoreDescription = {
		TennisGameScoreEnum.love.name(),
		TennisGameScoreEnum.fiftheen.name(),
		TennisGameScoreEnum.thirty.name(),
		TennisGameScoreEnum.forty.name(),
		TennisGameScoreEnum.advantage.name(),
		TennisGameScoreEnum.wingame.name()
	};
	
	private String _name;
	private int _score;
	
	public TennisPlayerImpl(String name) {
	
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
