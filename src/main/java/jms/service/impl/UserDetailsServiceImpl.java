package jms.service.impl;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jms.entity.UserEntity;
import jms.mapper.UserMapper;
import jms.repostory.UserEntityRepository;



@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired private UserEntityRepository userEntityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity customer = userEntityRepository.findUserByEmail(email);
		if(customer.isActivated()== false) throw new UsernameNotFoundException("We send mail with confirm on your mail"+ customer.getEmail());
		if(customer == null) throw new UsernameNotFoundException("User not found");
		
		return UserMapper.toSecurityUser(customer);
	}

}
