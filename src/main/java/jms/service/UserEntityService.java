package jms.service;

import java.util.List;

import jms.entity.UserEntity;

public interface UserEntityService {

	void saveUserEntity(UserEntity userEntity);
	 
	UserEntity findUserById(Long id);
	
	List<UserEntity> findAllUsers();
	
	UserEntity findUserByEmailUnique(String email);
	
	UserEntity findUserByEmail(String email);

	UserEntity findUserByIntId(int userId);

	void updateUser(UserEntity user);


}
