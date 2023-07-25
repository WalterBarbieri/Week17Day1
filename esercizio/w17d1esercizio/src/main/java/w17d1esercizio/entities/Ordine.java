package w17d1esercizio.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import w17d1esercizio.entities.enums.StatoOrdine;

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

	@Value("application.secretCoperto")
	private int secretCoperto;

	public Ordine(int numeroOrdine, StatoOrdine statoOrdine, int numeroCoperti, LocalDateTime orario, Tavolo tavolo) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.statoOrdine = statoOrdine;
		this.numeroCoperti = numeroCoperti;
		this.orario = orario;
		this.tavolo = tavolo;
	}

	@PostConstruct
	public void setSecretCoperto() {
		this.secretCoperto = secretCoperto * numeroCoperti;
	}

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
