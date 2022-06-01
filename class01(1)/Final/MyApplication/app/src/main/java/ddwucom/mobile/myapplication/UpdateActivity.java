package ddwucom.mobile.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Book book;

    EditText etTitle;
    EditText etAuthor;
    EditText etPublisher;
    EditText etSynopsis;

    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        book = (Book) getIntent().getSerializableExtra("food");

        etTitle = findViewById(R.id.et_title);
        etAuthor = findViewById(R.id.et_author);
        etPublisher = findViewById(R.id.et_publisher);
        etSynopsis = findViewById(R.id.et_synopsis);

        etTitle.setText(book.getTitle());
        etAuthor.setText(book.getAuthor());
        etPublisher.setText(book.getPublisher());
        etSynopsis.setText(book.getSynopsis());

        bookDBManager = new BookDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
//                String foodName = etFood.getText().toString();
//                String nation = etNation.getText().toString();

//                FoodDBHelper foodDBHelper = new FoodDBHelper(this);
//                SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();
//
//                ContentValues row = new ContentValues();
//                row.put(FoodDBHelper.COL_FOOD, foodName);
//                row.put(FoodDBHelper.COL_NATION, nation);
//
//                String whereClause = FoodDBHelper.COL_ID + "=?";
//                String[] whereArgs = new String[] { String.valueOf(food.get_id()) };
//
//                int result = sqLiteDatabase.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);

//                if (result > 0) {
//                    Intent resultIntent = new Intent();
//                    resultIntent.putExtra("food", foodName);
//                    setResult(RESULT_OK);
//                } else {
//                    setResult(RESULT_CANCELED);
//                }

                book.setTitle( etTitle.getText().toString() );
                book.setAuthor( etAuthor.getText().toString() );
                book.setPublisher( etPublisher.getText().toString() );
                book.setSynopsis( etSynopsis.getText().toString() );

                if ( bookDBManager.modifyBook(book) ) {
//                    Intent resultIntent = new Intent();
//                    resultIntent.putExtra("book", book);
                    setResult(RESULT_OK);
                } else {
                    setResult(RESULT_CANCELED);
                }

                break;
            case R.id.btn_cancel:
                    setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
