package com.total.digitalfactory.tenniskata;

public enum TennisGameScoreEnum {
	love("0"),
	fiftheen("1"),
	thirty("2"),
	forty("3"),
	init("init"),
	deuce("deuce"),
	wingame("wingame"),
	advantage("advantage");
	
	Object score;
	
	private TennisGameScoreEnum(String score) {
		this.score = score;
	}
	
	public static TennisGameScoreEnum customValueOf(Object value) {
		for (TennisGameScoreEnum v : values())
			if (String.valueOf(v.score).equalsIgnoreCase(String.valueOf(value))) return v;
		throw new IllegalArgumentException();
	}
}
