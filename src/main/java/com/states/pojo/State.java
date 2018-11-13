/**
 * 
 */
package com.states.pojo;

/**
 * @author Martin M. Morales
 * 
 * State - the State class.
 *
 */
public class State {
	
	private int id;
	private String country;
	private String name;
	private String abbr;
	private String area;
	private String largestCity;
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
	public String getLargestCity() {
		return largestCity;
	}
	public void setLargestCity(String largestCity) {
		this.largestCity = largestCity;
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
				+ ", largestCity=" + largestCity + ", captial=" + captial + "]";
	}
	
	
	

}
