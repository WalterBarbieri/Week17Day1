package w17d1esercizio.w17d1esercizio.decorator;

import w17d1esercizio.w17d1esercizio.entities.Ingredienti;
import w17d1esercizio.w17d1esercizio.entities.Pizza;

public class IngredienteDecorator extends Pizza {
	public IngredienteDecorator(Pizza pizza, Ingredienti ingrediente) {
		super(pizza.getName() + " + " + ingrediente.getName(), pizza.getPrice() + ingrediente.getPrice(),
				pizza.getCalorie() + ingrediente.getCalorie());
	}
}
