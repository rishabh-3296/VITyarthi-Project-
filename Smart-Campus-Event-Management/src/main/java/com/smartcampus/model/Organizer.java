package com.smartcampus.model;
public class Organizer extends User {
    private String department;
    public Organizer(String id,String name,String email,String department){super(id,name,email);this.department=department;}
    public String getDepartment(){return department;}
}
