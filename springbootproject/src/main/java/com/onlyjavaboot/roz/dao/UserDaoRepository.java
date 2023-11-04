package com.onlyjavaboot.roz.dao;

import com.onlyjavaboot.roz.intities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDaoRepository extends JpaRepository<User, Integer> {

}
