package w17d1esercizio.decorator;

import w17d1esercizio.entities.Pizza;

public class SizeDecorator extends Pizza {
	public SizeDecorator(Pizza pizza) {
		super(pizza.getName() + " + Formato Maxi", pizza.getPrice() + 4.15, pizza.getCalorie() * 1.95);
	}
}
