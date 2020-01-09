package sk.tsystems.jobs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class TsystemsServer {
		public static void main(String[] args) {
	        SpringApplication.run(TsystemsServer.class, args);
	    }	
}
