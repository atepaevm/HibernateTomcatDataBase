package main.java.dao;

import main.java.table.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 12 on 29.01.2017.
 */
public interface BookDao {
    public void addBook(Book book) throws SQLException;
    public void deleteBook(int id) throws SQLException;
    public Book getBook(int id)throws SQLException;
    public List<Book> getBooks()throws SQLException;
}
