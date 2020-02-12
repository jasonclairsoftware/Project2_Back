package dev.bitByte.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.bitByte")
@EnableJpaRepositories("dev.bitByte.repositories")
@EntityScan("dev.bitByte.entities")
public class GeoEpicApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoEpicApplication.class, args);
	}

}
