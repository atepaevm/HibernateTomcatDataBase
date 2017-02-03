package main.java.table;

import javax.persistence.*;

/**
 * Example of subject class with some fields, getters and setters
 */
@Entity
@Table(name="books")
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="isbn")
    private int isbn;//unique number of book
    public void setId(int id1){this.id=id1;}
    public void setTitle(String title1){this.title=title1;}
    public void setDescription(String description1){this.description=description1;}
    public void setIsbn(int isbn1){this.isbn=isbn1;}
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public int getIsbn(){return isbn;}
}
