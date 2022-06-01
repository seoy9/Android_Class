package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etAuthor;
    EditText etPublisher;
    EditText etSynopsis;
    EditText etPrice;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.et_title);
        etAuthor = findViewById(R.id.et_author);
        etPublisher = findViewById(R.id.et_publisher);
        etSynopsis = findViewById(R.id.et_synopsis);
        etPrice = findViewById(R.id.et_price);

        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String publisher = etPublisher.getText().toString();
                String synopsis = etSynopsis.getText().toString();
                String price = etPrice.getText().toString();
                boolean result;

                if(title.equals("") || author.equals("") || publisher.equals("") || synopsis.equals("") || price.equals(""))
                    result = false;
                else
                    result = bookDBManager.addNewBook( new Book(title, author, publisher, synopsis, Integer.parseInt(price)) );
                if (result) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("title", etTitle.getText().toString() );
                    finish();
                } else {
                    Toast.makeText(this, "필수 항목을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancle:
                finish();
                break;
        }
    }
}
