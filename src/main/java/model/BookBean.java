package model;

import Dao.BookDao;
import Dao.BookDaoImpl;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class BookBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private long  id;
    private String bookName;
    private String email;
    private String isbn;
    private float prix;
    private static boolean renderAddtable;

    public boolean isRenderAddtable() {
        return renderAddtable;
    }

    public void setRenderAddtable(boolean renderAddtable) {
        BookBean.renderAddtable = renderAddtable;
    }




    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }





    private static ArrayList<Book> bookList ;

    public BookBean() {
            BookDaoImpl BookDao = new BookDaoImpl();
            bookList = BookDao.getBooksFromDb();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String addAction() {
        BookDaoImpl bookAdded = new BookDaoImpl();
        Book book = new Book(this.bookName, this.email , this.prix);
        bookAdded.save(book);
        bookList.add(book);
        return null;
    }

    public String deleteAction(Book book) {
        BookDaoImpl bookdeleted = new BookDaoImpl();
        bookdeleted.deleteBook(book.getId());
        bookList.remove(book);
        return null;
    }
    public String editAction(Book book) {
        book.setEditable(true);
        return null;
    }
    public String saveAction() {

        //get all existing value but set "editable" to false
        for (Book book : bookList){
            if (book.isEditable()){
                BookDaoImpl bookupdated = new BookDaoImpl();
                bookupdated.update(book);
            }
            book.setEditable(false);

        }
        //return to current page
        return null;

    }
    public String renderAction() {
        BookBean.renderAddtable = !BookBean.renderAddtable;
        return null;
    }
    // for










}











