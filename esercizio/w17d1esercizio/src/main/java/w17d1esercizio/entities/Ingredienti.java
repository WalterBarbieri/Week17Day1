package w17d1esercizio.entities;

public class Ingredienti extends Commestibile {

	public Ingredienti(String name, double price, double calorie) {
		super(name, price, calorie);
	}

	@Override
	public String toString() {
		return "Ingredienti [Nome = " + getName() + ", Calorie = " + getCalorie() + ", Prezzo = " + getPrice() + "€]";
	}
}
