package com.phoneservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PhoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneServiceApplication.class, args);
	}

	private static final Logger log;

	static {
		log = LoggerFactory.getLogger(PhoneServiceApplication.class);
	}


}
