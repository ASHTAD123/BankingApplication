package com.banky.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banky.dto.LoginDto;
import com.banky.entities.UserAccount;


@Repository
public interface AccountRepository extends CrudRepository<UserAccount,Integer> {

	UserAccount findByEmailAndPassword(String email, String password); 
}
