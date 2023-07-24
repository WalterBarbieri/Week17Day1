package w17d1esercizio.entities;

public class Oggettistica extends Merce {

	public Oggettistica(String name, double price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return "Oggettistica [Nome = " + getName() + ", Prezzo = " + getPrice() + "€]";
	}

}
