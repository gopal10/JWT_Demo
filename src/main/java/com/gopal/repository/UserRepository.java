package com.gopal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gopal.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{'username': {$in: [?0]}, 'password': {$in:[?1]}}")
	public User validateUser(String Username, String Password);
}
