package com.mitrais.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "mg_course", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "course_id"
        })
})
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_type")
	private String courseType;
	
	@Column(name="course_price_reg")
	private int coursePriceReg;
	
	@Column(name="course_price_bil")
	private int coursePriceBil;
	
	@Column(name="course_level")
	private String courseLevel;
	
	@Column(name="course_grade")
	private String courseGrade;
	
	@Column(name="course_category")
	private String courseCategory;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private Date createdDate;

	public Course(String courseName, String courseType, int coursePriceReg,int coursePriceBil, String courseLevel, String courseGrade,String courseCategory, String status, Date createdDate) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
		this.coursePriceReg = coursePriceReg;
		this.coursePriceBil = coursePriceBil;
		this.courseLevel = courseLevel;
		this.courseGrade = courseGrade;
		this.courseCategory = courseCategory;
		this.status = status;
		this.createdDate = createdDate;
	}
	
	public Course() {
		
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public int getCoursePriceReg() {
		return coursePriceReg;
	}

	public void setCoursePriceReg(int coursePriceReg) {
		this.coursePriceReg = coursePriceReg;
	}

	public int getCoursePriceBil() {
		return coursePriceBil;
	}

	public void setCoursePriceBil(int coursePriceBil) {
		this.coursePriceBil = coursePriceBil;
	}
	
	
}
