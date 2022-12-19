package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/1/pizzeria")
@CrossOrigin("*")
public class PizzeriaApiController {
	
	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping
	public List<Pizza> getAll(){
		List<Pizza> pizzas = pizzaServ.all();
		
		return pizzas;
	}
	
	@PostMapping("/update/{id}")
	public Pizza updatePizza(@PathVariable("id") int id, @Valid @RequestBody Pizza pizza) {
		Pizza oldPizza = pizzaServ.findPizzaById(id).get();
		pizza.setIngredients(oldPizza.getIngredients());
		pizza.setPromotion(oldPizza.getPromotion());
		
		pizzaServ.save(pizza);
		
		return pizzaServ.findPizzaById(id).get();
	}
	
	@GetMapping("/delete/{id}")
	public boolean deletePizza(@PathVariable("id") int id) {
		try {
			pizzaServ.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	@PostMapping("/create")
	public boolean createPizza(@Valid @RequestBody Pizza pizza) {
		try {
			pizzaServ.save(pizza);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
