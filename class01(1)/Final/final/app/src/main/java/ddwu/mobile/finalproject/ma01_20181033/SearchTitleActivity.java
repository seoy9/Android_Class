package ddwu.mobile.finalproject.ma01_20181033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import ddwu.mobile.finalproject.R;

public class SearchTitleActivity extends AppCompatActivity {
    EditText etTitle;
    TextView tvResult;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_title);

        etTitle = findViewById(R.id.etSearchTitle);
        tvResult = findViewById(R.id.tvResult);

        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                String title = etTitle.getText().toString();
                ArrayList<Book> bookList;
                String result = "제목 / 저자 / 출판사 / 내용요약\n";

                bookList = bookDBManager.getBookByTitle(title);

                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    result += book.getTitle() + " / " + book.getAuthor() + " / " + book.getPublisher() + " / " + book.getSynopsis() + "\n";
                }

                tvResult.setText(result);
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }
}