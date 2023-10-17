package com.course.data;
	
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Course")
public class coursetable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column
	private String CourseName;
	
	@Column
	private String CourseDetail;
	
	@Column
	private long courseId;



	
//	CREATED-AT-------------CREATED-AT-------------CREATED-AT-------------CREATED-AT-------------CREATED-AT-------------CREATED-AT
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedAt")
	private Date createdAt;

//	UPDATED-AT-------------UPDATED-AT-------------UPDATED-AT-------------UPDATED-AT-------------UPDATED-AT-------------UPDATED-AT
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdatedAt")
	private Date updatedAt;
	    
	    
	    
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long cId) {
		courseId = cId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName){
		CourseName = courseName;
	}

	public String getCourseDetail() {
		return CourseDetail;
		
	}

	public void setCourseDetail(String courseDetail) {
		CourseDetail = courseDetail;
	}
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", CourseName=" + CourseName + ", CourseDetail=" + CourseDetail + ",CourseId=" + courseId +"]";
	}


	    @Column
		private boolean status =true;

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}


}





