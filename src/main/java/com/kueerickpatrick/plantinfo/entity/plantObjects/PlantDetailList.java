package com.kueerickpatrick.plantinfo.entity.plantObjects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The full Plant detail list that is recieved from the Perenual API. It generally has 30 DataItems per page
 *
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 *
 */
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

	/**
	 * Set per page.
	 *
	 * @param perPage the per page
	 */
	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	/**
	 * Get per page int.
	 *
	 * @return the int
	 */
	public int getPerPage(){
		return perPage;
	}

	/**
	 * Set total.
	 *
	 * @param total the total
	 */
	public void setTotal(int total){
		this.total = total;
	}

	/**
	 * Get total int.
	 *
	 * @return the int
	 */
	public int getTotal(){
		return total;
	}

	/**
	 * Set data.
	 *
	 * @param data the data
	 */
	public void setData(List<DataItem> data){
		this.data = data;
	}

	/**
	 * Get data list.
	 *
	 * @return the list
	 */
	public List<DataItem> getData(){
		return data;
	}

	/**
	 * Set last page.
	 *
	 * @param lastPage the last page
	 */
	public void setLastPage(int lastPage){
		this.lastPage = lastPage;
	}

	/**
	 * Get last page int.
	 *
	 * @return the int
	 */
	public int getLastPage(){
		return lastPage;
	}

	/**
	 * Set from.
	 *
	 * @param from the from
	 */
	public void setFrom(int from){
		this.from = from;
	}

	/**
	 * Get from int.
	 *
	 * @return the int
	 */
	public int getFrom(){
		return from;
	}

	/**
	 * Set to.
	 *
	 * @param to the to
	 */
	public void setTo(int to){
		this.to = to;
	}

	/**
	 * Get to int.
	 *
	 * @return the int
	 */
	public int getTo(){
		return to;
	}

	/**
	 * Set current page.
	 *
	 * @param currentPage the current page
	 */
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	/**
	 * Get current page int.
	 *
	 * @return the int
	 */
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