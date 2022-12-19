package org.generation.italy.demo.pojo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	@ManyToMany(mappedBy = "ingredients")
	@JsonIgnore
	private List<Pizza> pizzas;
	
	public Ingredient() { }
	public Ingredient(String name) {
		setName(name);
	}
	public Ingredient(String name, Pizza...pizzas ) {
		this(name);
		setPizzas(Arrays.asList(pizzas));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	@Override
	public String toString() {
		return "Id: " + id + " - Name: " + name;
	}
}
