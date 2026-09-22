package com.onlinelearning.model;
import jakarta.persistence.*;
@Entity @Table(name="users") public class User {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false,unique=true) private String username;
@Column(nullable=false,unique=true) private String email;
@Column(nullable=false) private String password;
@Enumerated(EnumType.STRING) private Role role=Role.STUDENT;
public User(){} public User(String u,String e,String p,Role r){username=u;email=e;password=p;role=r;}
public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public Role getRole(){return role;} public void setRole(Role v){role=v;}}
