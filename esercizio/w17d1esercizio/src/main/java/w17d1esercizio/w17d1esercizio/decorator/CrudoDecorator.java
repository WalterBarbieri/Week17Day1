package w17d1esercizio.w17d1esercizio.decorator;

import w17d1esercizio.w17d1esercizio.entities.Pizza;

public class CrudoDecorator extends Pizza {
	public CrudoDecorator(Pizza pizza) {
		super(pizza.getName() + " + prosciutto crudo", pizza.getPrice() + 2, pizza.getCalorie() + 20);
	}
}
