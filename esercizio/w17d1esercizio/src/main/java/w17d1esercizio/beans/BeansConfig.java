package w17d1esercizio.beans;

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
import w17d1esercizio.entities.Oggettistica;
import w17d1esercizio.entities.Pizza;
import w17d1esercizio.entities.PizzaMargherita;

@Configuration
public class BeansConfig {
	// ***********************ESERCIZIO 1***********************
	@Bean
	String sayHello() {
		return "Ciao Mondo";
	}

	// ***********************ESERCIZIO 2***********************
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
		allIn.setName("Pizza con TUTTO");
		return allIn;
	}

	@Bean
	Pizza pizzaSalsicciaERucola() {
		return new SalsicciaDecorator(new RucolaDecorator(new PizzaMargherita()));
	}

	@Bean
	Pizza pizzaMaxi() {
		return new SizeDecorator(new PizzaMargherita());
	}

	@Bean
	Pizza pizzaMaialonaMaxi() {
		return new SizeDecorator(pizzaMaialona());
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

}
