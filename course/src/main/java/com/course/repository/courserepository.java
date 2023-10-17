package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.data.coursetable;




@Repository
public interface courserepository extends JpaRepository<coursetable, Long>{
	coursetable findByCourseId(long CourseId);
	
}
