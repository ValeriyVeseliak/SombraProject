package service.impl;

import java.util.ArrayList;
import java.util.Collection;

import model.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		model.User userEntity = userDao.getUserByLogin(login);

		if (userEntity == null)
			throw new UsernameNotFoundException("Error in email, or password");

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 UserRole role =  userEntity.getRole();
		 
		 authorities.add(new SimpleGrantedAuthority(role.name()));
		 
		return new org.springframework.security.core.userdetails.User(userEntity.getLogin(),
				userEntity.getPassword(), authorities);
	}

}
