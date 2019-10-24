package filters;

import services.DatesService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.MessageFormat;

@WebFilter(urlPatterns = { "/courses/*", "/*" })
public class LoggingFilter implements Filter {
    private final DatesService datesService;

    @Inject
    public LoggingFilter(DatesService datesService) {
        this.datesService = datesService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String date = datesService.getNowFormatted();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String method = request.getMethod();

        String result =
                MessageFormat.format(
                        "[{0}]: {1} -> {2} {3}",
                        date,
                        ip,
                        url,
                        method
                );
        System.out.println(result);
        filterChain.doFilter(request, servletResponse);
    }
}
