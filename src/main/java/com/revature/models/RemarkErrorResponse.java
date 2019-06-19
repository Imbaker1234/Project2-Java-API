package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemarkErrorResponse {

	private int status;
	private String message;
	private long timestamp;
	
}
