package w17d1prove.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeansConfig {

	@Bean
	String getName() {
		return "Vino";
	}

	@Bean
	int getAge() {
		return 32;
	}

	@Bean
	FrontendStudent getFe() {
		return new FrontendStudent("Nino");
	}

	@Bean
	@Primary
	BackendStudent getBe() {
		return new BackendStudent(getName());
	}

	@Bean(name = "getInterviewer")
	Interviewer interviewer(IStudent s) {
		return new Interviewer(s);
	}
}
