package com.exp3.Exp3.services;

import com.exp3.Exp3.entities.Course;
import com.exp3.Exp3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl extends CourseService{
//    List<Course> list;
//
//    public CourseServiceImpl() {
//        list=new ArrayList<>();
//        list.add(new Course(333, "MICRO", "LEARN MICRO"));
//        list.add(new Course(222, "JAVA", "LEARN JAVA"));
//    }

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
//        return list;

        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(long  courseID){
//        Course c = null;
//        for(Course course : list){
//            if(course.getId() == courseID){
//                c = course;
//                break;
//            }
//        }
//        return c;

        return courseRepository.findById(courseID).orElse(null);
    }

    @Override
    public Course addCourse(Course course){
//        list.add(course);
//        return course;
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(long courseID, Course updatedCourse) {
//        for (int i = 0; i < list.size(); i++) {
//            Course course = list.get(i);
//            if (course.getId() == courseID) {
//                list.set(i, updatedCourse);
//                return updatedCourse;
//            }
//        }
//        return null;

        Optional<Course> existingCourse = courseRepository.findById(courseID);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public String deleteCourse(long courseID) {
//        for (int i = 0; i < list.size(); i++) {
//            Course course = list.get(i);
//            if (course.getId() == courseID) {
//                list.remove(i);
//                return "Course deleted successfully";
//            }
//        }
//        return "Course not found";

        if (courseRepository.existsById(courseID)) {
            courseRepository.deleteById(courseID);
            return "Course deleted successfully";
        }
        return "Course not found";
    }

    @Override
    public Course patchCourse(long courseId, Course updatedCourse) {
//        for (Course course : list) {
//            if (course.getId() == courseId) {
//                // Only update provided fields
//                if (updatedCourse.getTitle() != null) {
//                    course.setTitle(updatedCourse.getTitle());
//                }
//                if (updatedCourse.getDescription() != null) {
//                    course.setDescription(updatedCourse.getDescription());
//                }
//                return course;
//            }
//        }
//        return null;

        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            if (updatedCourse.getTitle() != null) {
                course.setTitle(updatedCourse.getTitle());
            }
            if (updatedCourse.getDescription() != null) {
                course.setDescription(updatedCourse.getDescription());
            }
            return courseRepository.save(course);
        }
        return null;
    }
}