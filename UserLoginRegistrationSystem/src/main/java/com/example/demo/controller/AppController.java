package com.example.demo.controller;

import java.util.List;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

import jdk.javadoc.doclet.Reporter;



@Controller
public class AppController {
	
	@Autowired
	private  UserRepository userRepository;
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String viewSignupForm(Model model) {
		model.addAttribute("user", new User());
		return "signUpForm";
		
	}
	
	@PostMapping("/saveuser")
	public String saveUser(User user) {
		
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
		return "registerSuccess";
		
		
	}
	
	@GetMapping("/list_user")
	public String viewUserList(Model model) {
		List<User> listUsers=userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
		
	}
	

}
