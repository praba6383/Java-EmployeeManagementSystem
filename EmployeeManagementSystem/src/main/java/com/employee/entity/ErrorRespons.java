package com.employee.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorRespons {
	
	private LocalDateTime date;
	private String message;
	private String detailes;
	public ErrorRespons(LocalDateTime date, String message, String detailes){
		super();
		this.date = date;
		this.message = message;
		this.detailes = detailes;
	}
	
	
	

}
