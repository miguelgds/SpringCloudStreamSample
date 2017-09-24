package es.miguelgs.springcloudstream.resources;

import java.util.List;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.miguelgs.springcloudstream.bindings.GreetingBindings;
import es.miguelgs.springcloudstream.model.Greeting;
import es.miguelgs.springcloudstream.model.GreetingRepository;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	private GreetingBindings greetingBindings;
	private GreetingRepository greetingRepository;
	
	public GreetingController(GreetingBindings greetingBindings, GreetingRepository greetingRepository) {
		this.greetingBindings = greetingBindings;
		this.greetingRepository = greetingRepository;
	}
	
	@PostMapping
	public void newGreeting(@RequestBody Greeting greeting){
		this.greetingBindings.outputChannel().send(MessageBuilder.withPayload(greeting).build());
	}
	
	@GetMapping
	public List<Greeting> findAllGreetings(){
		return greetingRepository.findAllGreetings();
	}
	
	@GetMapping("/users/{user}")
	public List<Greeting> greetingsByUser(@PathVariable("user") String user){
		return greetingRepository.findGreetingsByUser(user);
	}
}
