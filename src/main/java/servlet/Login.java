package servlet;

import entity.User;
import helper.RequestToEntity;
import service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    AuthService service;

    @Override
    public void init() throws ServletException {
        service = new AuthService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = RequestToEntity.toUser(req);
            service.loginUser(user, req.getSession());
            resp.sendRedirect(req.getContextPath() + "/books");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
