package com.example.ba.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("greeting/customer/{name}")
	public String greetings (@PathVariable final String name) {
		return "Welcome to our organization " + name;
	}
	
	@RequestMapping("greeting/customer/private/{name}")
	public String privateGreetings (@PathVariable final String name) {
		return "Welcome to our organization " + name + ", we have a special discount for you!!";
	}
}
