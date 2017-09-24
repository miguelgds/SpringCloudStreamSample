package es.miguelgs.springcloudstream.resources;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.miguelgs.springcloudstream.bindings.GreetingBindings;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	private GreetingBindings greetingBindings;
	
	public GreetingController(GreetingBindings greetingBindings) {
		this.greetingBindings = greetingBindings;
	}
	
	@PostMapping
	public void greeting(@RequestParam("greeting") String greeting){
		this.greetingBindings.outputChannel().send(MessageBuilder.withPayload(greeting).build());
	}
}
