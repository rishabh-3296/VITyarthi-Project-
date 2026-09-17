package com.smartcampus.repository;
import com.smartcampus.model.Registration; import com.smartcampus.enums.*; import com.smartcampus.util.FileManager; import java.util.*;
public class RegistrationRepository {
    private final String file; private final Map<String,Registration> data=new LinkedHashMap<>();
    public RegistrationRepository(String file){this.file=file;load();}
    private void load(){List<String> lines=FileManager.read(file);for(int i=1;i<lines.size();i++){String[] p=lines.get(i).split(",",-1);if(p.length>=5)data.put(p[0],new Registration(p[0],p[1],p[2],RegistrationStatus.valueOf(p[3]),AttendanceStatus.valueOf(p[4])));}}
    private void persist(){List<String> out=new ArrayList<>(List.of("id,student_id,event_id,status,attendance"));data.values().forEach(r->out.add(r.toCsv()));FileManager.write(file,out);}
    public List<Registration> findAll(){return new ArrayList<>(data.values());}
    public Optional<Registration> findById(String id){return Optional.ofNullable(data.get(id));}
    public Optional<Registration> findByStudentAndEvent(String s,String e){return data.values().stream().filter(r->r.getStudentId().equals(s)&&r.getEventId().equals(e)&&r.getStatus()==RegistrationStatus.ACTIVE).findFirst();}
    public void save(Registration r){data.put(r.getId(),r);persist();}
}
