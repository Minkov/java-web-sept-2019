package models.view;

import models.service.CourseServiceModel;

import java.util.Date;
import java.util.List;

public class HomeViewModel {
    private String name;
    private Date createdOn;
    private List<CourseServiceModel> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setCourses(List<CourseServiceModel> courses) {
        this.courses = courses;
    }

    public List<CourseServiceModel> getCourses() {
        return courses;
    }
}
