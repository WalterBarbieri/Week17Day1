package w17d1esercizio.beans;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import w17d1esercizio.decorator.CottoDecorator;
import w17d1esercizio.decorator.CrudoDecorator;
import w17d1esercizio.decorator.IngredienteDecorator;
import w17d1esercizio.decorator.RucolaDecorator;
import w17d1esercizio.decorator.SalsicciaDecorator;
import w17d1esercizio.decorator.SizeDecorator;
import w17d1esercizio.entities.Bevande;
import w17d1esercizio.entities.Ingredienti;
import w17d1esercizio.entities.Menu;
import w17d1esercizio.entities.Oggettistica;
import w17d1esercizio.entities.Ordine;
import w17d1esercizio.entities.Pizza;
import w17d1esercizio.entities.PizzaMargherita;
import w17d1esercizio.entities.Tavolo;
import w17d1esercizio.entities.enums.StatoOrdine;
import w17d1esercizio.entities.enums.StatoTavolo;

@Configuration
public class BeansConfig {
	// ***********************ESERCIZIO 1 DAY 1***********************
	@Bean
	String sayHello() {
		return "Ciao Mondo";
	}

	// ***********************ESERCIZIO 2 DAY 1 & DAY 2***********************
	// MENU

	@Bean
	Ordine ordine1() {
		Ordine ordine1 = new Ordine(1, StatoOrdine.SERVITO, 6, LocalDateTime.now(), tavolo1());
		ordine1.getPizzaList().add(pizzaCrudoERucola());
		ordine1.getPizzaList().add(pizzaSalsicciaERucola());
		ordine1.getPizzaList().add(pizzaMaialona());
		ordine1.getPizzaList().add(pizzaMargherita());
		ordine1.getPizzaList().add(pizzaMargherita());
		ordine1.getPizzaList().add(pizzaCustom());
		ordine1.getBevandeList().add(birra());
		ordine1.getBevandeList().add(birra());
		ordine1.getBevandeList().add(birra());
		ordine1.getBevandeList().add(birra());
		ordine1.getBevandeList().add(coca());
		ordine1.getBevandeList().add(coca());
		ordine1.getOggettisticaList().add(mattarelloLoggato());
		return ordine1;

	}

	@Bean
	Menu menu() {
		Menu menu = new Menu();
		menu.getPizzaList().add(pizzaMargherita());
		menu.getPizzaList().add(pizzaCrudoERucola());
		menu.getPizzaList().add(pizzaMaialona());
		menu.getPizzaList().add(pizzaSalsicciaERucola());
		menu.getPizzaList().add(AllIn());
		menu.getPizzaList().add(pizzaMaxi());
		menu.getPizzaList().add(pizzaMaialonaMaxi());

		menu.getIngredientiList().add(prosciuttoCotto());
		menu.getIngredientiList().add(prosciuttoCrudo());
		menu.getIngredientiList().add(salsiccia());
		menu.getIngredientiList().add(rucola());

		menu.getBevandeList().add(birra());
		menu.getBevandeList().add(vino());
		menu.getBevandeList().add(acqua());
		menu.getBevandeList().add(coca());

		menu.getOggettisticaList().add(cavatappi());
		menu.getOggettisticaList().add(magliettaDelPizzaiolo());
		menu.getOggettisticaList().add(mattarelloLoggato());

		return menu;

	}

	// PIZZE

	@Bean
	Pizza pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	Pizza pizzaCotto() {
		return new CottoDecorator(new PizzaMargherita());
	}

	@Bean
	Pizza pizzaCrudoERucola() {
		RucolaDecorator crudoERucola = new RucolaDecorator(new CrudoDecorator(new PizzaMargherita()));
		crudoERucola.setName("Pizza Crudo e Rucola");
		return crudoERucola;
	}

	@Bean
	Pizza pizzaMaialona() {
		SalsicciaDecorator maialona = new SalsicciaDecorator(
				new CottoDecorator(new CrudoDecorator(new PizzaMargherita())));
		maialona.setName("Pizza Maialona (Salsiccia, Prosciutto Crudo, Prosciutto Cotto)");
		return maialona;
	}

	@Bean
	Pizza AllIn() {
		RucolaDecorator allIn = new RucolaDecorator(
				new SalsicciaDecorator(new CottoDecorator(new CrudoDecorator(new PizzaMargherita()))));
		allIn.setName("Pizza con TUTTO (Salsiccia, Prosciutto Crudo, Prosciutto Cotto, Rucola)");
		return allIn;
	}

	@Bean
	Pizza pizzaSalsicciaERucola() {
		SalsicciaDecorator salsicciaERucola = new SalsicciaDecorator(new RucolaDecorator(new PizzaMargherita()));
		salsicciaERucola.setName("Pizza Salsiccia e Rucola");
		return salsicciaERucola;
	}

	@Bean
	Pizza pizzaMaxi() {
		SizeDecorator pizzaMargheritaMAxi = new SizeDecorator(new PizzaMargherita());
		pizzaMargheritaMAxi.setName("Maxi Pizza Margherita");
		return pizzaMargheritaMAxi;
	}

	@Bean
	Pizza pizzaMaialonaMaxi() {
		SizeDecorator maialonaMaxi = new SizeDecorator(pizzaMaialona());
		maialonaMaxi.setName("Maxi Pizza Maialona");
		return maialonaMaxi;
	}

	@Bean
	Pizza pizzaCustom() {
		return new IngredienteDecorator(new PizzaMargherita(), salsiccia());
	}

	// INGREDIENTI
	@Bean
	Ingredienti prosciuttoCotto() {
		return new Ingredienti("Prosciutto Cotto", 1.5, 30);
	}

	@Bean
	Ingredienti prosciuttoCrudo() {
		return new Ingredienti("Prosciutto Crudo", 2, 20);
	}

	@Bean
	Ingredienti salsiccia() {
		return new Ingredienti("Salsiccia", 1.5, 40);
	}

	@Bean
	Ingredienti rucola() {
		return new Ingredienti("Rucola", 0.5, 5);
	}

	// BEVANDE
	@Bean
	Bevande birra() {
		return new Bevande("Birra", 3.5, 200);
	}

	@Bean
	Bevande acqua() {
		return new Bevande("Acqua", 1, 0);
	}

	@Bean
	Bevande coca() {
		return new Bevande("Coca Cola", 2, 300);
	}

	@Bean
	Bevande vino() {
		return new Bevande("Vino", 16, 700);
	}

// OGGETTISTICA
	@Bean
	Oggettistica cavatappi() {
		return new Oggettistica("Cavatappi", 5);
	}

	@Bean
	Oggettistica magliettaDelPizzaiolo() {
		return new Oggettistica("Maglietta del Pizzaiolo", 1000);
	}

	@Bean
	Oggettistica mattarelloLoggato() {
		return new Oggettistica("Mattarello (vero legno)", 15);
	}

	// TAVOLI
	@Bean
	Tavolo tavolo1() {
		return new Tavolo(1, 6, StatoTavolo.OCCUPATO);
	}

	@Bean
	Tavolo tavolo2() {
		return new Tavolo(2, 4, StatoTavolo.LIBERO);
	}

	@Bean
	Tavolo tavolo3() {
		return new Tavolo(3, 10, StatoTavolo.LIBERO);
	}

}
