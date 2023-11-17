package org.pallas.alaprest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlaprestApplication {

	public static void main(String[] args) {

		var ctx= SpringApplication.run(AlaprestApplication.class, args);
		ctx.getBeanDefinitionNames();
	}

}
