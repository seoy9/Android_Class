package ddwucom.mobile.myapplication;

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

//    FoodDBHelper dbHelper;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.et_title);
        etAuthor = findViewById(R.id.et_author);
        etPublisher = findViewById(R.id.et_publisher);
        etSynopsis = findViewById(R.id.et_synopsis);

//        dbHelper = new FoodDBHelper(this);
        bookDBManager = new BookDBManager(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues value = new ContentValues();
//                value.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());
//                value.put(FoodDBHelper.COL_NATION, etNation.getText().toString());
//
////                insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
//                long count = db.insert(FoodDBHelper.TABLE_NAME, null, value);

//                if (count > 0) {    // 정상수행에 따른 처리
//                    Intent resultIntent = new Intent();
//                    resultIntent.putExtra("food", etFood.getText().toString() );
//                    setResult(RESULT_OK, resultIntent);
//                    dbHelper.close();
//                    finish();
//                } else {        // 이상에 따른 처리
//                    Toast.makeText(this, "새로운 음식 추가 실패!", Toast.LENGTH_SHORT).show();
//                    dbHelper.close();
//                }
                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String publisher = etPublisher.getText().toString();
                String synopsis = etSynopsis.getText().toString();
                boolean result;
                if(title.equals("") || author.equals("") || publisher.equals("") || synopsis.equals(""))
                    result = false;
                else {
                    result = bookDBManager.addNewFood(
                            new Book(title, author, publisher, synopsis)
                    );
                }

                if (result) {    // 정상수행에 따른 처리
                    setResult(RESULT_OK);
                    finish();
                } else {        // 이상에 따른 처리
                    Toast.makeText(this, "새로운 음식 추가 실패!", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.btn_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
