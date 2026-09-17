package com.smartcampus;
import com.smartcampus.model.*; import com.smartcampus.enums.*; import com.smartcampus.repository.*; import com.smartcampus.service.*; import com.smartcampus.exception.*; import org.junit.jupiter.api.*; import java.nio.file.*; import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class RegistrationServiceTest {
    Path dir;
    @BeforeEach void setup() throws Exception {dir=Files.createTempDirectory("campus-test");}
    @Test void duplicateRegistrationIsRejected(){
        StudentRepository sr=new StudentRepository(dir+"/students.csv"); EventRepository er=new EventRepository(dir+"/events.csv"); RegistrationRepository rr=new RegistrationRepository(dir+"/registrations.csv");
        StudentService ss=new StudentService(sr); EventService es=new EventService(er); RegistrationService rs=new RegistrationService(sr,er,rr);
        Student s=ss.add("A","a@x.com","BCA"); Event e=es.create("Test",EventType.TECHNICAL,LocalDate.now(),2);
        rs.register(s.getId(),e.getId());
        assertThrows(DuplicateRegistrationException.class,()->rs.register(s.getId(),e.getId()));
    }
    @Test void capacityIsEnforced(){
        StudentRepository sr=new StudentRepository(dir+"/students.csv"); EventRepository er=new EventRepository(dir+"/events.csv"); RegistrationRepository rr=new RegistrationRepository(dir+"/registrations.csv");
        StudentService ss=new StudentService(sr); EventService es=new EventService(er); RegistrationService rs=new RegistrationService(sr,er,rr);
        Student s1=ss.add("A","a@x.com","BCA"); Student s2=ss.add("B","b@x.com","BCA"); Event e=es.create("Test",EventType.TECHNICAL,LocalDate.now(),1);
        rs.register(s1.getId(),e.getId());
        assertThrows(CapacityExceededException.class,()->rs.register(s2.getId(),e.getId()));
    }
}
