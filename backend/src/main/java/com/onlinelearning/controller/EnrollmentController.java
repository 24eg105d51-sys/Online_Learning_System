package com.onlinelearning.controller;
import com.onlinelearning.model.*; import com.onlinelearning.repository.*; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.util.List;
@RestController @RequestMapping("/api/enrollments") public class EnrollmentController {
 private final EnrollmentRepository es; private final UserRepository us; private final CourseRepository cs;
 public EnrollmentController(EnrollmentRepository e,UserRepository u,CourseRepository c){es=e;us=u;cs=c;}
 public record Request(Long courseId){} public record Progress(int progress){}
 @PostMapping public Enrollment enroll(@RequestBody Request r, Authentication a){
  User u=us.findByUsername(a.getName()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
  if(es.existsByStudentIdAndCourseId(u.getId(),r.courseId()))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Already enrolled");
  Course c=cs.findById(r.courseId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found"));
  return es.save(new Enrollment(u,c));
 }
 @GetMapping("/student/{id}") public List<Enrollment> list(@PathVariable Long id,Authentication a){if(!us.findByUsername(a.getName()).map(u->u.getId().equals(id)).orElse(false))throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Access denied");return es.findByStudentId(id);}
 @PutMapping("/{id}/progress") public Enrollment progress(@PathVariable Long id,@RequestBody Progress p,Authentication a){
  Enrollment e=es.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Enrollment not found"));
  if(!e.getStudent().getUsername().equals(a.getName()))throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Access denied");
  e.setProgress(p.progress());return es.save(e);
 }
}