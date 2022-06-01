package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }



    public void onClick(View v) {

        SQLiteDatabase db = myDbHelper.getWritableDatabase();
//      SQLiteDatabase db = myDbHelper.getReadableDatabase(); // select
        switch(v.getId()) {
            case R.id.btnSelect:
                // 메소드 사용
//                String[] columns = {"_id", "food", "nation"};
//                String selection = "food=?";
//                String[] selectArgs = new String[]{"된장찌개"};
//                Cursor cursor = db.query(FoodDBHelper.TABLE_NAME, columns, selection, selectArgs,
//                        null, null, null, null);
                Cursor cursor = db.query(FoodDBHelper.TABLE_NAME, null, null, null,
                        null, null, null, null);

                String result = "";
                while (cursor.moveToNext()){
                    int id = cursor.getInt(0);
//                    int id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
                    String food = cursor.getString(1);
//                    String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
                    String nation = cursor.getString(2);
//                    String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
                    result += id + ". " + food + " (" + nation + ")\n";
                }

                tvDisplay.setText(result);
                cursor.close();

                // SQL 사용
//                Cursor cursor1 = db.rawQuery("SELECT _id, food, nation FROM "
//                        + FoodDBHelper.TABLE_NAME + " WHERE food='된장찌개';", null);
//
//                cursor1.close();
                break;
            case R.id.btnAdd:
                // 메소드 사용
//                ContentValues row = new ContentValues();
//                row.put(FoodDBHelper.COL_FOOD, "순두부찌개");
//                row.put(FoodDBHelper.COL_NATION, "한국");
//                db.insert(FoodDBHelper.TABLE_NAME, null, row);

                // SQL 사용
//                db.execSQL("insert into " + FoodDBHelper.TABLE_NAME
//                        + " VALUES (NULL, '김치찌개', '한국');");

                Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(addIntent);
                break;
            case R.id.btnUpdate:
                // 메소드 사용
//                ContentValues row1 = new ContentValues();
//                row1.put("nation", "이탈리아");
//                row1.put("food", "파스타");
//                String whereClause = "_id=?"; // null일 경우 전체 행 삭제
//                String[] whereArgs = new String[]{"1"};
//                db.update(FoodDBHelper.TABLE_NAME, row1, whereClause, whereArgs);

                // SQL 사용
//                db.execSQL("UPDATE " + FoodDBHelper.TABLE_NAME
//                + " SET nation = '한국' WHERE food = '김치찌개';");

                Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(updateIntent);

                break;
            case R.id.btnRemove:
                // 메소드 사용
//                String whereClause1 = "_id=?";
//                String[] whereArgs1 = new String[]{"2"};
//                db.delete(FoodDBHelper.TABLE_NAME, whereClause1, whereArgs1);

                // SQL 사용용
//               db.execSQL("DELETE FROM " + FoodDBHelper.TABLE_NAME
//                + " WHERE food = '김치찌개';");

                Intent removeIntent = new Intent(MainActivity.this, RemoveActivity.class);
                startActivity(removeIntent);
                break;
        }

        myDbHelper.close();
    }

}
