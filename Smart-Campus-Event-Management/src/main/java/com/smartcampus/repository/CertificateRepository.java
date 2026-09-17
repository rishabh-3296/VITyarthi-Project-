package com.smartcampus.repository;
import com.smartcampus.model.Certificate; import com.smartcampus.util.FileManager; import java.time.LocalDate; import java.util.*;
public class CertificateRepository {
    private final String file; private final Map<String,Certificate> data=new LinkedHashMap<>();
    public CertificateRepository(String file){this.file=file;load();}
    private void load(){List<String> lines=FileManager.read(file);for(int i=1;i<lines.size();i++){String[] p=lines.get(i).split(",",-1);if(p.length>=3)data.put(p[0],new Certificate(p[0],p[1],LocalDate.parse(p[2])));}}
    private void persist(){List<String> out=new ArrayList<>(List.of("id,registration_id,issue_date"));data.values().forEach(c->out.add(c.toCsv()));FileManager.write(file,out);}
    public List<Certificate> findAll(){return new ArrayList<>(data.values());}
    public Optional<Certificate> findById(String id){return Optional.ofNullable(data.get(id));}
    public Optional<Certificate> findByRegistrationId(String id){return data.values().stream().filter(c->c.getRegistrationId().equals(id)).findFirst();}
    public void save(Certificate c){data.put(c.getId(),c);persist();}
}
