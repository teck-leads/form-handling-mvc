package com.formhandle.app.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formhandle.app.model.Users;
import com.formhandle.app.service.UsersService;

@Controller
public class UserController {
	@Autowired
	private UsersService userService;

	@GetMapping(value = { "/" })
	public String registrationPage(@ModelAttribute("usersCmd") Users usersCmd, Model model) {
		model.addAttribute("idKey", 0);
		return "userRegistration";
	}

	@PostMapping(value = { "/users" })
	public String saveUpdateUser(Model model, @ModelAttribute("usersCmd") Users usersCmd, BindingResult bindingResult) {

		usersCmd = userService.saveUser(usersCmd);
		return "redirect:/users";
	}

	@GetMapping(value = { "/users" })
	public String users(Model model) {
		List<Users> users = userService.findAllUsers();
		model.addAttribute("usersList", users);
		return "users_list";
	}

	@GetMapping(value = { "/users/edit/{id}" })
	public String editUser(Model model, @PathVariable("id") Integer id, @ModelAttribute("usersCmd") Users usersCmd) {
		Users user = userService.findById(id);

		BeanUtils.copyProperties(user, usersCmd);
		model.addAttribute("idKey", usersCmd.getId());
		return "userRegistration";
	}

	@PostMapping(value = { "/users/edit/{id}" })
	public String updateUser(Model model, @ModelAttribute("usersCmd") Users usersCmd) {
		usersCmd = userService.saveUser(usersCmd);
		return "redirect:/users";
	}

	@GetMapping(value = { "/users/delete/{id}" })
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteById(id);
		return "redirect:/users";

	}
}
