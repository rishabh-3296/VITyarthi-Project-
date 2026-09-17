package com.smartcampus;
import com.smartcampus.repository.*; import com.smartcampus.service.*; import com.smartcampus.ui.MainMenu;
public class Main {
    public static void main(String[] args){
        String base="data/";
        StudentRepository sr=new StudentRepository(base+"students.csv");
        EventRepository er=new EventRepository(base+"events.csv");
        RegistrationRepository rr=new RegistrationRepository(base+"registrations.csv");
        CertificateRepository cr=new CertificateRepository(base+"certificates.csv");
        StudentService ss=new StudentService(sr); EventService es=new EventService(er);
        RegistrationService rs=new RegistrationService(sr,er,rr);
        CertificateService cs=new CertificateService(cr,rs); AnalyticsService as=new AnalyticsService(rs);
        new MainMenu(ss,es,rs,cs,as).start();
    }
}
