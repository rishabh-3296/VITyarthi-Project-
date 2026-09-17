package com.smartcampus;
import com.smartcampus.repository.*; import com.smartcampus.service.*; import org.junit.jupiter.api.*; import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
class StudentServiceTest {
 @Test void studentCanBeAddedAndFound() throws Exception {
  Path p=Files.createTempDirectory("student-test").resolve("students.csv");
  StudentService s=new StudentService(new StudentRepository(p.toString()));
  var created=s.add("Test User","test@example.com","BCA");
  assertEquals(created.getId(),s.get(created.getId()).getId());
  assertEquals(1,s.search("test@example.com").size());
 }
}
