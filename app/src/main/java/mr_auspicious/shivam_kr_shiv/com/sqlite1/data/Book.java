package mr_auspicious.shivam_kr_shiv.com.sqlite1.data;

/**
 * Created by shivam on 01-03-2017.
 */


//Model
public class Book {
    private String Book_Tilte ;

    public Book(String book_Tilte) {
        Book_Tilte = book_Tilte;
    }

    public Book() {

    }

    public String getBook_Tilte() {
        return Book_Tilte;
    }

    public void setBook_Tilte(String book_Tilte) {
        Book_Tilte = book_Tilte;
    }
}
