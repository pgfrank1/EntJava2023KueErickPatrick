package com.kueerickpatrick.plantinfo.entity.plantObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hardiness{

	@JsonProperty("min")
	private String min;

	@JsonProperty("max")
	private String max;

	public void setMin(String min){
		this.min = min;
	}

	public String getMin(){
		return min;
	}

	public void setMax(String max){
		this.max = max;
	}

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