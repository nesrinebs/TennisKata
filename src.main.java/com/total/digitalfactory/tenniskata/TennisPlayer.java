package com.total.digitalfactory.tenniskata;

/**
 * Tennis Player Class.
 * 
 * @since 1.0
 * @author nesrine
 */
public class TennisPlayer implements Player{
	
	private static String[] scoreDescription = {"love","fifteen", "thirty", "forty"};

	private String _name;
	private int _score;
	

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void winball() {
		_score ++;
	}

	@Override
	public int getScore() {
		return _score;
	}
	
	public String getScoreDescription() {
		return scoreDescription[_score];
		
		
	}
	
}
