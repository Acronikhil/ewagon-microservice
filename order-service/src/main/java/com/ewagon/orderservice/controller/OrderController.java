package com.ewagon.orderservice.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/")
	public String  helloOrders() {
		return "Hello form orders";
	}
	
}
