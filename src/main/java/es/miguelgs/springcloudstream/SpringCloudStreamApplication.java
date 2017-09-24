package es.miguelgs.springcloudstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import es.miguelgs.springcloudstream.bindings.GreetingBindings;

@SpringBootApplication
@EnableBinding(GreetingBindings.class)
public class SpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}
}
