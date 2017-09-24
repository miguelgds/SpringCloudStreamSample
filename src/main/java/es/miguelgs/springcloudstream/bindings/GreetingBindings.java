package es.miguelgs.springcloudstream.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingBindings {

	public static final String INPUT_CHANNEL = "greeting_input_channel";
	public static final String OUTPUT_CHANNEL = "greeting_output_channel";
	
	@Output(OUTPUT_CHANNEL)
	MessageChannel outputChannel();
	
	@Input(INPUT_CHANNEL)
	SubscribableChannel inputChannel();
}
