package com.example.springbootdemo.domain.user.auth;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springbootdemo.domain.user.entity.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor
public class AuthUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String accountExpired;
	private String accountLocked;
	private String accountEnabled;
	AuthUser(User user){
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.accountEnabled = user.getAccountEnabled();
		this.accountExpired = user.getAccountExpired();
		this.accountLocked = user.getAccountLocked();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return "N".equalsIgnoreCase(accountExpired);
	}

	@Override
	public boolean isAccountNonLocked() {
		return "N".equalsIgnoreCase(accountLocked);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return "N".equalsIgnoreCase(accountEnabled);
	}

}