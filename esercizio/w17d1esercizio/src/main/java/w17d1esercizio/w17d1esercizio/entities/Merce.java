package w17d1esercizio.w17d1esercizio.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Merce {
	private String name;
	private double price;
}
