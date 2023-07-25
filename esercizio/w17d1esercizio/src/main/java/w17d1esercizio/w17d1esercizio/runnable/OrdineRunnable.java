package w17d1esercizio.w17d1esercizio.runnable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import w17d1esercizio.beans.BeansConfig;
import w17d1esercizio.entities.Ordine;

@Component
@Slf4j
public class OrdineRunnable implements CommandLineRunner {
	private Ordine ordine;
	private AnnotationConfigApplicationContext ctx;

	public OrdineRunnable() {
		ctx = new AnnotationConfigApplicationContext(BeansConfig.class);
		ordine = (Ordine) ctx.getBean("ordine1");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(null);
	}
}
