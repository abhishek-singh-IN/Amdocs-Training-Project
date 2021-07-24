package com.amdocs.main;

public class Course {
	int Course_id;
	String Course_name;
	String Courser_esource;
	String Course_desc;
	String Course_fee;
	
	public int getCourse_id() {
		return Course_id;
	}

	public Course(int course_id) {
		super();
		Course_id = course_id;
	}

	public Course(String course_name, String courser_esource, String course_desc, String course_fee) {
		super();
		Course_name = course_name;
		Courser_esource = courser_esource;
		Course_desc = course_desc;
		Course_fee = course_fee;
	}
	
	public int addCourse() {
		
		//Add course to PL/SQL database
		
		//Set Course id Returned From PL/SQL Database
		
		return Course_id;
	}
	
	public void enrollCourse(int user_id,int Course_id) {
		
		// Enroll Course based on user_id and cours_id in Database
		
	}
	
}
