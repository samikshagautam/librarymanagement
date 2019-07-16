package service;

import entity.Book;
import model.BookModel;

import java.time.LocalDate;
import java.util.List;

public class BookService {
    BookModel model;

    public BookService() {
        model = new BookModel();
    }

    public Book addBook(Book book) throws Exception {
        if (book.getTitle() == null) {
            throw new Exception("Title is empty!");
        }
        if (book.getAuthor() == null) {
            throw new Exception("Title is empty!");
        }
        if (book.getEdition() == null) {
            throw new Exception("Title is empty!");
        }
        if (book.getIsbn() == null) {
            throw new Exception("Title is empty!");
        }
        if (book.getPrice() == 0) {
            throw new Exception("Title is empty!");
        }

        return model.save(book);
    }

    public List<Book> getAllBooks() {
        return model.getAll();
    }

    public Book getBookById(String id) {
        return model.getById(id);

    }

    public Book updateBook(Book oldBook, Book newBook) throws Exception {
        if (newBook.getTitle() == null) {
            throw new Exception("Title is Empty!");
        }
        if (newBook.getAuthor() == null) {
            throw new Exception("Author is Empty");
        }
        if (newBook.getPrice() == 0) {
            throw new Exception("Price is Empty!");

        }
        if (newBook.getEdition() == null) {
            throw new Exception("Edition is Empty!");
        }

        if (newBook.getIsbn() == null) {
            throw new Exception("Isbn is Empty!");
        }

        newBook.setId(oldBook.getId());
        return model.save(newBook);
    }

    public Book deleteBook(Book book) throws  Exception{
        return model.deleteById(book);
    }

    public Book borrowBook(Book book) throws  Exception{
        if(book.isStatus() == false){
            throw  new Exception("Book is unavailable at this moment");
        }
        book.setStatus(false);
        book.setStudentName("Samikshya");
        book.setStudentEmail("samikshyagautam5@gmail.com");
        book.setStudentPhone("98287328");
        book.setBorrowDate(LocalDate.now());
        book.setReturnDate(LocalDate.now().plusDays(4));

        return model.save(book);

    }

    public Book returnBook(Book book) throws Exception{
        if(book.isStatus()==true){
            throw new Exception("Book hasn't been borrowed yet!");
        }

        book.setStatus(true);
        book.setStudentName(null);
        book.setStudentEmail(null);
        book.setStudentPhone(null);
        book.setBorrowDate(null);
        book.setReturnDate(null);

        return model.save(book);


    }

}
