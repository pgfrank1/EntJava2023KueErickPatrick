package com.kueerickpatrick.plantinfo.entity.plantObjects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("sunlight")
	private List<String> sunlight;

	@JsonProperty("watering")
	private String watering;

	@JsonProperty("scientific_name")
	private List<String> scientificName;

	@JsonProperty("other_name")
	private List<String> otherName;

	@JsonProperty("default_image")
	private DefaultImage defaultImage;

	@JsonProperty("id")
	private int id;

	@JsonProperty("common_name")
	private String commonName;

	@JsonProperty("cycle")
	private String cycle;

	public void setSunlight(List<String> sunlight){
		this.sunlight = sunlight;
	}

	public List<String> getSunlight(){
		return sunlight;
	}

	public void setWatering(String watering){
		this.watering = watering;
	}

	public String getWatering(){
		return watering;
	}

	public void setScientificName(List<String> scientificName){
		this.scientificName = scientificName;
	}

	public List<String> getScientificName(){
		return scientificName;
	}

	public void setOtherName(List<String> otherName){
		this.otherName = otherName;
	}

	public List<String> getOtherName(){
		return otherName;
	}

	public void setDefaultImage(DefaultImage defaultImage){
		this.defaultImage = defaultImage;
	}

	public DefaultImage getDefaultImage(){
		return defaultImage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCommonName(String commonName){
		this.commonName = commonName;
	}

	public String getCommonName(){
		return commonName;
	}

	public void setCycle(String cycle){
		this.cycle = cycle;
	}

	public String getCycle(){
		return cycle;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"sunlight = '" + sunlight + '\'' + 
			",watering = '" + watering + '\'' + 
			",scientific_name = '" + scientificName + '\'' + 
			",other_name = '" + otherName + '\'' + 
			",default_image = '" + defaultImage + '\'' + 
			",id = '" + id + '\'' + 
			",common_name = '" + commonName + '\'' + 
			",cycle = '" + cycle + '\'' + 
			"}";
		}
}