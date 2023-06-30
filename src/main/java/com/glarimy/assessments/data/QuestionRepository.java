package com.glarimy.assessments.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.assessments.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findByQidIn(List<Integer> qids);

	List<QuestionNumber> findQidBySubjectAndTopic(String subject, String topic);

	List<Question> findBySubjectAndTopic(String subject, String topic);

	long countByQidAndAnswer(int qid, int option);
}
