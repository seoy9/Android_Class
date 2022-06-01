package ddwu.mobile.finalproject.ma01_20181033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import ddwu.mobile.finalproject.R;

public class SearchAuthorActivity extends AppCompatActivity {
    EditText etAuthor;
    TextView tvResult;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_author);

        etAuthor = findViewById(R.id.etSearchAuthor);
        tvResult = findViewById(R.id.tvAuthorResult);
        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAuthorSearch:
                String author = etAuthor.getText().toString();
                ArrayList<Book> bookList;
                String result = "저자 / 제목 / 출판사 / 내용요약\n";

                bookList = bookDBManager.getBookByAuthor(author);

                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    result += book.getAuthor() + " / " + book.getTitle() + " / " + book.getPublisher() + " / " + book.getSynopsis() + "\n";
                }

                tvResult.setText(result);
                break;
            case R.id.btnAuthorExit:
                finish();
                break;
        }
    }
}