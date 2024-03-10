package model;

public  class Book {
    private long  id;
    private String bookName;
    private String email;
    private float prix;
    private boolean editable ;

    public Book() {

    }
    public Book(String bookName, String email, float prix) {
        this.bookName = bookName;
        this.email = email;
        this.prix = prix;
    }


    // setter
    public void setId(long id) {this.id = id;}
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPrix(float prix) {this.prix = prix;}
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    //getter
    public long getId() {
        return id;
    }
    public String getBookName() {
        return bookName;
    }

    public String getEmail() {
        return email;
    }

    public float getPrix() {return prix;}
    public boolean isEditable() {
        return editable;
    }

    // toString Methode

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", email='" + email + '\'' +
                ", prix=" + prix +
                '}';
    }
}


