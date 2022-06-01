package ddwucom.mobile.report01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etDate;
    EditText etReview;

    ContactDBHelper helper;

    ContactDto dto;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dto = (ContactDto) getIntent().getSerializableExtra("dto");

        etTitle = findViewById(R.id.etTitle);
        etDate = findViewById(R.id.etDate);
        etReview = findViewById(R.id.etReview);

        etTitle.setText(dto.getTitle());
        etDate.setText(dto.getDate());
        etReview.setText(dto.getReview());

        helper = new ContactDBHelper(this);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnUpdateContact:
//                DB 데이터 업데이트 작업 수행

                dto.setTitle(etTitle.getText().toString());
                dto.setDate(etDate.getText().toString());
                dto.setReview(etReview.getText().toString());

                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues row = new ContentValues();
                row.put(ContactDBHelper.COL_TITLE, dto.getTitle());
                row.put(ContactDBHelper.COL_DATE, dto.getDate());
                row.put(ContactDBHelper.COL_REVIEW, dto.getReview());

                String whereClause = ContactDBHelper.COL_ID + "=?";
                String[] whereArgs = new String[] { String.valueOf(dto.getId()) };

                int result = db.update(ContactDBHelper.TABLE_NAME, row, whereClause, whereArgs);

                if(result > 0) {
                    setResult(RESULT_OK);
                } else
                    setResult(RESULT_CANCELED);

                finish();
                break;
            case R.id.btnUpdateContactClose:
//                DB 데이터 업데이트 작업 취소

                setResult(RESULT_CANCELED);

                finish();
                break;
        }
    }


}
