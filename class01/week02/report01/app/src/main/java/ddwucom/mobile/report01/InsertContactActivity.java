package ddwucom.mobile.report01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InsertContactActivity extends AppCompatActivity {

	EditText etTitle;
	EditText etDate;
	EditText etReview;

	ContactDBHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_contact);

		etTitle = findViewById(R.id.editText1);
		etDate = findViewById(R.id.editText2);
		etReview = findViewById(R.id.editText3);

		helper = new ContactDBHelper(this);
	}
	
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.btnAddNewContact:
//			DB 데이터 삽입 작업 수행
			SQLiteDatabase db = helper.getWritableDatabase();

			String title = etTitle.getText().toString();
			String date = etDate.getText().toString();
			String review = etReview.getText().toString();

			ContentValues row = new ContentValues();
			row.put(ContactDBHelper.COL_TITLE, title);
			row.put(ContactDBHelper.COL_DATE, date);
			row.put(ContactDBHelper.COL_REVIEW, review);
			db.insert(ContactDBHelper.TABLE_NAME, null, row);

			helper.close();
			finish();
			break;
		case R.id.btnAddNewContactClose:
//			DB 데이터 삽입 취소 수행

			finish();
			break;
		}
	}
	
	
	
	
	
}
