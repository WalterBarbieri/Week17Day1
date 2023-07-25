package w17d1esercizio.w17d1esercizio.runnable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import w17d1esercizio.w17d1esercizio.beans.BeansConfig;
import w17d1esercizio.w17d1esercizio.entities.Menu;

@Component
@Slf4j
@Order(0)
public class MenuRunnable implements CommandLineRunner {
	@Autowired
	private Menu menu;
	private AnnotationConfigApplicationContext ctx;

	public MenuRunnable() {
		ctx = new AnnotationConfigApplicationContext(BeansConfig.class);
		menu = (Menu) ctx.getBean("menu");
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("**********PIZZE**********");
		menu.getPizzaList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("**********FORMATO MAXI**********");
		log.info("Pizza Maxi [Calorie = * 1.95, Prezzo = +4.15€]");
		log.info("");
		log.info("**********INGREDIENTI A SCELTA**********");
		menu.getIngredientiList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("**********BEVANDE**********");
		menu.getBevandeList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("**********OGGETTISTICA**********");
		menu.getOggettisticaList().forEach(el -> log.info(el.toString()));
		log.info("");
		log.info("");
		log.info("**********TAVOLI**********");
		log.info(ctx.getBean("tavolo1").toString());
		log.info(ctx.getBean("tavolo2").toString());
		log.info(ctx.getBean("tavolo3").toString());
		log.info("");
		log.info("");
	}

}
