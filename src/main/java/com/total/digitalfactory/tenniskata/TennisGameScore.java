package com.total.digitalfactory.tenniskata;

public enum TennisGameScore {
	love("0"),
	fiftheen("1"),
	thirty("2"),
	forty("3"),
	init("init"),
	deuce("deuce"),
	wingame("wingame"),
	advantage("advantage");
	
	Object score;
	
	private TennisGameScore(String score) {
		this.score = score;
	}
	
	public static TennisGameScore customValueOf(Object value) {
		for (TennisGameScore v : values())
			if (String.valueOf(v.score).equalsIgnoreCase(String.valueOf(value))) return v;
		throw new IllegalArgumentException();
	}
}
