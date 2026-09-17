package com.smartcampus.service;
import com.smartcampus.model.Registration; import com.smartcampus.enums.*; import com.smartcampus.repository.*; import com.smartcampus.exception.*; import com.smartcampus.util.IdGenerator; import java.util.*;
public class RegistrationService implements com.smartcampus.interfaces.Registrable {
    private final StudentRepository students; private final EventRepository events; private final RegistrationRepository registrations;
    public RegistrationService(StudentRepository s,EventRepository e,RegistrationRepository r){students=s;events=e;registrations=r;}
    @Override public String register(String studentId,String eventId){
        students.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student not found: "+studentId));
        var event=events.findById(eventId).orElseThrow(()->new EventNotFoundException("Event not found: "+eventId));
        if(registrations.findByStudentAndEvent(studentId,eventId).isPresent())throw new DuplicateRegistrationException("Student is already registered for this event.");
        long active=registrations.findAll().stream().filter(r->r.getEventId().equals(eventId)&&r.getStatus()==RegistrationStatus.ACTIVE).count();
        if(active>=event.getCapacity())throw new CapacityExceededException("Event capacity has been reached.");
        Registration r=new Registration(IdGenerator.next("REG"),studentId,eventId,RegistrationStatus.ACTIVE,AttendanceStatus.PENDING);registrations.save(r);return r.getId();
    }
    public void cancel(String id){Registration r=registrations.findById(id).orElseThrow(()->new IllegalArgumentException("Registration not found: "+id));r.setStatus(RegistrationStatus.CANCELLED);registrations.save(r);}
    public void attendance(String id,AttendanceStatus status){Registration r=registrations.findById(id).orElseThrow(()->new IllegalArgumentException("Registration not found: "+id));r.setAttendance(status);registrations.save(r);}
    public List<Registration> all(){return registrations.findAll();}
    public Registration get(String id){return registrations.findById(id).orElseThrow(()->new IllegalArgumentException("Registration not found: "+id));}
}
