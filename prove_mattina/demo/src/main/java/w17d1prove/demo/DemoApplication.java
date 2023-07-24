package w17d1prove.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication

@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Metodo tradizionale
//		FrontendStudent f = new FrontendStudent("Pino");
//		BackendStudent b = new BackendStudent("Tino");
//		FullstackStudent fb = new FullstackStudent("Lino");
//
//		Interviewer i1 = new Interviewer(f);
//		Interviewer i2 = new Interviewer(b);
//		Interviewer i3 = new Interviewer(fb);
//
//		i1.askQuestion();
//		i2.askQuestion();
//		i3.askQuestion();
//		configWithConfigAnnotation();
		configWithComponent();
	}

	public static void configWithConfigAnnotation() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoApplication.class);
		log.info((String) ctx.getBean("getName"));

		log.info(ctx.getBean("getFe").toString());

		log.info(ctx.getBean("getInterviewer").toString());

		ctx.close();
	}

	// In disuso, riguarda la repo di Riccardo + Registrazione Lezione 24/07/2023
	// per info
	public static void configWithXml() {
	}

	public static void configWithComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoApplication.class);

//		ctx.refresh();

		log.info(ctx.getBean(FullstackStudent.class).toString());
		ctx.close();
	}

}
