package com.kueerickpatrick.plantinfo.entity.plantPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public void setLicense(int license){
		this.license = license;
	}

	public int getLicense(){
		return license;
	}

	public void setRegularUrl(String regularUrl){
		this.regularUrl = regularUrl;
	}

	public String getRegularUrl(){
		return regularUrl;
	}

	public void setLicenseName(String licenseName){
		this.licenseName = licenseName;
	}

	public String getLicenseName(){
		return licenseName;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setSmallUrl(String smallUrl){
		this.smallUrl = smallUrl;
	}

	public String getSmallUrl(){
		return smallUrl;
	}

	public void setOriginalUrl(String originalUrl){
		this.originalUrl = originalUrl;
	}

	public String getOriginalUrl(){
		return originalUrl;
	}

	public void setMediumUrl(String mediumUrl){
		this.mediumUrl = mediumUrl;
	}

	public String getMediumUrl(){
		return mediumUrl;
	}

	public void setLicenseUrl(String licenseUrl){
		this.licenseUrl = licenseUrl;
	}

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