package com.smartcampus.service;
import com.smartcampus.model.Event; import com.smartcampus.enums.EventType; import com.smartcampus.repository.EventRepository; import com.smartcampus.exception.EventNotFoundException; import com.smartcampus.util.*; import java.time.LocalDate; import java.util.*;
public class EventService {
    private final EventRepository repo;
    public EventService(EventRepository repo){this.repo=repo;}
    public Event create(String name,EventType type,LocalDate date,int cap){Event e=new Event(IdGenerator.next("EVT"),InputValidator.required(name,"Event name"),type,date,cap);repo.save(e);return e;}
    public List<Event> all(){return repo.findAll();}
    public Event get(String id){return repo.findById(id).orElseThrow(()->new EventNotFoundException("Event not found: "+id));}
    public void update(String id,String name,EventType type,LocalDate date,int cap){Event e=get(id);e.setName(InputValidator.required(name,"Event name"));e.setType(type);e.setDate(date);e.setCapacity(cap);repo.save(e);}
    public void delete(String id){get(id);repo.delete(id);}
    public List<Event> search(String key){String k=key.toLowerCase();return repo.findAll().stream().filter(e->e.getId().toLowerCase().contains(k)||e.getName().toLowerCase().contains(k)||e.getType().name().toLowerCase().contains(k)).toList();}
}
