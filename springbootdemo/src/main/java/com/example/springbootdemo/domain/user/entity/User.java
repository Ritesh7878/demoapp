package com.example.springbootdemo.domain.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	
	 private String username;
	 private String password;
	 private String accountLocked;
	 private String accountExpired;
	 private String accountEnabled;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private LocalDateTime creationDate;
	 
}
