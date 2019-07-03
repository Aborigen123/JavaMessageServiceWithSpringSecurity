package jms.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jms.entity.UserEntity;



@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findUserByEmailUnique(@Param ("email") String email);
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findUserByEmail(@Param ("email") String email);
}
