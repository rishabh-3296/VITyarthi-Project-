package com.smartcampus.model;
import com.smartcampus.enums.*;
public class Registration {
    private final String id, studentId, eventId;
    private RegistrationStatus status; private AttendanceStatus attendance;
    public Registration(String id,String studentId,String eventId,RegistrationStatus status,AttendanceStatus attendance){this.id=id;this.studentId=studentId;this.eventId=eventId;this.status=status;this.attendance=attendance;}
    public String getId(){return id;} public String getStudentId(){return studentId;} public String getEventId(){return eventId;}
    public RegistrationStatus getStatus(){return status;} public AttendanceStatus getAttendance(){return attendance;}
    public void setStatus(RegistrationStatus s){status=s;} public void setAttendance(AttendanceStatus a){attendance=a;}
    public String toCsv(){return String.join(",",id,studentId,eventId,status.name(),attendance.name());}
    @Override public String toString(){return id+" | student="+studentId+" | event="+eventId+" | "+status+" | "+attendance;}
}
