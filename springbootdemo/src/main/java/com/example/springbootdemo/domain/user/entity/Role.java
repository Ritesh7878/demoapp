package com.example.springbootdemo.domain.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users_roles")
public class Role {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="role_id")
	 private Long roleId; 
	 
	 private String name;
	 
	 private String description;
}
