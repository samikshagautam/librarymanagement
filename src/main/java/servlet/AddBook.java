package servlet;

import entity.Book;
import helper.RequestToEntity;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books/add")
public class AddBook extends HttpServlet {

    private BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Book book = RequestToEntity.toBook(req);
            service.addBook(book);
            resp.sendRedirect(req.getContextPath() + "/books");
        } catch (Exception e) {
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        }
    }
}
