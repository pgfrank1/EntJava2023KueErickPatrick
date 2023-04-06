package com.kueerickpatrick.plantinfo.entity.plantPOJO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantDetailList{

	@JsonProperty("per_page")
	private int perPage;

	@JsonProperty("total")
	private int total;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("last_page")
	private int lastPage;

	@JsonProperty("from")
	private int from;

	@JsonProperty("to")
	private int to;

	@JsonProperty("current_page")
	private int currentPage;

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setLastPage(int lastPage){
		this.lastPage = lastPage;
	}

	public int getLastPage(){
		return lastPage;
	}

	public void setFrom(int from){
		this.from = from;
	}

	public int getFrom(){
		return from;
	}

	public void setTo(int to){
		this.to = to;
	}

	public int getTo(){
		return to;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	@Override
 	public String toString(){
		return 
			"PlantDetailList{" + 
			"per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",data = '" + data + '\'' + 
			",last_page = '" + lastPage + '\'' + 
			",from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			",current_page = '" + currentPage + '\'' + 
			"}";
		}
}