package com.exp3.Exp3.controller;

import com.exp3.Exp3.entities.Course;
import com.exp3.Exp3.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    //Get the courses with ID
    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return this.courseService.getCourse(Long.parseLong(courseID));
    }

    //Add the courses
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    // Update a course by ID
    @PutMapping("/courses/{courseID}")
    public Course updateCourse(@PathVariable String courseID, @RequestBody Course updatedCourse) {
        return this.courseService.updateCourse(Long.parseLong(courseID), updatedCourse);
    }

    // Delete a course by ID
    @DeleteMapping("/courses/{courseID}")
    public String deleteCourse(@PathVariable String courseID) {
        return this.courseService.deleteCourse(Long.parseLong(courseID));
    }

    // PATCH: Partially update a course
    @PatchMapping("/courses/{courseID}")
    public Course patchCourse(@PathVariable long courseID, @RequestBody Course updatedCourse) {
        return this.courseService.patchCourse(courseID, updatedCourse);
    }
}
