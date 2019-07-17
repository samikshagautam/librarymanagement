package filters;


import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getServletPath();
        //allow user access login page without
        //logging in

        if (path.equals("/login") || path.endsWith(".css")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = req.getSession();
        //If user session is empty
        //force user to login
        if (session.getAttribute("user") == null) {
            System.out.println("User session is not set");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        //check if the user in session actually exists in our
        User user = (User) session.getAttribute("user");
        try {

            if (!user.getEmail().equals("jon@doe.com")) {
                throw new Exception("User does not exist.");
            }
            filterChain.doFilter(req, resp);

        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
