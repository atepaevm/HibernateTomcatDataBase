package main.java.business;

import main.java.dao.impl.BookDaoImpl;
import main.java.table.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 12 on 01.02.2017.
 */
public class GetBooks extends BasicGetBooks{
    private BookDaoImpl bookDao=new BookDaoImpl();
    public List<Book> getBooks() {
        try {
            return bookDao.getBooks();
        } catch (SQLException e) {
            return null;
        }
    }
}
