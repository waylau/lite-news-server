package com.waylau.lite.news.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello 控制器.
 * 
 * @since 1.0.0 2019年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/hi")
	public String sayHi() {
	    return "Hello World! Welcome to visit waylau.com!";
	}

}
