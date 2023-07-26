package w17d1esercizio.w17d1esercizio.runnable;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import w17d1esercizio.w17d1esercizio.beans.BeansConfig;
import w17d1esercizio.w17d1esercizio.entities.Ordine;

@Component
@Slf4j
@Order(1)
public class OrdineRunnable implements CommandLineRunner {
	private Ordine ordine1;
	private Ordine ordine2;
	private Ordine ordine3;

	private AnnotationConfigApplicationContext ctx;

	public OrdineRunnable() {
		ctx = new AnnotationConfigApplicationContext(BeansConfig.class);
		ordine1 = (Ordine) ctx.getBean("ordine1");
		ordine2 = (Ordine) ctx.getBean("ordine2");
		ordine3 = (Ordine) ctx.getBean("ordine3");

	}

	@Override
	public void run(String... args) throws Exception {

		printOrdine(ordine1);
		printOrdine(ordine2);
		printOrdine(ordine3);

	}

	public void printOrdine(Ordine ordine) {
		log.info("**********ORDINE " + ordine.getNumeroOrdine() + "**********");
		log.info("Coperti = " + ordine.getNumeroCoperti());
		log.info("Orario = " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
		log.info("Tavolo Numero = " + ordine.getTavolo().getNumeroTavolo());
		log.info("");
		log.info("Ordine = ");
		ordine.getPizzaList().forEach(el -> log.info(el.toString()));
		ordine.getBevandeList().forEach(el -> log.info(el.toString()));
		ordine.getOggettisticaList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("Coperto segretissimo = " + ordine.getSecretCoperto() + "€");
		log.info("Stato Ordine = " + ordine.getStatoOrdine());
		log.info("");
		log.info("Totale = " + ordine.getTotale() + "€");
		log.info("");
		if (ordine.getNota() == null) {
			ordine.setNota("...");
		}
		log.info("Note = " + ordine.getNota());
		log.info("");
	}
}
