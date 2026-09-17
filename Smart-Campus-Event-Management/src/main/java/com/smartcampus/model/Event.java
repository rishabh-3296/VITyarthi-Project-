package com.smartcampus.model;
import com.smartcampus.enums.EventType;
import java.time.LocalDate;
public class Event {
    private final String id; private String name; private EventType type; private LocalDate date; private int capacity;
    public Event(String id,String name,EventType type,LocalDate date,int capacity){this.id=id;this.name=name;this.type=type;this.date=date;this.capacity=capacity;}
    public String getId(){return id;} public String getName(){return name;} public EventType getType(){return type;} public LocalDate getDate(){return date;} public int getCapacity(){return capacity;}
    public void setName(String n){name=n;} public void setType(EventType t){type=t;} public void setDate(LocalDate d){date=d;} public void setCapacity(int c){capacity=c;}
    public String toCsv(){return String.join(",",id,name,type.name(),date.toString(),String.valueOf(capacity));}
    @Override public String toString(){return id+" | "+name+" | "+type+" | "+date+" | capacity="+capacity;}
}
