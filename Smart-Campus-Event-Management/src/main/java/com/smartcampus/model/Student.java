package com.smartcampus.model;
public class Student extends User {
    private String program;
    public Student(String id,String name,String email,String program){super(id,name,email);this.program=program;}
    public String getProgram(){return program;} public void setProgram(String p){program=p;}
    public String toCsv(){return String.join(",", getId(),getName(),getEmail(),program);}
    @Override public String toString(){return getId()+" | "+getName()+" | "+getEmail()+" | "+program;}
}
