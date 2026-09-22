package com.onlinelearning.model;
import jakarta.persistence.*;
@Entity public class Course {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String title; @Column(length=2000) private String description; private String category;
@ManyToOne @JoinColumn(name="instructor_id") private User instructor;
public Course(){} public Course(String t,String d,String c,User i){title=t;description=d;category=c;instructor=i;} public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public User getInstructor(){return instructor;} }
