package jms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jms.entity.UserEntity;
import jms.repostory.UserEntityRepository;
import jms.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserEntityServiceImpl implements UserEntityService{

	@Autowired  private UserEntityRepository userEntityRepository; 
	@Autowired private PasswordEncoder passwordEncoder;

	
	
	@Override
	public void saveUserEntity(UserEntity userEntity) {
		String methodName = "saveUser";
	    log.debug("Start" + methodName);
	    String password = userEntity.getPassword();
	    log.debug("Entered password" + password);
	    userEntity.setPassword(passwordEncoder.encode(password));
		log.debug("Encoded password" + userEntity.getPassword() );	
		userEntityRepository.save(userEntity);
			log.debug("End" + methodName);

		
	}
	@Override
	public UserEntity findUserById(Long id) {
		
		return userEntityRepository.findOne(id);
	}
	@Override
	public List<UserEntity> findAllUsers() {
		return userEntityRepository.findAll();
	}
	@Override
	public UserEntity findUserByEmailUnique(String email) {
		
		return userEntityRepository.findUserByEmailUnique(email);
	}
	@Override
	public UserEntity findUserByEmail(String email) {
		return userEntityRepository.findUserByEmail(email);
	}
	@Override
	public UserEntity findUserByIntId(int userId) {
	
		return userEntityRepository.findOne((long) userId);
	}
	@Override
	public void updateUser(UserEntity user) {
		userEntityRepository.save(user);
		
	}
}
