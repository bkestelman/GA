package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the districts database table.
 * 
 */
@Entity
@Table(name="districts")
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District implements Serializable {
	private static final long serialVersionUID = 1L;
	private DistrictPK id;
	private String state;
	private String stateAbbreviation;
	private String cd115fp;
	private String statefp;
	private int year;
	private String d;
	private String r;

	public District() {
	}


	@EmbeddedId
	public DistrictPK getId() {
		return this.id;
	}

	public void setId(DistrictPK id) {
		this.id = id;
	}

	

	public String getCd115fp() {
		return cd115fp;
	}


	public void setCd115fp(String cd115fp) {
		this.cd115fp = cd115fp;
	}


	public String getStatefp() {
		return statefp;
	}


	public void setStatefp(String statefp) {
		this.statefp = statefp;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getD() {
		return d;
	}


	public void setD(String d) {
		this.d = d;
	}


	public String getR() {
		return r;
	}


	public void setR(String r) {
		this.r = r;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="STATE_ABBREVIATION")
	public String getStateAbbreviation() {
		return this.stateAbbreviation;
	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}

}