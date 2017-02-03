package main.java.business;

import main.java.dao.impl.BookDaoImpl;
import main.java.table.Book;

/**
 * Created by 12 on 01.02.2017.
 */
public class GetBook extends BasicGetBook {
    private BookDaoImpl bookDao=new BookDaoImpl();
     public Book getBook(int id){
        Book book=null;
        if(id>=0){
            //id may be correct
            try {
                book=bookDao.getBook(id);
                book.getTitle();
            } catch (Exception e) {
                System.out.println("Жаль");
                return null;
            }
            return book;
        }
        return null;
    }
}
