package com.example.AsyncAPI.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AsyncAPI.Entity.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Integer>{
	
}
