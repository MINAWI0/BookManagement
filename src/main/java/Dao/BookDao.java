package Dao;


import model.Book;

import java.util.ArrayList;

public interface BookDao {
      public Book save(Book p );
      public Book getBook(Long id);
      public Book update(Book p);
      public  void deleteBook(Long id);
    public ArrayList<Book> getBooksFromDb();

}
