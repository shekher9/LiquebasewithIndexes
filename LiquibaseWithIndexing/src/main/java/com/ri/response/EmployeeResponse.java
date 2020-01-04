package com.ri.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class EmployeeResponse {
	private HttpStatus status;
	private String message;

}
