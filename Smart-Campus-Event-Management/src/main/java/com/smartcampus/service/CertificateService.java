package com.smartcampus.service;
import com.smartcampus.model.Certificate; import com.smartcampus.enums.AttendanceStatus; import com.smartcampus.repository.CertificateRepository; import com.smartcampus.util.IdGenerator; import java.time.LocalDate; import java.util.*;
public class CertificateService {
    private final CertificateRepository repo; private final RegistrationService registrations;
    public CertificateService(CertificateRepository r,RegistrationService rs){repo=r;registrations=rs;}
    public Certificate generate(String registrationId){
        var r=registrations.get(registrationId);
        if(r.getAttendance()!=AttendanceStatus.PRESENT)throw new IllegalStateException("Certificate requires PRESENT attendance.");
        return repo.findByRegistrationId(registrationId).orElseGet(()->{Certificate c=new Certificate(IdGenerator.next("CERT"),registrationId,LocalDate.now());repo.save(c);return c;});
    }
    public List<Certificate> all(){return repo.findAll();}
}
