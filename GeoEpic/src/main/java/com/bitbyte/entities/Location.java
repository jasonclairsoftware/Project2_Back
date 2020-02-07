package com.bitbyte.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "LOCATION")
public class Location {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "l_id")
	private int lId; 
	@Column(name = "clue")
	private String clue; 
	@Column(name = "geo_location")
	private String geoLocation;
	
	public Location() {
		super();
	}

	public Location(int lId, String clue, String geoLocation) {
		super();
		this.lId = lId;
		this.clue = clue;
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		return "Location [lId=" + lId + ", clue=" + clue + ", geoLocation=" + geoLocation + "]";
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getClue() {
		return clue;
	}

	public void setClue(String clue) {
		this.clue = clue;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	} 
}
