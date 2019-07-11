package servlet;

import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books/borrow")
public class BorrowBook extends HttpServlet {
    BookService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().print("success");
        } catch (Exception e) {
            resp.getWriter().print("error!");
        }
    }

    @Override
    public void init() throws ServletException {
        service = new BookService();
    }
}
