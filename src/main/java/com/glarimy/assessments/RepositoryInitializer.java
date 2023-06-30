package com.glarimy.assessments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.glarimy.assessments.data.QuestionRepository;
import com.glarimy.assessments.domain.Question;

@Component
public class RepositoryInitializer implements ApplicationRunner {
	@Autowired
	private QuestionRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.save(new Question("What is the captial of India?", "New Delhi", "Chennai", "Kolkota", "Bengaluru", 1,
				"Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is a mammal?", "Bug", "Cow", "Parrot", "Fish", 2, "Test", "Test",
				1, "Krishna"));
		repo.save(new Question("Is 2 a prime number?", "Yes", "No", null, null, 1, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is in the southern hemisphere?", "Canada", "Russia", "Sweden",
				"Nepal", 4, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("What is the captial of India?", "New Delhi", "Chennai", "Kolkota", "Bengaluru", 1,
				"Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is a mammal?", "Bug", "Cow", "Parrot", "Fish", 2, "Test", "Test",
				1, "Krishna"));
		repo.save(new Question("Is 2 a prime number?", "Yes", "No", null, null, 1, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is in the southern hemisphere?", "Canada", "Russia", "Sweden",
				"Nepal", 4, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("What is the captial of India?", "New Delhi", "Chennai", "Kolkota", "Bengaluru", 1,
				"Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is a mammal?", "Bug", "Cow", "Parrot", "Fish", 2, "Test", "Test",
				1, "Krishna"));
		repo.save(new Question("Is 2 a prime number?", "Yes", "No", null, null, 1, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is in the southern hemisphere?", "Canada", "Russia", "Sweden",
				"Nepal", 4, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("What is the captial of India?", "New Delhi", "Chennai", "Kolkota", "Bengaluru", 1,
				"Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is a mammal?", "Bug", "Cow", "Parrot", "Fish", 2, "Test", "Test",
				1, "Krishna"));
		repo.save(new Question("Is 2 a prime number?", "Yes", "No", null, null, 1, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is in the southern hemisphere?", "Canada", "Russia", "Sweden",
				"Nepal", 4, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("What is the captial of India?", "New Delhi", "Chennai", "Kolkota", "Bengaluru", 1,
				"Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is a mammal?", "Bug", "Cow", "Parrot", "Fish", 2, "Test", "Test",
				1, "Krishna"));
		repo.save(new Question("Is 2 a prime number?", "Yes", "No", null, null, 1, "Test", "Test", 1, "Krishna"));
		repo.save(new Question("Which of the following is in the southern hemisphere?", "Canada", "Russia", "Sweden",
				"Nepal", 4, "Test", "Test", 1, "Krishna"));
	}
}
