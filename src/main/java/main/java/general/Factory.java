package main.java.general;

import main.java.dao.BookDao;
import main.java.dao.impl.BookDaoImpl;

/**
 * Created by 12 on 29.01.2017.
 */
public class Factory {
    public static Factory instance=new Factory();
    public BookDao bookDao;

    private Factory(){}
    public static Factory getInstance(){
        return Factory.instance;
    }
    public BookDao getBookDao(){
        if(bookDao==null){
            bookDao=new BookDaoImpl();

        }
        return bookDao;
    }
}
