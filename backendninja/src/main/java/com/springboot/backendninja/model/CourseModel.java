package com.springboot.backendninja.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CourseModel {

	@NotNull
	@Size(min=4, max=4)
	private String codCourse;
	@NotNull
	private String descripCourse;

	public CourseModel(String codCourse, String descripCourse) {
		super();
		this.codCourse = codCourse;
		this.descripCourse = descripCourse;
	}

	public CourseModel() {

	}

	public String getCodCourse() {
		return codCourse;
	}

	public void setCodCourse(String codCourse) {
		this.codCourse = codCourse;
	}

	public String getDescripCourse() {
		return descripCourse;
	}

	public void setDescripCourse(String descripCourse) {
		this.descripCourse = descripCourse;
	}

	@Override
	public String toString() {
		return "[codCourse=" + codCourse + ", descripCourse=" + descripCourse + "]";
	}

}
