package com.mryndina.exhibitions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modeller")
public class IndexController {

	@GetMapping("/")
	public String list() {
		return "modeller";
	}
}
