package com.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;

import com.client.config.GlobalProperties;

@SpringBootApplication
@RefreshScope
public class SpringCloudConfigClientApplication {
	
	@Autowired
	private static ApplicationContext context;    
	private static GlobalProperties globalProperties;

	public static void main(String[] args) {
		context = SpringApplication.run(SpringCloudConfigClientApplication.class, args);
		
		
		
		globalProperties = (GlobalProperties)context.getBean("globalProperties");
		if(null==globalProperties) {
			System.out.println("Properties not loaded!!");
		}else {
			System.out.println("loaded!!");
			System.out.println("message---->"+globalProperties.getMessage());			
		}
	}
	
	public static String getMessage(){				
		return globalProperties.getMessage();
	}

}
