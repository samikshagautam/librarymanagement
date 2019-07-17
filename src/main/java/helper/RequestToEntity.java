package helper;

import entity.Book;
import entity.User;

import javax.servlet.http.HttpServletRequest;

public class RequestToEntity {

    public static Book toBook(HttpServletRequest req){
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String isbn = req.getParameter("isbn");
        String edition = req.getParameter("edition");
        double price = Double.valueOf(req.getParameter("price"));

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setEdition(edition);
        book.setPrice(price);

        return book;
    }

    public static User toUser(HttpServletRequest req){
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
