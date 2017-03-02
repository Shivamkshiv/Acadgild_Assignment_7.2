package mr_auspicious.shivam_kr_shiv.com.sqlite1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import mr_auspicious.shivam_kr_shiv.com.sqlite1.data.Book;
import mr_auspicious.shivam_kr_shiv.com.sqlite1.data.BookDbHelper;



public class MainActivity extends AppCompatActivity {



    List<Book> data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookDbHelper db = new BookDbHelper(this);
        db.createBook(new Book("Arise And Awake"));  //Adding the books ..
        db.createBook(new Book("Connecting to the Dots"));
        db.createBook(new Book("Stay Hungry Stay Foolish"));
        db.createBook(new Book("I too had a Love Story"));
        db.createBook(new Book("Can Love Happen Twice "));
        db.createBook(new Book("This Love that Feels Right"));
        db.createBook(new Book("2 States"));


        data = db.getBooks(); // getting the linked list data from BookDbHelper class.

        List<String> listTitle = new ArrayList<String>(); // Declaring array List.

        for (int i = 0; i < data.size(); i++) {
            listTitle.add(i, data.get(i).getBook_Tilte()); // Adding the linked list data to array list.
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listTitle); //Array Adapter.
        AutoCompleteTextView textView = (AutoCompleteTextView) //AtutoCompleteTextView
                findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter); //Setting autocompleteTextView to the array adapter.
    }


}