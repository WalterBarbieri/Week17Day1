package w17d1esercizio.w17d1esercizio.runnable;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import w17d1esercizio.beans.BeansConfig;
import w17d1esercizio.entities.Ordine;

@Component
@Slf4j
@Order(1)
public class OrdineRunnable implements CommandLineRunner {
	private Ordine ordine1;
	private AnnotationConfigApplicationContext ctx;

	public OrdineRunnable() {
		ctx = new AnnotationConfigApplicationContext(BeansConfig.class);
		ordine1 = (Ordine) ctx.getBean("ordine1");
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
	}
}
