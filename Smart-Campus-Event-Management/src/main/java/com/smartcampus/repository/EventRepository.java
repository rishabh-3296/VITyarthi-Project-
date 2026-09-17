package com.smartcampus.repository;
import com.smartcampus.model.Event; import com.smartcampus.enums.EventType; import com.smartcampus.util.FileManager; import java.time.LocalDate; import java.util.*;
public class EventRepository {
    private final String file; private final Map<String,Event> data=new LinkedHashMap<>();
    public EventRepository(String file){this.file=file;load();}
    private void load(){List<String> lines=FileManager.read(file);for(int i=1;i<lines.size();i++){String[] p=lines.get(i).split(",",-1);if(p.length>=5)data.put(p[0],new Event(p[0],p[1],EventType.valueOf(p[2]),LocalDate.parse(p[3]),Integer.parseInt(p[4])));}}
    private void persist(){List<String> out=new ArrayList<>(List.of("id,name,type,date,capacity"));data.values().forEach(e->out.add(e.toCsv()));FileManager.write(file,out);}
    public List<Event> findAll(){return new ArrayList<>(data.values());}
    public Optional<Event> findById(String id){return Optional.ofNullable(data.get(id));}
    public void save(Event e){data.put(e.getId(),e);persist();}
    public void delete(String id){data.remove(id);persist();}
}
