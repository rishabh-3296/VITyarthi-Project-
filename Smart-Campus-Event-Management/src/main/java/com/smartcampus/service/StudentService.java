package com.smartcampus.service;
import com.smartcampus.model.Student; import com.smartcampus.repository.StudentRepository; import com.smartcampus.exception.StudentNotFoundException; import com.smartcampus.util.*; import java.util.*;
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo){this.repo=repo;}
    public Student add(String name,String email,String program){Student s=new Student(IdGenerator.next("STU"),InputValidator.required(name,"Name"),InputValidator.required(email,"Email"),InputValidator.required(program,"Program"));repo.save(s);return s;}
    public List<Student> all(){return repo.findAll();}
    public Student get(String id){return repo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found: "+id));}
    public void update(String id,String name,String email,String program){Student s=get(id);s.setName(InputValidator.required(name,"Name"));s.setEmail(InputValidator.required(email,"Email"));s.setProgram(InputValidator.required(program,"Program"));repo.save(s);}
    public void delete(String id){get(id);repo.delete(id);}
    public List<Student> search(String key){String k=key.toLowerCase();return repo.findAll().stream().filter(s->s.getId().toLowerCase().contains(k)||s.getName().toLowerCase().contains(k)||s.getEmail().toLowerCase().contains(k)).toList();}
}
