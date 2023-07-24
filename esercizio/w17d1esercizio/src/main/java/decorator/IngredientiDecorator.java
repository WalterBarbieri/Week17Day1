package decorator;

import w17d1esercizio.entities.Pizza;

public abstract class IngredientiDecorator {
	protected Pizza pizza;

	public IngredientiDecorator(Pizza pizza) {

		this.pizza = pizza;
	}

	public String getName() {
		return pizza.getName();
	}

	public double getPrice() {
		return pizza.getPrice();
	}

	public double getCalorie() {
		return pizza.getCalorie();
	}

}
