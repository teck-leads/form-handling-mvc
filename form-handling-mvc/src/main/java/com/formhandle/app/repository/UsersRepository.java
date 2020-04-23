package com.formhandle.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formhandle.app.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
