package main.java.general;

import main.java.business.*;
import main.java.dao.impl.BookDaoImpl;
import main.java.model.Developer;
import main.java.table.Book;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 12 on 29.01.2017.
 */
@Controller
public class Project {
    private static BasicAdd basicAdd;
    private static BasicDelete basicDelete;
    private static BasicGetBook basicGetBook;
    private static BasicGetBooks basicGetBooks;

    @RequestMapping(value = "/")
    public String showHomePage(Map<String,List<Book>> model) {
        Factory factory=Factory.getInstance();
        Book bookx=new Book();
        bookx.setDescription("321");
        bookx.setTitle("Ayz");
        bookx.setIsbn(1917);
        ApplicationContext context=new FileSystemXmlApplicationContext("C:\\Users\\12\\Desktop\\ProselyteSpringMVC\\ProselyteSpringMVC\\src\\main\\java\\main\\java\\general\\general.xml");
        BeanFactory factory1 =(BeanFactory)context;
        Project project=(Project)factory1.getBean("generalProject");
        //project.getBasicAdd().add(bookx);
        BookDaoImpl bookDao=new BookDaoImpl();
        List<Book> books=project.basicGetBooks.getBooks();
        for(Book book:books){
            System.out.println(book.getId()+"   "+book.getIsbn()+"  "+
                    book.getTitle()+"   "+
                    book.getDescription());
        }


        return "/index";
    }
    @RequestMapping(value = "developer")
    public ModelAndView developer() {return new ModelAndView("developer", "command", new Developer());
    }

    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("mvc-dispatcher") Developer developer,
                             ModelMap model) {
        model.addAttribute("id", developer.getId());
        model.addAttribute("name", developer.getName());
        model.addAttribute("specialty", developer.getSpecialty());
        model.addAttribute("experience", developer.getExperience());

        return "result";
    }


    public static void main(String[] args)throws SQLException{
        Factory factory=Factory.getInstance();
        Book bookx=new Book();
        bookx.setDescription("321");
        bookx.setTitle("Ayz");
        bookx.setIsbn(1917);
        ApplicationContext context=new FileSystemXmlApplicationContext("C:\\Users\\12\\Desktop\\ProselyteSpringMVC\\ProselyteSpringMVC\\src\\main\\java\\main\\java\\general\\general.xml");
        BeanFactory factory1 =(BeanFactory)context;
        Project project=(Project)factory1.getBean("generalProject");
        project.getBasicAdd().add(bookx);
        project.getBasicDelete().delete(14);
        List<Book> books=project.basicGetBooks.getBooks();
        for(Book book:books){
            System.out.println(book.getId()+"   "+book.getIsbn()+"  "+
            book.getTitle()+"   "+
            book.getDescription());
        }

    }

    public void setBasicAdd(BasicAdd basicAdd) {
        this.basicAdd = basicAdd;
    }

    public BasicAdd getBasicAdd() {
        return basicAdd;
    }

    public void setBasicDelete(BasicDelete basicDelete) {
        this.basicDelete = basicDelete;
    }

    public BasicDelete getBasicDelete() {
        return basicDelete;
    }

    public void setBasicGetBook(BasicGetBook basicGetBook) {
        this.basicGetBook = basicGetBook;
    }

    public BasicGetBook getBasicGetBook() {
        return basicGetBook;
    }

    public void setBasicGetBooks(BasicGetBooks basicGetBooks) {
        this.basicGetBooks = basicGetBooks;
    }

    public BasicGetBooks getBasicGetBooks() {
        return basicGetBooks;
    }
}
