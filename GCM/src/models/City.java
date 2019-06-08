package models;

import javafx.scene.control.Button;

public class City {
	private int cityID;
	private Map[] maps;
	private String description;
	private double mapClusterVersion;
	private int numberMaps;
	private int numberTours;
	private int numberLocations;
	private double mapClusterPrice;
	private String cityName;
	
	private Button download;
	
	public City(int cityID, Map[] maps,String description, double mapClusterVersion, int numberMaps, int numberTours, int numberLocations ,  double mapClusterPrice, String cityName, Button download) {
		super();
		this.cityID = cityID;
		this.maps = maps;
		this.description = description;
		this.mapClusterVersion = mapClusterVersion;
		this.numberMaps = numberMaps;
		this.numberTours = numberTours;
		this.numberLocations = numberLocations;
		this.mapClusterPrice = mapClusterPrice;
		this.cityName = cityName;
		this.download = download;
	}
	
	public City(int cityID, String description, double mapClusterVersion, int numberMaps, int numberTours, int numberLocations ,  double mapClusterPrice, String cityName, Button download) {
		super();
		this.cityID = cityID;
		this.description = description;
		this.mapClusterVersion = mapClusterVersion;
		this.numberMaps = numberMaps;
		this.numberTours = numberTours;
		this.numberLocations = numberLocations;
		this.mapClusterPrice = mapClusterPrice;
		this.cityName = cityName;
		this.download = download;
	}
	
	

	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public Map[] getMaps() {
		return maps;
	}
	public void setMaps(Map[] maps) {
		this.maps = maps;
	}
	public double getMapClusterVersion() {
		return mapClusterVersion;
	}
	public void setMapClusterVersion(double mapClusterVersion) {
		this.mapClusterVersion = mapClusterVersion;
	}
	public double getMapClusterPrice() {
		return mapClusterPrice;
	}
	public void setMapClusterPrice(double mapClusterPrice) {
		this.mapClusterPrice = mapClusterPrice;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getdescription(){
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
}
