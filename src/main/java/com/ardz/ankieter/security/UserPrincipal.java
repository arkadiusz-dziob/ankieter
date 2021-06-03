package com.ardz.ankieter.security;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ardz.ankieter.model.Osoba;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final Osoba osoba;

	public UserPrincipal(Osoba osoba) {
		this.osoba = osoba;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new LinkedList<>();
		auths.add(new SimpleGrantedAuthority(osoba.getRola()));
		return auths;
	}

	@Override
	public String getPassword() {
		return osoba.getHaslo();
	}

	@Override
	public String getUsername() {
		return osoba.getNazwa();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
