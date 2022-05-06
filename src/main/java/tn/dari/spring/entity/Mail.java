package tn.dari.spring.entity;

import lombok.Data;

@Data

public class Mail {
	private String to;
    private String code;
 
	public Mail(String to) {
		super();
		this.to = to;
	}
	public Mail(String to,String code) {
		super();
		this.to = to;
		this.code=code;
	}
	public Mail() {
		super();
	}
    
    
    
}