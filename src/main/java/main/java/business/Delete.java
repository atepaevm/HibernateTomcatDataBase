package main.java.business;

import main.java.dao.impl.BookDaoImpl;
import main.java.table.Book;

import java.sql.SQLException;

/**
 * Created by 12 on 01.02.2017.
 */
public class Delete extends BasicDelete {
    private BookDaoImpl bookDao=new BookDaoImpl();
    @Override
    public int delete(int id) {
        Book book=null;
        try {
            book=(new BookDaoImpl()).getBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(book==null){
            return -1;
        }
        try {
            bookDao.deleteBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
