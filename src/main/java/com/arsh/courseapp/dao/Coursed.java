package com.arsh.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arsh.courseapp.entity.Course;

public interface Coursed extends JpaRepository<Course,Long>
{

}
