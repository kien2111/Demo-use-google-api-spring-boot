package com.infamous.Dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.infamous.Model.UserModel;

@Transactional
public interface UserDao extends CrudRepository<UserModel, Long> {

  public UserModel findByEmail(String email);

} 