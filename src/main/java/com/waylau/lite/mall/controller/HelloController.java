package com.waylau.lite.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.lite.Lite;

/**
 * Hello 控制器.
 * 
 * @since 1.0.0 2018年3月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/mall")
public class HelloController {

	@GetMapping("/hi")
	public String sayHi() {
	    return "Hello World! Welcome to visit waylau.com!";
	}

}
