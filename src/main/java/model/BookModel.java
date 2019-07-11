package model;

import entity.Book;
import org.bson.types.ObjectId;
import java.util.List;

public class BookModel implements Model<Book> {
    public Book save(Book book) {
        Db<Book> instance = new Db<>();
        if (book.getId() != null) {
            return instance.update(book, book.getId());
        }
        instance.insert(book);
        return book;
    }

    public List<Book> getAll() {
        Db<Book> instance = new Db<>();
        return instance.find(Book.class, "books");
    }

    public Book getById(String id) {
        Db<Book> instance = new Db<>();
        return instance.findOne(Book.class, new ObjectId(id));
    }

    public Book deleteById(Book book){
        Db<Book> instance = new Db<>();
        return instance.delete(book, book.getId());
    }
}
