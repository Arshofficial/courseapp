package com.arsh.courseapp.services;

import com.arsh.courseapp.entity.Course;

import java.util.List;

public interface CourseService
{
  List<Course> getCourses();
  Course getCourse(long courseid) ;
  Course addCourse(Course course);
  Course updateCourse(Course course);
  void deleteCourse(long parseLong);


}
