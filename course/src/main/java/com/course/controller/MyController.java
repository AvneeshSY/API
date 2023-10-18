package com.course.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.course.data.coursetable;

import com.course.service.courseservice;

@RestController
@RequestMapping("/course")
public class MyController {
	@Autowired
	private courseservice Courseservice;

	// Get a list of all Courses----------------Get a list of all Courses--------------------Get a list of all Courses
	
	@GetMapping("/allcourses")
	public List<coursetable> allRecord() {
		return Courseservice.allRecord();
	}
	
    // Save a new Course----------------------------Save a new Course--------------------------Save a new Course
	
	@PostMapping("/savecourse")
	public ResponseEntity<?> saveCourse(@RequestBody coursetable obj) {
	    // Check if a course with the provided courseId already exists
	    coursetable existingCourse = Courseservice.findByCourseId(obj.getCourseId());

	    if (existingCourse != null) {
	        return ResponseEntity.badRequest().body("Course with the provided courseId already exists.");
	    }

	    coursetable savedCourse = Courseservice.saveCourse(obj);

	    return ResponseEntity.ok(savedCourse);
	}

	 

	
//	 Delete a course by its ID-----------------Delete a course by its ID--------------------Delete a course by its ID
      
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable long courseId) {
	    coursetable course = Courseservice.findByCourseId(courseId);

	    if (course == null) {
	        return ResponseEntity.notFound().build();
	    }

	    // Set the 'status' to false
	    course.setStatus(false);
	    
	    // Save the updated course
	    Courseservice.saveCourse(course);

	    return ResponseEntity.ok("Deleted");
	}

	

	
// Get name of a course by its ID-------------- Get name of a course by its ID--------------- Get name of a course by its ID
	
	@GetMapping("/seecourse/{courseId}")
	public ResponseEntity<?> getCourseByCourseId(@PathVariable long courseId) {
	   coursetable course = Courseservice.findByCourseId(courseId);

	    if (course != null) {
	        return ResponseEntity.ok(course);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course do not exist");
	    }
	}
	
	
// Update a course by its ID-------------------Update a course by its ID-------------------Update a course by its ID
	
	@PutMapping("/updatecourse/{courseId}")
	public ResponseEntity<String> updateCourse(@PathVariable long courseId, @RequestBody coursetable updatedCourse) {
	    // Check if the course with the given courseId exists
	    coursetable existingCourse = Courseservice.findByCourseId(courseId);

	    if (existingCourse == null) {
	        return ResponseEntity.notFound().build();
	    }

	    // Update the course details
	    existingCourse.setCourseName(updatedCourse.getCourseName());
	    existingCourse.setCourseDetail(updatedCourse.getCourseDetail());

	    // Save the updated course
	    Courseservice.saveCourse(existingCourse);

	    return ResponseEntity.ok("Course updated successfully");
	}



// Partially update a course by its ID-----------------------Partially update a course by its ID-----------
	
	@PatchMapping("/{courseId}")
	public coursetable patchUpdate(@PathVariable Long courseId, @RequestBody coursetable obj) throws Exception {
		coursetable fri = Courseservice.findById(courseId);

		if (fri == null) {
			throw new Exception("Record Not found");
		}

		fri.setCourseName(obj.getCourseName());
		return Courseservice.saveCourse(fri);
	}
	

}



