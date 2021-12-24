package com.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entities.User;
import com.rest.enums.Badge;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("from User u where u.firstName=:firstname")
	List<User> getByFnm(@Param("firstname") String firstName);

	@Query("from User u where u.lastName=:lastName")
	List<User> getByLastName(@Param("lastName") String lastName);

	@Query("from User u where u.emailId=:mailId")
	List<User> getByEmailId(@Param("mailId") String emailId);
	
	
}
