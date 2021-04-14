package com.arsh.courseapp.services;

import com.arsh.courseapp.dao.Coursed;
import com.arsh.courseapp.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private Coursed crd;
   // List<Course> list;
    public CourseServiceImpl()
    {
        /*list = new ArrayList<>();
        list.add(new Course(145 , "Java" , "This is a Java Core oriented Course"));
        list.add(new Course(146 , "Spring Boot" , "This is a Spring Boot oriented Course"));
*/
    }

    @Override
    public List<Course> getCourses()
    {
        return crd.findAll();
    }

    @Override
    public Course getCourse(long courseid)
    {
      /* Course c = null ;
        for(Course course:list)
        {
            if(course.getId()==courseid)
            {
                c =course;
                break;
            } */

        return crd.getOne(courseid);

    }
    @Override
    public Course addCourse(Course course)
    {
       // list.add(course);
        crd.save(course);
        return course ;
    }

    @Override
    public Course updateCourse(Course course)
    {
       /* list.forEach ( e -> {
            if (e.getId() == course.getId())
            {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        }); */
        crd.save(course);
        return course ;
    }

    @Override
    public void deleteCourse(long parseLong)
    {

       // list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList()) ;
        Course entity = crd.getOne(parseLong);
        crd.delete(entity);
    }

}






