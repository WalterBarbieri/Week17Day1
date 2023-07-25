package w17d1esercizio.w17d1esercizio.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
	private List<Pizza> pizzaList = new ArrayList<>();
	private List<Ingredienti> ingredientiList = new ArrayList<>();
	private List<Bevande> bevandeList = new ArrayList<>();
	private List<Oggettistica> oggettisticaList = new ArrayList<>();

}
