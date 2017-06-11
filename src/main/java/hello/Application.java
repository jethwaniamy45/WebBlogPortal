package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class,args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			//repository.save(new Customer("4","Jack", "Bauer","test"));
			//repository.save(new Customer("5","Jack", "Bauer","test"));
			//repository.save(new Customer("6","Jack", "Bauer","test"));
			//repository.save(new Customer("7","Jack", "Bauer","test"));
			repository.save(new Customer("9","Amit", "Jethwani","test"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			//Customer customer = repository.findOne("1");
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			//log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
