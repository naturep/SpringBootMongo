package smongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		repository.save(new User("Leb", "James"));
		repository.save(new User("Stephen", "Curry"));
		repository.save(new User("Seth", "Curry"));


		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		System.out.println("User found with findByFirstName('Leb'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Leb"));

		System.out.println("Users found with findByLastName('Curry'):");
		System.out.println("--------------------------------");
		for (User user : repository.findByLastName("Curry")) {
			System.out.println(user);
		}

	}

}