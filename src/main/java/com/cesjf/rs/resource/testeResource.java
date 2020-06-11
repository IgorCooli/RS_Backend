package com.cesjf.rs.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class testeResource {
	
	@GetMapping("/teste")
	public ResponseEntity<?> teste(){
		return ResponseEntity.status(HttpStatus.OK).body("TESTANDO!!!!");
	}

}
