/**
 * 
 */
package com.states.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Martin M. Morales
 * 
 *         State - the State class.
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class State{
	

	@JsonProperty("id")
	private int id;
	@JsonProperty("country")
	private String country;
	@JsonProperty("name")
	private String name;
	@JsonProperty("abbr")
	private String abbr;
	@JsonProperty("area")
	private String area;
	@JsonProperty("largest_city")
	private String largest_City;
	@JsonProperty("capital")
	private String captial;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLargest_City() {
		return largest_City;
	}

	public void setLargestCity(String largest_City) {
		this.largest_City = largest_City;
	}

	public String getCaptial() {
		return captial;
	}

	public void setCaptial(String captial) {
		this.captial = captial;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", country=" + country + ", name=" + name + ", abbr=" + abbr + ", area=" + area
				+ ", largestCity=" + largest_City + ", captial=" + captial + "]";
	}

}
