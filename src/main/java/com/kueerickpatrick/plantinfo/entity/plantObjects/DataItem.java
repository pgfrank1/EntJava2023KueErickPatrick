package com.kueerickpatrick.plantinfo.entity.plantObjects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Data item that is recieved from the plant details list.
 *
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 *
 */
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

	/**
	 * Set sunlight.
	 *
	 * @param sunlight the sunlight
	 */
	public void setSunlight(List<String> sunlight){
		this.sunlight = sunlight;
	}

	/**
	 * Get sunlight list.
	 *
	 * @return the list
	 */
	public List<String> getSunlight(){
		return sunlight;
	}

	/**
	 * Set watering.
	 *
	 * @param watering the watering
	 */
	public void setWatering(String watering){
		this.watering = watering;
	}

	/**
	 * Get watering string.
	 *
	 * @return the string
	 */
	public String getWatering(){
		return watering;
	}

	/**
	 * Set scientific name.
	 *
	 * @param scientificName the scientific name
	 */
	public void setScientificName(List<String> scientificName){
		this.scientificName = scientificName;
	}

	/**
	 * Get scientific name list.
	 *
	 * @return the list
	 */
	public List<String> getScientificName(){
		return scientificName;
	}

	/**
	 * Set other name.
	 *
	 * @param otherName the other name
	 */
	public void setOtherName(List<String> otherName){
		this.otherName = otherName;
	}

	/**
	 * Get other name list.
	 *
	 * @return the list
	 */
	public List<String> getOtherName(){
		return otherName;
	}

	/**
	 * Set default image.
	 *
	 * @param defaultImage the default image
	 */
	public void setDefaultImage(DefaultImage defaultImage){
		this.defaultImage = defaultImage;
	}

	/**
	 * Get default image default image.
	 *
	 * @return the default image
	 */
	public DefaultImage getDefaultImage(){
		return defaultImage;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Get id int.
	 *
	 * @return the int
	 */
	public int getId(){
		return id;
	}

	/**
	 * Set common name.
	 *
	 * @param commonName the common name
	 */
	public void setCommonName(String commonName){
		this.commonName = commonName;
	}

	/**
	 * Get common name string.
	 *
	 * @return the string
	 */
	public String getCommonName(){
		return commonName;
	}

	/**
	 * Set cycle.
	 *
	 * @param cycle the cycle
	 */
	public void setCycle(String cycle){
		this.cycle = cycle;
	}

	/**
	 * Get cycle string.
	 *
	 * @return the string
	 */
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