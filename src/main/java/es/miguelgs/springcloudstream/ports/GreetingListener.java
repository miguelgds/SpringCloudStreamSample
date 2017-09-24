package es.miguelgs.springcloudstream.ports;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import es.miguelgs.springcloudstream.bindings.GreetingBindings;
import es.miguelgs.springcloudstream.model.Greeting;
import es.miguelgs.springcloudstream.model.GreetingRepository;

@Component
public class GreetingListener {

	private GreetingRepository greetingRepository;
	
	public GreetingListener(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}
	
	@StreamListener(GreetingBindings.INPUT_CHANNEL)
	public void handleGreeting(@Payload Greeting greeting){
		this.greetingRepository.save(greeting);
	}
}
