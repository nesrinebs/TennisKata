package com.total.digitalfactory.tenniskata;

/**
 * Interface Player Specification
 * 
 * @since 1.0 
 * @author nesrine
 */
public interface Player {
	
	public String getName();
	
	public void winBall();
	
	public int getScore();

	/**
	 * init score with 0.
	 * 
	 * @since 1.0
	 */
	public void initScore();
	
}
