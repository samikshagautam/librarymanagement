package servlet;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books/borrowing")
public class Borrowing extends HttpServlet {
    BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            String id = req.getParameter("id");
            Book book = service.getBookById(id);
            req.setAttribute("book", book);

            req.getRequestDispatcher("borrowing.jsp").forward(req,resp);


        }catch (Exception e){

        }

    }
}
