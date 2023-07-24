package w17d1esercizio.w17d1esercizio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan(basePackages = { "w17d1esercizio.w17d1esercizio", "w17d1esercizio.beans" })
@Slf4j
public class W17d1esercizioApplication {

	public static void main(String[] args) {
		SpringApplication.run(W17d1esercizioApplication.class, args);

//		esercizio1();

		esercizio2();
	}

	public static void esercizio1() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				W17d1esercizioApplication.class);

		log.info((String) ctx.getBean("sayHello"));

		ctx.close();
	}

	public static void esercizio2() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				W17d1esercizioApplication.class);

		log.info("*****PIZZE*****");
		log.info(ctx.getBean("pizzaMargherita").toString());
		log.info(ctx.getBean("pizzaCrudoERucola").toString());
		log.info(ctx.getBean("pizzaMaialona").toString());
		log.info(ctx.getBean("AllIn").toString());
		log.info(ctx.getBean("pizzaCotto").toString());
		log.info(ctx.getBean("pizzaSalsicciaERucola").toString());
		log.info("*****INGREDIENTI EXTRA*****");
		log.info(ctx.getBean("prosciuttoCotto").toString());
		log.info(ctx.getBean("prosciuttoCrudo").toString());
		log.info(ctx.getBean("salsiccia").toString());
		log.info(ctx.getBean("rucola").toString());
		log.info("*****BEVANDE*****");
		log.info(ctx.getBean("birra").toString());
		log.info(ctx.getBean("vino").toString());
		log.info(ctx.getBean("coca").toString());
		log.info(ctx.getBean("acqua").toString());
		log.info("*****OGGETTISTICA*****");
		log.info(ctx.getBean("cavatappi").toString());
		log.info(ctx.getBean("magliettaDelPizzaiolo").toString());
		log.info(ctx.getBean("mattarelloLoggato").toString());
		ctx.close();
	}

}
