package w17d1esercizio.w17d1esercizio.entities;

public class Bevande extends Commestibile {

	public Bevande(String name, double price, double calorie) {
		super(name, price, calorie);
	}

	@Override
	public String toString() {
		return "Bevande [Nome = " + getName() + ", Calorie = " + getCalorie() + ", Prezzo = " + getPrice() + "€]";
	}

}
