/* 
 * Author ::. Sivateja Kandula | www.java4s.com 
 *
 */

package com.java4s.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringJava4sController {
	
	@RequestMapping("/login")
	public String userValidation() 
	{
		return "User: Successfully logged in!";
	}	
}

// URL: http://localhost:8080/springbootauth/login