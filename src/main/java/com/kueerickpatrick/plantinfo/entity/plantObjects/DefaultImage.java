package com.kueerickpatrick.plantinfo.entity.plantObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Default image array that comes with the plant detail information
 *
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 */
public class DefaultImage{

	@JsonProperty("license")
	private int license;

	@JsonProperty("regular_url")
	private String regularUrl;

	@JsonProperty("license_name")
	private String licenseName;

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("small_url")
	private String smallUrl;

	@JsonProperty("original_url")
	private String originalUrl;

	@JsonProperty("medium_url")
	private String mediumUrl;

	@JsonProperty("license_url")
	private String licenseUrl;

	/**
	 * Set license.
	 *
	 * @param license the license
	 */
	public void setLicense(int license){
		this.license = license;
	}

	/**
	 * Get license int.
	 *
	 * @return the int
	 */
	public int getLicense(){
		return license;
	}

	/**
	 * Set regular url.
	 *
	 * @param regularUrl the regular url
	 */
	public void setRegularUrl(String regularUrl){
		this.regularUrl = regularUrl;
	}

	/**
	 * Get regular url string.
	 *
	 * @return the string
	 */
	public String getRegularUrl(){
		return regularUrl;
	}

	/**
	 * Set license name.
	 *
	 * @param licenseName the license name
	 */
	public void setLicenseName(String licenseName){
		this.licenseName = licenseName;
	}

	/**
	 * Get license name string.
	 *
	 * @return the string
	 */
	public String getLicenseName(){
		return licenseName;
	}

	/**
	 * Set thumbnail.
	 *
	 * @param thumbnail the thumbnail
	 */
	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	/**
	 * Get thumbnail string.
	 *
	 * @return the string
	 */
	public String getThumbnail(){
		return thumbnail;
	}

	/**
	 * Set small url.
	 *
	 * @param smallUrl the small url
	 */
	public void setSmallUrl(String smallUrl){
		this.smallUrl = smallUrl;
	}

	/**
	 * Get small url string.
	 *
	 * @return the string
	 */
	public String getSmallUrl(){
		return smallUrl;
	}

	/**
	 * Set original url.
	 *
	 * @param originalUrl the original url
	 */
	public void setOriginalUrl(String originalUrl){
		this.originalUrl = originalUrl;
	}

	/**
	 * Get original url string.
	 *
	 * @return the string
	 */
	public String getOriginalUrl(){
		return originalUrl;
	}

	/**
	 * Set medium url.
	 *
	 * @param mediumUrl the medium url
	 */
	public void setMediumUrl(String mediumUrl){
		this.mediumUrl = mediumUrl;
	}

	/**
	 * Get medium url string.
	 *
	 * @return the string
	 */
	public String getMediumUrl(){
		return mediumUrl;
	}

	/**
	 * Set license url.
	 *
	 * @param licenseUrl the license url
	 */
	public void setLicenseUrl(String licenseUrl){
		this.licenseUrl = licenseUrl;
	}

	/**
	 * Get license url string.
	 *
	 * @return the string
	 */
	public String getLicenseUrl(){
		return licenseUrl;
	}

	@Override
 	public String toString(){
		return 
			"DefaultImage{" + 
			"license = '" + license + '\'' + 
			",regular_url = '" + regularUrl + '\'' + 
			",license_name = '" + licenseName + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",small_url = '" + smallUrl + '\'' + 
			",original_url = '" + originalUrl + '\'' + 
			",medium_url = '" + mediumUrl + '\'' + 
			",license_url = '" + licenseUrl + '\'' + 
			"}";
		}
}