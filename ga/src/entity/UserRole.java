package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserRole
 *
 */
@Entity

@IdClass(UserRolePK.class)
public class UserRole implements Serializable {

	   
	@Id
	private String username;   
	@Id
	private String role;
	private static final long serialVersionUID = 1L;

	public UserRole() {
		super();
	}   
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
   
}
