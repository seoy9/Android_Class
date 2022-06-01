package ddwucom.mobile.report01;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AllContactsActivity extends AppCompatActivity {
	
	ListView lvContacts = null;
	ContactDBHelper helper;
	Cursor cursor;
	MyCursorAdapter adapter;
	final int UPDATE_CODE = 200;
	long iD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_contacts);
		lvContacts = (ListView)findViewById(R.id.lvContacts);

		helper = new ContactDBHelper(this);

		SQLiteDatabase db = helper.getReadableDatabase();
		cursor = db.rawQuery("select * from " + ContactDBHelper.TABLE_NAME, null);

		adapter = new MyCursorAdapter(this, R.layout.listview_layout, cursor);

		lvContacts.setAdapter(adapter);

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

				ContactDto dto = new ContactDto();
				dto.setId(cursor.getLong(cursor.getColumnIndex(ContactDBHelper.COL_ID)));
				dto.setTitle(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_TITLE)));
				dto.setDate(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_DATE)));
				dto.setReview(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_REVIEW)));

				Intent updateIntent = new Intent(AllContactsActivity.this, UpdateActivity.class);
				updateIntent.putExtra("dto", dto);
				startActivityForResult(updateIntent, UPDATE_CODE);
            }
        });

		lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				iD = id;
				AlertDialog.Builder builder = new AlertDialog.Builder(AllContactsActivity.this);
				builder.setTitle("삭제 확인")
						.setMessage("삭제하시겠습니까?")
						.setPositiveButton("확인", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								SQLiteDatabase db = helper.getWritableDatabase();
								String whereClause = ContactDBHelper.COL_ID + "=?";
								String[] whereArgs = new String[] { String.valueOf(iD) };
								int result = db.delete(ContactDBHelper.TABLE_NAME, whereClause, whereArgs);
								Cursor newCursor = db.rawQuery("select * from " + ContactDBHelper.TABLE_NAME, null);
								if(result > 0) adapter.changeCursor(newCursor);
							}
						})
						.setNegativeButton("취소", null)
						.setCancelable(false)
						.show();
				return true;
			}
		});


	}

	@Override
	protected void onResume() {
		super.onResume();
        helper.close();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (cursor != null) cursor.close();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == UPDATE_CODE) {
			switch (resultCode) {
				case RESULT_OK:
					SQLiteDatabase db = helper.getReadableDatabase();
					Cursor newCursor = db.rawQuery("select * from " + ContactDBHelper.TABLE_NAME, null);
					adapter.changeCursor(newCursor);
					break;
				case RESULT_CANCELED:
					break;
			}
		}
	}
}




