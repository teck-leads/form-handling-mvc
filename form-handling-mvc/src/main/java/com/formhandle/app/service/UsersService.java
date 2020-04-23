package com.formhandle.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.formhandle.app.model.Users;
import com.formhandle.app.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository userRepository;

	public Users saveUser(Users user) {
		Users savedUser = userRepository.save(user);
		return savedUser;
	}

	public List<Users> findAllUsers() {
		List<Users> users = userRepository.findAll(Sort.by(Order.asc("id")));
		return users;
	}

	public Users findById(Integer id) {
		Users users = userRepository.findById(id).get();
		return users;
	}

	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

}
