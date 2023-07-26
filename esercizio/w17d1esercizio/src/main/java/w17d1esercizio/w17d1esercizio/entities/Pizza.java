package w17d1esercizio.w17d1esercizio.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pizza extends Commestibile {

	public Pizza(String name, double price, double calorie) {
		super(name, price, calorie);
	}

}
