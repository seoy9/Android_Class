package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){

        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        switch(v.getId()) {
            case R.id.btnAddFood:
                String food = etFood.getText().toString();
                String nation = etNation.getText().toString();

                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, food);
                row.put(FoodDBHelper.COL_NATION, nation);
                db.insert(FoodDBHelper.TABLE_NAME, null, row);

                break;
        }
        myDbHelper.close();
        finish();
    }
}
