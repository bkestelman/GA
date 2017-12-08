package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: State
 *
 */
@Entity

public class State implements Serializable {

	
	private long id;
	private String abbr;
	private String name;
	private float latitude;
	private float longitude;
	private long population;
	private float area;
	private static final long serialVersionUID = 1L;

	public State() {
		super();
	}   
	@Id    
	@GeneratedValue
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}   
	public String getAbbr() {
		return this.abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
   
}
