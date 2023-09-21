package withus.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@Configuration
public class WithusBackendApplication {
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(WithusBackendApplication.class, args);
	}

}
