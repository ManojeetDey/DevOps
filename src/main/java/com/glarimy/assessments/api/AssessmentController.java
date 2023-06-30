package com.glarimy.assessments.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glarimy.assessments.AssessmentRepository;
import com.glarimy.assessments.data.QuestionRepository;
import com.glarimy.assessments.data.StudentRepository;
import com.glarimy.assessments.domain.Question;
import com.glarimy.assessments.domain.Assessment;
import com.glarimy.assessments.domain.Student;

@RestController
@EnableTransactionManagement
@CrossOrigin
public class AssessmentController {
	Logger logger = LoggerFactory.getLogger(AssessmentController.class);
	@Autowired
	private QuestionRepository questionsRepo;
	@Autowired
	private AssessmentRepository assessmentRepo;
	@Autowired
	private StudentRepository studentRepo;

	@PostMapping("/question")
	public ResponseEntity<Question> add(@RequestBody Question question) {
		question = questionsRepo.save(question);
		return ResponseEntity.status(HttpStatus.CREATED).body(question);
	}

	@PostMapping("/student")
	public ResponseEntity<Student> add(@RequestBody Student student) {
		studentRepo.save(student);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

	@PostMapping("/assessment")
	public ResponseEntity<Assessment> generate(@RequestParam("subject") String subject, @RequestParam("topic") String topic) {
		// List<Integer> ids = questionsRepo.findQidBySubjectAndTopic(subject,
		// topic).stream().map(qn -> qn.getQid())
		// .collect(Collectors.toList());
		List<Question> questions = questionsRepo.findBySubjectAndTopic(subject, topic);
		Collections.shuffle(questions);
		Assessment assessment = new Assessment();
		assessment.setQuestions(questions.subList(0, 10));
		assessment.setSubject(subject);
		assessment.setTopic(topic);
		assessment = assessmentRepo.save(assessment);
		return ResponseEntity.status(HttpStatus.OK).body(assessment);
	}

	@PostMapping("/assessment/{id}/schedule")
	@Transactional
	public ResponseEntity<Assessment> schdule(@PathVariable("id") int id, @RequestBody Schedule schedule) {
		Optional<Assessment> optional = assessmentRepo.findById(id);
		if (optional.isPresent()) {
			Assessment assessment = optional.get();
			// quiz.setFrom(schedule.getFrom());
			// quiz.setTo(schedule.getTo());
			assessment.setStudents(studentRepo.findBySidIn(schedule.getStudents()));
			assessment.setScheduled(true);
			return ResponseEntity.status(HttpStatus.OK).body(assessment);
		}
		logger.error("Assessment with id" + id + " is not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/assessment/{id}/questions")
	public ResponseEntity<List<Question>> fetch(@PathVariable("id") int id) {
		Optional<Assessment> optional = assessmentRepo.findById(id);
		if (optional.isPresent()) {
			Assessment assessment = optional.get();
			if (assessment.isScheduled()) {
				List<Question> questions = assessment.getQuestions();
				return ResponseEntity.status(HttpStatus.OK).body(questions);
			}
			logger.error("Assessment with id" + id + " is not scheduled");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		logger.error("Assessment with id" + id + " is not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("/assessment/{id}/answers")
	public ResponseEntity<Score> evaluate(@PathVariable("id") int id, @RequestParam("sid") int sid,
			@RequestBody List<Answer> answers) {
		Optional<Assessment> optional = assessmentRepo.findById(id);
		if (optional.isPresent()) {
			Assessment assessment = optional.get();
			if (assessment.getStudents().contains(studentRepo.findById(sid).get())) {
				int rights = 0;
				for (Answer answer : answers)
					rights += (int) questionsRepo.countByQidAndAnswer(answer.getQid(), answer.getOption());
				Score score = new Score(answers.size(), rights);
				return ResponseEntity.status(HttpStatus.CREATED).body(score);
			}
			logger.error("Assessment with id" + id + " is not scheduled for the student with id " + sid);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		logger.error("Assessment with id" + id + " is not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}