package com.raviteja.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raviteja.demo.model.Product;

@RestController
public class ProductServiceController {

	private static Map<String, Product> prodRepo = new HashMap<>();
	
	static {
		Product p1 = new Product();
		p1.setId("1");
		p1.setName("Honey");
		prodRepo.put(p1.getId(),p1);
		
		Product p2 = new Product();
		p2.setId("2");
		p2.setName("Almond");
		prodRepo.put(p2.getId(),p2);
	}
	
	@GetMapping(value="/products")
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(prodRepo.values(), HttpStatus.OK);
	}

}
