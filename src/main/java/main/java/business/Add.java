package main.java.business;

import main.java.dao.impl.BookDaoImpl;
import main.java.table.Book;

import java.sql.SQLException;

/**
 * Created by 12 on 01.02.2017.
 */
public class Add extends BasicAdd{
    private BookDaoImpl bookDao=new BookDaoImpl();
    @Override
    public int add(Book book) {
        if(Character.isUpperCase(book.getTitle().charAt(0))){
            //title is correct
            try {
                bookDao.addBook(book);
            } catch (SQLException e) {
                return -2;
            }
            return 0;
        }
        return -1;
    }
}
