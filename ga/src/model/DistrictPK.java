package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the districts database table.
 * 
 */
@Embeddable
public class DistrictPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String cd115fp;
	private String statefp;
	private int year;
	private String d;
	private String r;

	public DistrictPK() {
	}

	public String getCd115fp() {
		return this.cd115fp;
	}
	public void setCd115fp(String cd115fp) {
		this.cd115fp = cd115fp;
	}

	public String getStatefp() {
		return this.statefp;
	}
	public void setStatefp(String statefp) {
		this.statefp = statefp;
	}

	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public String getD() {
		return this.d;
	}
	public void setD(String d) {
		this.d = d;
	}

	public String getR() {
		return this.r;
	}
	public void setR(String r) {
		this.r = r;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DistrictPK)) {
			return false;
		}
		DistrictPK castOther = (DistrictPK)other;
		return 
			this.cd115fp.equals(castOther.cd115fp)
			&& this.statefp.equals(castOther.statefp)
			&& (this.year == castOther.year)
			&& this.d.equals(castOther.d)
			&& this.r.equals(castOther.r);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cd115fp.hashCode();
		hash = hash * prime + this.statefp.hashCode();
		hash = hash * prime + this.year;
		hash = hash * prime + this.d.hashCode();
		hash = hash * prime + this.r.hashCode();
		
		return hash;
	}
}