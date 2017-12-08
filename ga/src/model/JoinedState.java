package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the joined_states database table.
 * 
 */
@Entity
@Table(name="joined_states")
@NamedQuery(name="JoinedState.findAll", query="SELECT j FROM JoinedState j")
public class JoinedState implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fips;
	private String abbr;
	private float area;
	private String country;
	private String democratic;
	private int democratic_Electoral;
	private BigInteger id;
	private String isLower48;
	private String isState;
	private float latitude;
	private float longitude;
	private String name;
	private BigInteger population;
	private String republican;
	private int republican_Electoral;
	private String slug;

	public JoinedState() {
	}


	@Id
	public String getFips() {
		return this.fips;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}


	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}


	public float getArea() {
		return this.area;
	}

	public void setArea(float area) {
		this.area = area;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Lob
	public String getDemocratic() {
		return this.democratic;
	}

	public void setDemocratic(String democratic) {
		this.democratic = democratic;
	}


	public int getDemocratic_Electoral() {
		return this.democratic_Electoral;
	}

	public void setDemocratic_Electoral(int democratic_Electoral) {
		this.democratic_Electoral = democratic_Electoral;
	}


	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}


	@Column(name="is_lower48")
	public String getIsLower48() {
		return this.isLower48;
	}

	public void setIsLower48(String isLower48) {
		this.isLower48 = isLower48;
	}


	@Column(name="is_state")
	public String getIsState() {
		return this.isState;
	}

	public void setIsState(String isState) {
		this.isState = isState;
	}


	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public BigInteger getPopulation() {
		return this.population;
	}

	public void setPopulation(BigInteger population) {
		this.population = population;
	}


	@Lob
	public String getRepublican() {
		return this.republican;
	}

	public void setRepublican(String republican) {
		this.republican = republican;
	}


	public int getRepublican_Electoral() {
		return this.republican_Electoral;
	}

	public void setRepublican_Electoral(int republican_Electoral) {
		this.republican_Electoral = republican_Electoral;
	}


	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}