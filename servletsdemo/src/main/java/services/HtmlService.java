package services;

import models.service.CourseServiceModel;

import java.util.List;

public interface HtmlService {
    String getCoursesList(List<CourseServiceModel> course);

    String getCreateCourseForm();
}
