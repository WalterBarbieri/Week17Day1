package w17d1esercizio.w17d1esercizio.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Commestibile extends Merce {

	private double calorie;

	public Commestibile(String name, double price, double calorie) {
		super(name, price);
		this.setCalorie(calorie);
	}

	@Override
	public String toString() {
		return "Pizza [Nome = " + getName() + ", Calorie = " + getCalorie() + ", Prezzo = " + getPrice() + "€]";
	}

}
