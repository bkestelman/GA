package bean;

import java.io.Serializable;

public class StateBean implements Serializable {
	private String abbr;
	private static final long serialVersionUID = 1L;
	
	public StateBean() {
		
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
}
