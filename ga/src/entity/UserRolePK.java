package entity;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: UserRole
 *
 */ 
public class UserRolePK  implements Serializable {   
   
	         
	private String username;         
	private String role;
	private static final long serialVersionUID = 1L;

	public UserRolePK() {}

	

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof UserRolePK)) {
			return false;
		}
		UserRolePK other = (UserRolePK) o;
		return true
			&& (getUsername() == null ? other.getUsername() == null : getUsername().equals(other.getUsername()))
			&& (getRole() == null ? other.getRole() == null : getRole().equals(other.getRole()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getUsername() == null ? 0 : getUsername().hashCode());
		result = prime * result + (getRole() == null ? 0 : getRole().hashCode());
		return result;
	}
   
   
}
