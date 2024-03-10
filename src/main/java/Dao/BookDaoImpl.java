package Dao;
import model.Book;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDaoImpl implements BookDao{
    //save Produit into datatable
    @Override
    public Book save(Book book){
        Connection connection =SingletonConnection.getConnection();
        // add book to datatable
        try{
            PreparedStatement ps =connection.prepareStatement("INSERT INTO books (book_name,email,prix) VALUES (?,?,?)");
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getEmail());
            ps.setFloat(3,book.getPrix());
            ps.executeUpdate();
            System.out.println("pbookes has been addes succefully");
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }
    // get book from datatable by ID
    public Book getBook(Long id){
            Book book = null;
            Connection connection = SingletonConnection.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM books WHERE id=?");
                ps.setLong(1,id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    book  = new Book();
                    book.setId(rs.getLong("id"));
                    book.setBookName(rs.getString("book_name"));
                    book.setEmail(rs.getString("email"));
                    book.setPrix(rs.getFloat("prix"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }return book;
        }
        //updtae produit
    @Override
    public Book update(Book book) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET book_name=?,email=?,prix=? WHERE id=?");
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getEmail());
            ps.setFloat(3,book.getPrix());
            ps.setLong(4,book.getId());
             ps.executeUpdate();
            System.out.println("updated: " + book);
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } return book;
    }

    @Override
    public void deleteBook(Long id) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
            System.out.println("book has been deleted succefully");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  ArrayList<Book> getBooksFromDb() {
        ArrayList<Book> BookList = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from books");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Book book  = new Book();
                book.setId(rs.getLong("id"));
                book.setBookName(rs.getString("book_name"));
                book.setEmail(rs.getString("email"));
                book.setPrix(rs.getFloat("prix"));
                BookList.add(book);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return BookList;
}}






