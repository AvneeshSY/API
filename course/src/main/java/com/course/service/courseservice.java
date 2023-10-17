package com.course.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.course.data.coursetable;
import com.course.repository.courserepository;

@Service
public class courseservice {
	@Autowired
	courserepository Courserepo;

	// Find a course by its ID....................Find a course by its
	
	public coursetable findById(long courseId) {
		return Courserepo.findById(courseId).get();
	}

	// Delete a course by its ID......................


	public ResponseEntity<String> deleteById(long courseId) {
		try {
			Courserepo.deleteById(courseId);
			return ResponseEntity.ok("DELETED SUCCESSFULLY");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during deletion");
		}
	}

	// Save or update a course......................

	    public coursetable savecourse(coursetable obj) {
		if (obj.getId() != 0) {
			// This is an update operation, so set the updatedAt field
			obj.setUpdatedAt(new Date());

			// Fetch the existing course entity from the database to retain the original
			// createdAt value
			coursetable existingCourse = Courserepo.findById(obj.getId()).orElse(null);
			if (existingCourse != null) {
				obj.setCreatedAt(existingCourse.getCreatedAt());
			}
		} else {
			// This is a new entity, set the createdAt and updatedAt fields
			obj.setCreatedAt(new Date());
			obj.setUpdatedAt(new Date());
		}

		return Courserepo.save(obj);
	}

	// Save or update a course----------------Save or update a
	

	public coursetable saveCourse(coursetable obj) {
		return Courserepo.save(obj);
	}

	// Check if a course with a given ID exists---------------- 

	public Boolean existsById(Long courseId) {
		return Courserepo.existsById(courseId);
	}
	
	

	// Retrieve a list of all courses----------------------

	public List<coursetable> allRecord() {
		return Courserepo.findAll();
	}

	public coursetable findByCourseId(long courseId) {
		return Courserepo.findByCourseId(courseId);
	}

}
