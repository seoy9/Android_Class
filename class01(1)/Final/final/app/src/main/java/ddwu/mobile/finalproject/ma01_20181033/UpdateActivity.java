package ddwu.mobile.finalproject.ma01_20181033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import ddwu.mobile.finalproject.R;

public class UpdateActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etAuthor;
    EditText etPublisher;
    EditText etSynopsis;
    RatingBar ratingBar;
    Book book;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        book = (Book) getIntent().getSerializableExtra("book");

        etTitle = findViewById(R.id.etSearchTitle);
        etAuthor = findViewById(R.id.etSearchAuthor);
        etPublisher = findViewById(R.id.etPublisher);
        etSynopsis = findViewById(R.id.etSynopsis);
        ratingBar = findViewById(R.id.updateRating);

        etTitle.setHint(book.getTitle());
        etAuthor.setHint(book.getAuthor());
        etPublisher.setHint(book.getPublisher());
        etSynopsis.setHint(book.getSynopsis());
        ratingBar.setRating(book.getRating());

        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdate:
                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String publisher = etPublisher.getText().toString();
                String synopsis = etSynopsis.getText().toString();
                int rating = (int) ratingBar.getRating();
                boolean result;

                if(title.equals("") || author.equals("") || publisher.equals("") || synopsis.equals(""))
                    result = false;
                else {
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setPublisher(publisher);
                    book.setSynopsis(synopsis);
                    book.setRating(rating);
                    result = bookDBManager.modifyBook(book);
                }

                if(result) {
                    finish();
                }
                else
                    Toast.makeText(this, "필수 항목 미작성!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnUpdateCancle:
                finish();
                break;
        }
    }
}