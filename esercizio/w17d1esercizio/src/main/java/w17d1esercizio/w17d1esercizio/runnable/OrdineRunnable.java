package w17d1esercizio.w17d1esercizio.runnable;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private Ordine ordine1;
	@Autowired
	private Ordine ordine2;
	@Autowired
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

		log.info("**********ORDINE " + ordine1.getNumeroOrdine() + "**********");
		log.info("Coperti = " + ordine1.getNumeroCoperti());
		log.info("Orario = " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
		log.info("Tavolo Numero = " + ordine1.getTavolo().getNumeroTavolo());
		log.info("");
		log.info("Ordine = ");
		ordine1.getPizzaList().forEach(el -> log.info(el.toString()));
		ordine1.getBevandeList().forEach(el -> log.info(el.toString()));
		ordine1.getOggettisticaList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("Coperto segretissimo = " + ordine1.getSecretCoperto() + "€");
		log.info("Stato Ordine = " + ordine1.getStatoOrdine());
		log.info("");
		log.info("Totale = " + ordine1.getTotale() + "€");
		log.info("");
		if (ordine1.getNota() == null) {
			ordine1.setNota("...");
		}
		log.info("Note = " + ordine1.getNota());
		log.info("");

		log.info("**********ORDINE " + ordine2.getNumeroOrdine() + "**********");
		log.info("Coperti = " + ordine2.getNumeroCoperti());
		log.info("Orario = " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
		log.info("Tavolo Numero = " + ordine2.getTavolo().getNumeroTavolo());
		log.info("");
		log.info("Ordine = ");
		ordine2.getPizzaList().forEach(el -> log.info(el.toString()));
		ordine2.getBevandeList().forEach(el -> log.info(el.toString()));
		ordine2.getOggettisticaList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("Coperto segretissimo = " + ordine2.getSecretCoperto() + "€");
		log.info("Stato Ordine = " + ordine2.getStatoOrdine());
		log.info("");
		log.info("Totale = " + ordine2.getTotale() + "€");
		log.info("");
		if (ordine2.getNota() == null) {
			ordine2.setNota("...");
		}
		log.info("Note = " + ordine2.getNota());
		log.info("");

		log.info("**********ORDINE " + ordine3.getNumeroOrdine() + "**********");
		log.info("Coperti = " + ordine3.getNumeroCoperti());
		log.info("Orario = " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
		log.info("Tavolo Numero = " + ordine3.getTavolo().getNumeroTavolo());
		log.info("");
		log.info("Ordine = ");
		ordine3.getPizzaList().forEach(el -> log.info(el.toString()));
		ordine3.getBevandeList().forEach(el -> log.info(el.toString()));
		ordine3.getOggettisticaList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("Coperto segretissimo = " + ordine3.getSecretCoperto() + "€");
		log.info("Stato Ordine = " + ordine3.getStatoOrdine());
		log.info("");
		log.info("Totale = " + ordine3.getTotale() + "€");
		log.info("");
		if (ordine3.getNota() == null) {
			ordine3.setNota("...");
		}
		log.info("Note = " + ordine3.getNota());
		log.info("");
	}
}
