package services;

import models.service.CourseServiceModel;

import java.util.List;

public interface CoursesService {
    List<CourseServiceModel> getAllCourses();

    void createCourse(String courseName);
}
