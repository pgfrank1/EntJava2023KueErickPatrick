package com.kueerickpatrick.plantinfo.entity.plantObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Hardiness.
 *
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 */
public class Hardiness{

	@JsonProperty("min")
	private String min;

	@JsonProperty("max")
	private String max;

	/**
	 * Set min.
	 *
	 * @param min the min
	 */
	public void setMin(String min){
		this.min = min;
	}

	/**
	 * Get min string.
	 *
	 * @return the string
	 */
	public String getMin(){
		return min;
	}

	/**
	 * Set max.
	 *
	 * @param max the max
	 */
	public void setMax(String max){
		this.max = max;
	}

	/**
	 * Get max string.
	 *
	 * @return the string
	 */
	public String getMax(){
		return max;
	}

	@Override
 	public String toString(){
		return 
			"Hardiness{" + 
			"min = '" + min + '\'' + 
			",max = '" + max + '\'' + 
			"}";
		}
}