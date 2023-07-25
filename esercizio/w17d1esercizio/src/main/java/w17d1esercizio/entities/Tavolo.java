package w17d1esercizio.entities;

import lombok.Getter;
import lombok.Setter;
import w17d1esercizio.entities.enums.StatoTavolo;

@Getter
@Setter
public class Tavolo {
	private int numeroTavolo;
	private int numeroCoperti;
	private StatoTavolo statoTavolo;
	private Ordine ordine;

	public Tavolo(int numeroTavolo, int numeroCoperti, StatoTavolo statoTavolo) {
		super();
		this.setNumeroTavolo(numeroTavolo);
		this.setNumeroCoperti(numeroCoperti);
		this.setStatoTavolo(statoTavolo);
	}

	@Override
	public String toString() {
		return "Tavolo [Numero = " + numeroTavolo + ", Coperti = " + numeroCoperti + ", Stato Tavolo = " + statoTavolo
				+ "]";
	}

}
