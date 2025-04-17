package com.exp3.Exp3.services;

import com.exp3.Exp3.entities.Course;

import java.util.List;

public abstract class CourseService {
    public abstract List<Course> getCourses();
    public abstract Course getCourse(long courseId);
    public abstract Course addCourse(Course course);
    public abstract Course updateCourse(long courseId, Course updatedCourse);
    public abstract String deleteCourse(long courseId);
    public abstract Course patchCourse(long courseId, Course updatedCourse);
}