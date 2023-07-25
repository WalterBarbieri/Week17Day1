package w17d1esercizio.w17d1esercizio.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import w17d1esercizio.w17d1esercizio.entities.enums.StatoOrdine;

@Component
@Getter
@Setter
@PropertySource("classpath:application.properties")
public class Ordine {
	private int numeroOrdine;
	private StatoOrdine statoOrdine;
	private int numeroCoperti;
	private LocalDateTime orario;
	private double totale;
	private Tavolo tavolo;
	private List<Pizza> pizzaList = new ArrayList<>();
	private List<Ingredienti> ingredientiList = new ArrayList<>();
	private List<Bevande> bevandeList = new ArrayList<>();
	private List<Oggettistica> oggettisticaList = new ArrayList<>();
	@Value("${application.secret}")
	private int secretCoperto;

	public Ordine(int numeroOrdine, StatoOrdine statoOrdine, int numeroCoperti, LocalDateTime orario, Tavolo tavolo) {
		this.numeroOrdine = numeroOrdine;
		this.statoOrdine = statoOrdine;
		this.numeroCoperti = numeroCoperti;
		this.orario = orario;
		this.tavolo = tavolo;
	}

	@PostConstruct
	public void setNewSecretCoperto() {
		this.secretCoperto = secretCoperto * numeroCoperti;
	}

//	public void setSecretCoperto(int number) {
//		this.secretCoperto = number * numeroCoperti;
//	}

	public void setTotale() {
		double total = 0;
		for (Pizza pizza : pizzaList) {
			total += pizza.getPrice();
		}
		for (Ingredienti ingrediente : ingredientiList) {
			total += ingrediente.getPrice();
		}
		for (Bevande bevanda : bevandeList) {
			total += bevanda.getPrice();
		}
		for (Oggettistica oggetto : oggettisticaList) {
			total += oggetto.getPrice();
		}

		total += secretCoperto;
		this.totale = total;

	}

}
