package decorator;

import w17d1esercizio.entities.Pizza;

public class SalsicciaDecorator extends Pizza {
	public SalsicciaDecorator(Pizza pizza) {
		super(pizza.getName() + " + salsiccia", pizza.getPrice() + 1.5, pizza.getCalorie() + 40);
	}
}
