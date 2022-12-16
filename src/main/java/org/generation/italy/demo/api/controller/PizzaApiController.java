package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/pizza")
public class PizzaApiController {
	
	@Autowired
	PizzaServ pizzaServ;
	
	@GetMapping
	public List<Pizza> all(){
		List<Pizza> pizzas = pizzaServ.all();
		
		return pizzas;
	}
}
