package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Ingredient;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/ingredienti")
@CrossOrigin("*")
public class IngredientApiController {
	
	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping("/by/pizza/{id}")
	public List<Ingredient> getIngredientByPizzaId(@PathVariable("id") int id){
		Pizza pizza = pizzaServ.findPizzaById(id).get();
		
		return pizza.getIngredients();
	}
	
}
