package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText etFood;
    EditText etID;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etFood = findViewById(R.id.etUpdateFood);
        etID = findViewById(R.id.etUpdateId);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){

        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        switch(v.getId()) {
            case R.id.btnUpdateFood:
                String food = etFood.getText().toString();
                String id = etID.getText().toString();

                ContentValues row = new ContentValues();
                row.put("food", food);
                String whereClause = "_id=?"; // null일 경우 전체 행 삭제
                String[] whereArgs = new String[]{id};
                db.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);

                break;
        }
        myDbHelper.close();
        finish();
    }
}
