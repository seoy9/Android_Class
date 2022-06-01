package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    Book book;
    EditText etTile;
    EditText etAuthor;
    EditText etPublisher;
    EditText etSynopsis;
    EditText etPrice;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        book = (Book) getIntent().getSerializableExtra("book");

        etTile = findViewById(R.id.et_title);
        etAuthor = findViewById(R.id.et_author);
        etPublisher = findViewById(R.id.et_publisher);
        etSynopsis = findViewById(R.id.et_synopsis);
        etPrice = findViewById(R.id.et_price);

        etTile.setHint(book.getTitle());
        etAuthor.setHint(book.getAuthor());
        etPublisher.setHint(book.getPublisher());
        etSynopsis.setHint(book.getSynopsis());
        etPrice.setHint(book.getPrice());

        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                book.setTitle(etTile.getText().toString());
                book.setAuthor(etAuthor.getText().toString());
                book.setPublisher(etPublisher.getText().toString());
                book.setSynopsis(etSynopsis.getText().toString());
                book.setPrice(Integer.parseInt(etPrice.getText().toString()));

                if( bookDBManager.modifyFood(book) ) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("book", book);
                    setResult(RESULT_OK);
                } else {
                    setResult(RESULT_CANCELED);
                }
                break;
            case R.id.btn_cancle:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
