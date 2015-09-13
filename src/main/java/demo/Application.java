package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static final String LOGIN_ACCOUNT_SESSION_KEY = "LOGIN_ACCOUNT";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
