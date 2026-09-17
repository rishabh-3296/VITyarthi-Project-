package com.smartcampus.service;
import com.smartcampus.interfaces.Reportable; import com.smartcampus.enums.*; import java.util.*; import java.util.stream.*;
public class AnalyticsService implements Reportable {
    private final RegistrationService registrations;
    public AnalyticsService(RegistrationService r){registrations=r;}
    public Map<String,Long> participationByEvent(){return registrations.all().stream().filter(r->r.getStatus()==RegistrationStatus.ACTIVE).collect(Collectors.groupingBy(com.smartcampus.model.Registration::getEventId,LinkedHashMap::new,Collectors.counting()));}
    public long presentCount(){return registrations.all().stream().filter(r->r.getAttendance()==AttendanceStatus.PRESENT).count();}
    @Override public String generateReport(){
        StringBuilder b=new StringBuilder("=== PARTICIPATION REPORT ===\n");
        participationByEvent().forEach((id,n)->b.append(id).append(" -> ").append(n).append(" active registrations\n"));
        b.append("Total PRESENT attendance: ").append(presentCount()).append("\n");
        return b.toString();
    }
}
