package itssmt.taller.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="itssmt.taller")
public class ApprestalumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprestalumnoApplication.class, args);
	}
}
