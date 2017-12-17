package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String consistentAdvantagePref;
	private String efficiencyGapPref;
	private String password;

	public User() {
		efficiencyGapPref = "false";
		consistentAdvantagePref = "false";
	}


	@Id
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getConsistentAdvantagePref() {
		return this.consistentAdvantagePref;
	}

	public void setConsistentAdvantagePref(String consistentAdvantagePref) {
		this.consistentAdvantagePref = consistentAdvantagePref;
	}


	public String getEfficiencyGapPref() {
		return this.efficiencyGapPref;
	}

	public void setEfficiencyGapPref(String efficiencyGapPref) {
		this.efficiencyGapPref = efficiencyGapPref;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}