package main.java.dao.impl;

import main.java.dao.BookDao;
import main.java.table.Book;
import main.java.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

//import static main.java.util.HibernateUtil.*;

/**
 * Created by 12 on 29.01.2017.
 */
public class BookDaoImpl implements BookDao {

    @Override
    public void addBook(Book book) throws SQLException {
        Session session=null;
        try{
            session= (new HibernateUtil()).getSessionFactory().openSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();


            Book book=(Book)session.get(Book.class,id);




            session.delete(book);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null&&session.isOpen()){
                //session.flush();
                session.close();
            }
        }
    }

    @Override
    public Book getBook(int id) throws SQLException {
        Book result=null;
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            result=(Book)session.load(Book.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }


        return result;
    }

    @Override
    public List<Book> getBooks() throws SQLException {
        List<Book> books=null;
        Session session=null;
        try{
            session= (new HibernateUtil()).getSessionFactory().openSession();
            books=session.createCriteria(Book.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return books;
    }
}
