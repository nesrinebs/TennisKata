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
	public void winball() {
		_score ++;
		// TODO test when score ==3.
	}

	@Override
	public int getScore() {
		return _score;
	}
	
	public String getScoreDescription() {
		return scoreDescription[_score];
		
		
	}
	
}
