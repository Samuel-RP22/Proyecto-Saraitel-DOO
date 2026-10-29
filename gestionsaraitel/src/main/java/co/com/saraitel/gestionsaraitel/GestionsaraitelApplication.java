package co.com.saraitel.gestionsaraitel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionsaraitelApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionsaraitelApplication.class, args);
	}

}