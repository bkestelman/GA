package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getUser_name() {
		return this.username;
	}

	public void setUser_name(String username) {
		this.username = username;
	}   
	public String getUser_pass() {
		return this.password;
	}

	public void setUser_pass(String userpass) {
		this.password = userpass;
	}
   
}
