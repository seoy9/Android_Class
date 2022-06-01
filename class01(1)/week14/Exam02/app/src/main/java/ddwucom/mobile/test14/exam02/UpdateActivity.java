package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    Food food;

    EditText etFood;
    EditText etNation;

    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        food = (Food) getIntent().getSerializableExtra("food");

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        etFood.setText(food.getFood());
        etNation.setText(food.getNation());

        foodDBManager = new FoodDBManager(this);
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

                food.setFood( etFood.getText().toString() );
                food.setNation( etNation.getText().toString() );

                if ( foodDBManager.modifyFood(food) ) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", food);
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
