package com.smartcampus.repository;
import com.smartcampus.model.Student; import com.smartcampus.util.FileManager; import java.util.*;
public class StudentRepository {
    private final String file; private final Map<String,Student> data=new LinkedHashMap<>();
    public StudentRepository(String file){this.file=file;load();}
    private void load(){List<String> lines=FileManager.read(file); for(int i=1;i<lines.size();i++){String[] p=lines.get(i).split(",",-1);if(p.length>=4)data.put(p[0],new Student(p[0],p[1],p[2],p[3]));}}
    private void persist(){List<String> out=new ArrayList<>(List.of("id,name,email,program"));data.values().forEach(s->out.add(s.toCsv()));FileManager.write(file,out);}
    public List<Student> findAll(){return new ArrayList<>(data.values());}
    public Optional<Student> findById(String id){return Optional.ofNullable(data.get(id));}
    public void save(Student s){data.put(s.getId(),s);persist();}
    public void delete(String id){data.remove(id);persist();}
}
