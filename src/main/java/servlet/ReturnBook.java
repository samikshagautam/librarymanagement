package servlet;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books/return")
public class ReturnBook extends HttpServlet {
    BookService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Book book = service.getBookById(id);
            if (book == null) {
                throw new Exception("Book not found!");
            }
            service.returnBook(book);
            resp.getWriter().print("success");
        } catch (Exception e) {
            resp.getWriter().print(e.getMessage());
        }

    }


    @Override
    public void init() throws ServletException {
        service = new BookService();
    }
}
