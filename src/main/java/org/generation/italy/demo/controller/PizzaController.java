package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping
	public String index(Model model) {
		List<Pizza> pizzas = pizzaServ.all();
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("size", pizzas.size());
		
		return "Main";
	}
}
