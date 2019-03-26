package com.example.springcloud_1_eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("clientGetMyName")
	public String clientGetMyName() {
		return restTemplate.getForObject("http://lhm-spring-cloud-consumer2/user/getMyName",String.class);
	}
}
