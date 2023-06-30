package com.glarimy.assessments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.assessments.domain.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

}
