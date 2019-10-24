package web;

import models.view.HomeViewModel;
import services.courses.CoursesService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private final CoursesService coursesService;

    @Inject
    public HomeServlet(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeViewModel viewModel = new HomeViewModel();
        viewModel.setName("Pesho");
        viewModel.setCreatedOn(new Date());
        viewModel.setCourses(coursesService.getAllCourses());

        req.setAttribute("viewModel", viewModel);

        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);
    }
}
