package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaWepapiApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaServ pizzaServe;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaWepapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Marghe", "bona");
		Pizza p2 = new Pizza("Spontini", "NON bona");
		
		pizzaServe.save(p1);
		pizzaServe.save(p2);
	}

}
