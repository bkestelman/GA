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
   
}
