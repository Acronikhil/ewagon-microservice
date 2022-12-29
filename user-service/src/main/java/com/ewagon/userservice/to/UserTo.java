package com.ewagon.userservice.to;

import java.time.Instant;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTo {
	
	private String firstName;
	private String lastName;
	private String gender;
	private Long phone;
	private String email;
	private Long age;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	

}
