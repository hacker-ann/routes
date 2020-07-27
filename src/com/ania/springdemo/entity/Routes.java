package com.ania.springdemo.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="routes")
public class Routes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="route_name")
	private String routeName;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="country")
	private String country;
	
	@Column(name="climbing_area")
	private String climbingArea;
	
	@Column(name="crag_or_sector")
	private String cragOrSector;
	
	@Column(name="style")
	private String style;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_of_ascent")
	private Date date;
	
	@Column(name="note")
	private String comment;

	public Routes() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getClimbingArea() {
		return climbingArea;
	}

	public void setClimbingArea(String climbingArea) {
		this.climbingArea = climbingArea;
	}

	public String getCragOrSector() {
		return cragOrSector;
	}

	public void setCragOrSector(String cragOrSector) {
		this.cragOrSector = cragOrSector;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Routes [id=" + id + ", routeName=" + routeName + ", grade=" + grade + ", country=" + country
				+ ", climbingArea=" + climbingArea + ", cragOrSector=" + cragOrSector + ", style=" + style + ", date="
				+ date + ", comment=" + comment + "]";
	}
	
	
}
