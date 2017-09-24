package es.miguelgs.springcloudstream.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepository {

	private List<Greeting> greetingsByUser = new ArrayList<Greeting>();
	
	public List<Greeting> findAllGreetings(){
		return greetingsByUser.stream()
							  .sorted(Comparator.comparing(Greeting::getUser))
							  .collect(Collectors.toList());
	}
	
	public List<Greeting> findGreetingsByUser(String user){
		return this.greetingsByUser
				   .stream()
				   .filter(g -> g.getUser().equals(user))
				   .collect(Collectors.toList());
	}

	public void save(Greeting greeting) {
		greetingsByUser.add(greeting);
	}
}
