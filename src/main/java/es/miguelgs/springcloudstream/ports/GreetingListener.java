package es.miguelgs.springcloudstream.ports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import es.miguelgs.springcloudstream.bindings.GreetingBindings;

@Component
public class GreetingListener {

	private static final Logger log = LoggerFactory.getLogger(GreetingListener.class);
	private String instanceName;
	
	public GreetingListener(@Value("${greeting.instanceName}") String instanceName) {
		this.instanceName = instanceName;
	}
	
	@StreamListener(GreetingBindings.INPUT_CHANNEL)
	public void handleGreeting(String greeting){
		log.error("{} : Se recibe el saludo {}", instanceName, greeting);
	}
}
