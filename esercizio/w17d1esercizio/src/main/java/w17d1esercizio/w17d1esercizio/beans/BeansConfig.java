package w17d1esercizio.w17d1esercizio.beans;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import w17d1esercizio.w17d1esercizio.decorator.CottoDecorator;
import w17d1esercizio.w17d1esercizio.decorator.CrudoDecorator;
import w17d1esercizio.w17d1esercizio.decorator.IngredienteDecorator;
import w17d1esercizio.w17d1esercizio.decorator.RucolaDecorator;
import w17d1esercizio.w17d1esercizio.decorator.SalsicciaDecorator;
import w17d1esercizio.w17d1esercizio.decorator.SizeDecorator;
import w17d1esercizio.w17d1esercizio.entities.Bevande;
import w17d1esercizio.w17d1esercizio.entities.Ingredienti;
import w17d1esercizio.w17d1esercizio.entities.Menu;
import w17d1esercizio.w17d1esercizio.entities.Oggettistica;
import w17d1esercizio.w17d1esercizio.entities.Ordine;
import w17d1esercizio.w17d1esercizio.entities.Pizza;
import w17d1esercizio.w17d1esercizio.entities.PizzaMargherita;
import w17d1esercizio.w17d1esercizio.entities.Tavolo;
import w17d1esercizio.w17d1esercizio.entities.enums.StatoOrdine;
import w17d1esercizio.w17d1esercizio.entities.enums.StatoTavolo;

@PropertySource("classpath:application.properties")
@Configuration
public class BeansConfig {

	// ***********************ESERCIZIO 1 DAY 1***********************
	@Bean
	String sayHello() {
		return "Ciao Mondo";
	}

	// ***********************ESERCIZIO 2 DAY 1 & DAY 2***********************

	// ORDINI

	@Bean
	@Scope("prototype")
	Ordine ordine1() {
		Ordine ordine = new Ordine(1, StatoOrdine.SERVITO, 6, LocalDateTime.now(), tavolo1());
		ordine.getPizzaList().add(pizzaCrudoERucola());
		ordine.getPizzaList().add(pizzaSalsicciaERucola());
		ordine.getPizzaList().add(pizzaMaialona());
		ordine.getPizzaList().add(pizzaMargherita());
		ordine.getPizzaList().add(pizzaMargherita());
		ordine.getPizzaList().add(pizzaCustom());
		ordine.getBevandeList().add(birra());
		ordine.getBevandeList().add(birra());
		ordine.getBevandeList().add(birra());
		ordine.getBevandeList().add(acqua());
		ordine.getBevandeList().add(coca());
		ordine.getBevandeList().add(coca());
		ordine.getOggettisticaList().add(mattarelloLoggato());
		ordine.setTotale();
		tavolo1().setOrdine(ordine);
		return ordine;

	}

	@Bean
	@Scope("prototype")
	Ordine ordine3() {
		Ordine ordine = new Ordine(3, StatoOrdine.IN_CORSO, 4, LocalDateTime.now(), tavolo2());
		ordine.getPizzaList().add(pizzaCrudoERucola());
		ordine.getPizzaList().add(pizzaSalsicciaERucola());
		ordine.getPizzaList().add(pizzaMaialona());
		ordine.getPizzaList().add(pizzaCustom());
		ordine.getBevandeList().add(vino());

		ordine.getOggettisticaList().add(magliettaDelPizzaiolo());
		ordine.setTotale();
		ordine.setNota("Vogliono il vino buono");
		tavolo2().setOrdine(ordine);
		return ordine;

	}

	@Bean
	@Scope("prototype")
	Ordine ordine2() {
		Ordine ordine = new Ordine(2, StatoOrdine.PRONTO, 10, LocalDateTime.now(), tavolo3());
		ordine.getPizzaList().add(pizzaMaxi());
		ordine.getPizzaList().add(pizzaMaialonaMaxi());
		ordine.getPizzaList().add(pizzaMaialonaMaxi());
		ordine.getPizzaList().add(pizzaCustom2());

		ordine.getBevandeList().add(birra());
		for (int i = 0; i < 20; i++) {
			ordine.getBevandeList().add(birra());
		}
		ordine.getOggettisticaList().add(cavatappi());
		ordine.setTotale();
		ordine.setNota("Questi si ubriacano, portare birra");
		tavolo3().setOrdine(ordine);
		return ordine;

	}

	// MENU
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
	@Scope("prototype")
	Pizza pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaCotto() {
		return new CottoDecorator(new PizzaMargherita());
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaCrudoERucola() {
		RucolaDecorator crudoERucola = new RucolaDecorator(new CrudoDecorator(new PizzaMargherita()));
		crudoERucola.setName("Pizza Crudo e Rucola");
		return crudoERucola;
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaMaialona() {
		SalsicciaDecorator maialona = new SalsicciaDecorator(
				new CottoDecorator(new CrudoDecorator(new PizzaMargherita())));
		maialona.setName("Pizza Maialona (Salsiccia, Prosciutto Crudo, Prosciutto Cotto)");
		return maialona;
	}

	@Bean
	@Scope("prototype")
	Pizza AllIn() {
		RucolaDecorator allIn = new RucolaDecorator(
				new SalsicciaDecorator(new CottoDecorator(new CrudoDecorator(new PizzaMargherita()))));
		allIn.setName("Pizza con TUTTO (Salsiccia, Prosciutto Crudo, Prosciutto Cotto, Rucola)");
		return allIn;
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaSalsicciaERucola() {
		SalsicciaDecorator salsicciaERucola = new SalsicciaDecorator(new RucolaDecorator(new PizzaMargherita()));
		salsicciaERucola.setName("Pizza Salsiccia e Rucola");
		return salsicciaERucola;
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaMaxi() {
		SizeDecorator pizzaMargheritaMAxi = new SizeDecorator(new PizzaMargherita());
		pizzaMargheritaMAxi.setName("Maxi Pizza Margherita");
		return pizzaMargheritaMAxi;
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaMaialonaMaxi() {
		SizeDecorator maialonaMaxi = new SizeDecorator(pizzaMaialona());
		maialonaMaxi.setName("Maxi Pizza Maialona");
		return maialonaMaxi;
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaCustom() {
		return new IngredienteDecorator(new PizzaMargherita(), salsiccia());
	}

	@Bean
	@Scope("prototype")
	Pizza pizzaCustom2() {
		return new IngredienteDecorator(new IngredienteDecorator(new PizzaMargherita(), salsiccia()),
				prosciuttoCotto());
	}

	// INGREDIENTI
	@Bean
	@Scope("prototype")
	Ingredienti prosciuttoCotto() {
		return new Ingredienti("Prosciutto Cotto", 1.5, 30);
	}

	@Bean
	@Scope("prototype")
	Ingredienti prosciuttoCrudo() {
		return new Ingredienti("Prosciutto Crudo", 2, 20);
	}

	@Bean
	@Scope("prototype")
	Ingredienti salsiccia() {
		return new Ingredienti("Salsiccia", 1.5, 40);
	}

	@Bean
	@Scope("prototype")
	Ingredienti rucola() {
		return new Ingredienti("Rucola", 0.5, 5);
	}

	// BEVANDE
	@Bean
	@Scope("prototype")
	Bevande birra() {
		return new Bevande("Birra", 3.5, 200);
	}

	@Bean
	@Scope("prototype")
	Bevande acqua() {
		return new Bevande("Acqua", 1, 0);
	}

	@Bean
	@Scope("prototype")
	Bevande coca() {
		return new Bevande("Coca Cola", 2, 300);
	}

	@Bean
	@Scope("prototype")
	Bevande vino() {
		return new Bevande("Vino", 16, 700);
	}

// OGGETTISTICA
	@Bean
	@Scope("prototype")
	Oggettistica cavatappi() {
		return new Oggettistica("Cavatappi", 5);
	}

	@Bean
	@Scope("prototype")
	Oggettistica magliettaDelPizzaiolo() {
		return new Oggettistica("Maglietta del Pizzaiolo", 1000);
	}

	@Bean
	@Scope("prototype")
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
