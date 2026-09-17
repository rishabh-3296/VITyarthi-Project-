package com.smartcampus.model;
import java.time.LocalDate;
public class Certificate {
    private final String id, registrationId; private final LocalDate issueDate;
    public Certificate(String id,String registrationId,LocalDate issueDate){this.id=id;this.registrationId=registrationId;this.issueDate=issueDate;}
    public String getId(){return id;} public String getRegistrationId(){return registrationId;} public LocalDate getIssueDate(){return issueDate;}
    public String toCsv(){return String.join(",",id,registrationId,issueDate.toString());}
    @Override public String toString(){return id+" | registration="+registrationId+" | issued="+issueDate;}
}
