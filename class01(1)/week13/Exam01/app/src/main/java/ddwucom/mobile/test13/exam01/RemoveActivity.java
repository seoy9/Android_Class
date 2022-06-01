package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    EditText etFood;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        etFood = findViewById(R.id.etRemoveFood);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){

        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        switch(v.getId()) {
            case R.id.btnRemoveFood:
                String food = etFood.getText().toString();

                String whereClause1 = "food=?";
                String[] whereArgs1 = new String[]{food};
                db.delete(FoodDBHelper.TABLE_NAME, whereClause1, whereArgs1);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
