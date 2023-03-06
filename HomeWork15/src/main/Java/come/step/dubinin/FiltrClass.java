package come.step.dubinin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = ("/shop.jsp"))

public class FiltrClass implements  Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain ch)
            throws IOException, ServletException {
        HttpServletRequest reqest = (HttpServletRequest) req;

        if (reqest.getSession().getAttribute("check") == null) {
            if (reqest.getParameter("check") == null) {
                String path = "/eror.jsp";
                ServletContext servletContext = reqest.getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(reqest, resp);
            }else {
                reqest.getSession().setAttribute("check",reqest.getParameter("check"));
                reqest.getSession().setAttribute("name", req.getParameter("userName"));
            }

        }

        ch.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
