package com.pavelzzzzz.another_attempt_to_do_something_normal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
public class AnotherAttemptToDoSomethingNormalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotherAttemptToDoSomethingNormalApplication.class, args);
	}
}
