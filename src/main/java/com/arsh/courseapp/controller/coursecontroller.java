package com.arsh.courseapp.controller;
import com.arsh.courseapp.entity.Course;
import com.arsh.courseapp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class coursecontroller
{
    @Autowired
    private CourseService  crs ;

    @GetMapping("/home")
    public String home()
    {
        return "Welcome To my CoursesApp !" ;
    }
    //get courses
    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.crs.getCourses();

    }
    //get course acc to id
    @GetMapping("/courses/{courseid}")
    public Course getCourse(@PathVariable String courseid)
    {
        return this.crs.getCourse(Long.parseLong(courseid));

    }
    //add new course
    @PostMapping(path = "/courses" , consumes = "application/json")
    public Course addcourse(@RequestBody Course course)
    {
         return this.crs.addCourse(course) ;
    }
    //update given course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return this.crs.updateCourse(course) ;
    }
    //delete given course.
    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseid)
    {
        try {
            this.crs.deleteCourse(Long.parseLong(courseid));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
