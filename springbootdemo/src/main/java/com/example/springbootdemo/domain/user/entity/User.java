package com.example.springbootdemo.domain.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import com.example.springbootdemo.domain.user.dto.UserDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {
	

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	
	 private String username;
	 private String password;
	 private String accountLocked;
	 private String accountExpired;
	 private String accountEnabled;
	 
	 @Email
	 @Column(name="email")
	 private String email;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date creationDate;
	 
	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name="id")
	 private UserInfo userInfo;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinTable( name = "user_roles_mapping",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
	 private List<Role> userRoles;
	 
	 
	 
}
