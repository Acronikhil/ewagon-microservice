package com.ewagon.userservice.entity;

import java.time.Instant;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String gender;
	private Long phone;
	private String email;
	private Long age;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private Instant createdOn = Instant.now();
}
