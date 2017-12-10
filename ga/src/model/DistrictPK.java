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
	private String statefp;
	private int year;
	private String generalVotes;
	private String party;
	private String cd115fp;

	public DistrictPK() {
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

	@Column(name="GENERAL_VOTES")
	public String getGeneralVotes() {
		return this.generalVotes;
	}
	public void setGeneralVotes(String generalVotes) {
		this.generalVotes = generalVotes;
	}

	public String getParty() {
		return this.party;
	}
	public void setParty(String party) {
		this.party = party;
	}

	public String getCd115fp() {
		return this.cd115fp;
	}
	public void setCd115fp(String cd115fp) {
		this.cd115fp = cd115fp;
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
			this.statefp.equals(castOther.statefp)
			&& (this.year == castOther.year)
			&& this.generalVotes.equals(castOther.generalVotes)
			&& this.party.equals(castOther.party)
			&& this.cd115fp.equals(castOther.cd115fp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.statefp.hashCode();
		hash = hash * prime + this.year;
		hash = hash * prime + this.generalVotes.hashCode();
		hash = hash * prime + this.party.hashCode();
		hash = hash * prime + this.cd115fp.hashCode();
		
		return hash;
	}
}