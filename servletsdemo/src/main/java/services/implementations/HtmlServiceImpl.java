package services.implementations;

import models.service.CourseServiceModel;
import services.HtmlService;

import java.util.List;
import java.util.function.Function;

public class HtmlServiceImpl implements HtmlService {
    @Override
    public String getCoursesList(List<CourseServiceModel> courses) {
        return this.getList(courses, this::toCourseItem);
    }

    @Override
    public String getCreateCourseForm() {
        return "<form method='post' action='/courses'>" +
                "   <label>" +
                "       Name: " +
                "       <input name='name' type='text' />" +
                "   </label>" +
                "   <button>Create</button>" +
                "</form>";
    }

    private String toCourseItem(CourseServiceModel course) {
        return String.format("<li>%s</li>", course.getName());
    }

    private <T> String getList(
            List<T> collection,
            Function<T, String> itemFunc) {
        StringBuilder builder = new StringBuilder();
        collection.forEach(item -> {
            String html = itemFunc.apply(item);
            builder.append(html);
        });

        return String.format("<ul>%s</ul>", builder.toString());
    }
}
