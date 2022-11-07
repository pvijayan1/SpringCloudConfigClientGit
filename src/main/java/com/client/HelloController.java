package com.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class HelloController {
	
	@Autowired
	private Environment env;
	
	@Value("${welcome.message}")
    private String message2;
		
	@GetMapping("/msg")
	public String getWelcomeMessage() {
		
		String ms = SpringCloudConfigClientApplication.getMessage();
		
		System.out.println("message2 frm controller--->"+message2);
		return ms;		
		
		//return env.getProperty("welcome.message");
	}

}
