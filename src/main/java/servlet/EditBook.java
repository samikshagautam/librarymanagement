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

@WebServlet("/books/edit")
public class EditBook extends HttpServlet {
    BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get bookId from url
        String id = req.getParameter("id");
        //fetch book details
        Book book = service.getBookById(id);
        //send the book to jsp
        req.setAttribute("book", book);
        System.out.println(book.getTitle());
        //load the view
        req.getRequestDispatcher("edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Book book = service.getBookById(id);
            if(book == null ){
                throw  new Exception("The selected book was not found");
            }
            //form data to entity
            Book book1 = RequestToEntity.toBook(req);
            service.updateBook(book,book1);
           //req.getRequestDispatcher("edit.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/books");
        } catch (Exception e) {
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }

    }
}
