package ddwu.mobile.finalproject.ma01_20181033;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import ddwu.mobile.finalproject.R;

public class AddActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etAuthor;
    EditText etPublisher;
    EditText etSynopsis;
    BookDBManager bookDBManager;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.etSearchTitle);
        etAuthor= findViewById(R.id.etSearchAuthor);
        etPublisher = findViewById(R.id.etPublisher);
        etSynopsis = findViewById(R.id.etSynopsis);
        ratingBar = findViewById(R.id.addRating);

        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String publisher = etPublisher.getText().toString();
                String synopsis = etSynopsis.getText().toString();
                int rating = (int) ratingBar.getRating();
                boolean result;

                if(title.equals("") || author.equals("") || publisher.equals("") || synopsis.equals(""))
                    result = false;
                else
                    result = bookDBManager.addNewBook( new Book(title, author, publisher, synopsis, rating) );

                if(result) {
                    finish();
                } else
                    Toast.makeText(this, "필수 항목 미작성!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_addCancle:
                finish();
                break;
        }
    }
}