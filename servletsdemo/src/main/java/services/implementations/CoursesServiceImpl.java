package services.implementations;

import models.entities.Course;
import models.service.CourseServiceModel;
import services.CoursesService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoursesServiceImpl implements CoursesService {
    private final EntityManager entityManager;

    @Inject
    public CoursesServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CourseServiceModel> getAllCourses() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class)
                .getResultList()
                .stream()
                .map(course -> {
                    CourseServiceModel model = new CourseServiceModel();
                    model.setName(course.getName());
                    model.setId(course.getId());
                    return model;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void createCourse(String name) {
        entityManager.getTransaction().begin();
        Course course = new Course();
        course.setName(name);
        entityManager.persist(course);

        entityManager.getTransaction().commit();
    }
}
