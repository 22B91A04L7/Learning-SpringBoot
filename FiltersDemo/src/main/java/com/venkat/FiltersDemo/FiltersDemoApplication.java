package com.venkat.FiltersDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiltersDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiltersDemoApplication.class, args);
	}

}

//Filters : allows to handle common http level logic that is handled by every controller
// Fiters are mainly used for:
//	1. Logging
//	2. Authentication and Authorization
//	3. Measuring Response time
//	4. Accessing Headers
//	5. Accessing, Modifying Request/Response