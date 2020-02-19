package com.example.springbootdemo.domain.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users_details")
public class UserInfo {
	
	@Column(name="detail_id")
	private Long detailId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nick_name")
	private String nickName;
	
	@Email
	@Column(name="email")
	private String email;
	
	@Column(name="profile_image")
	private String profileImage;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private LocalDate birthDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private LocalDateTime creationDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="effective_from")
	private LocalDate effectiveFrom;
	
	@Temporal(TemporalType.DATE)
	@Column(name="effective_to")
	private LocalDate effectiveTo;
}
