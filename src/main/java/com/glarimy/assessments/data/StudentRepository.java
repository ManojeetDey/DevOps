package com.glarimy.assessments.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glarimy.assessments.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findBySidIn(List<Integer> sids);

}
