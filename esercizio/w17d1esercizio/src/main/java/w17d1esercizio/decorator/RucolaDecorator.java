package w17d1esercizio.decorator;

import w17d1esercizio.entities.Pizza;

public class RucolaDecorator extends Pizza {
	public RucolaDecorator(Pizza pizza) {
		super(pizza.getName() + " + rucola", pizza.getPrice() + 0.5, pizza.getCalorie() + 5);
	}
}
