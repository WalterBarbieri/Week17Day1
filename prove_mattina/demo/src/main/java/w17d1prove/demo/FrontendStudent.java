package w17d1prove.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Slf4j
public class FrontendStudent implements IStudent {

	private String name;

	@Override
	public void answerQuestions() {
		log.info("Frontend Student " + name + ": This is the answer...");
	}
}
