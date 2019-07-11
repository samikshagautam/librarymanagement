package servlet;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {
    BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = service.getAllBooks();
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("books/lists.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("add a book");
    }
}
