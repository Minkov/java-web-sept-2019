import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ViewHttpServlet extends HttpServlet {
    private static final String CONTENT_TYPE_HTML = "text/html";
    protected void setHtmtContentType(HttpServletResponse resp) {
        resp.setContentType(CONTENT_TYPE_HTML);
    }
}
