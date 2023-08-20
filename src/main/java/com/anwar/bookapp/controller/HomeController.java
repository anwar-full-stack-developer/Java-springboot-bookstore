package com.anwar.bookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")
public class HomeController {

	@GetMapping(path="/")
	public String Home() {
		return "Home Controller / entry point";
	}
}
