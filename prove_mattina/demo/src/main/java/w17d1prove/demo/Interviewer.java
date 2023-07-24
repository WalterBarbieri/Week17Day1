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
public class Interviewer {
	private IStudent student;

	public void askQuestion() {
		log.warn("Hey " + student.getName() + " can you solve this problem?");
		student.answerQuestions();
	}
}
