package ddwucom.mobile.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Book> bookList = null;
//    FoodDBHelper dbHelper;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        bookList = new ArrayList<Book>();

//        dbHelper = new FoodDBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null);
//
//        while(cursor.moveToNext()) {
//            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
//            String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
//            String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
//            foodList.add ( new Food (id, food, nation) );
//        }
//
//        cursor.close();
//        dbHelper.close();

        adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, bookList);
        listView.setAdapter(adapter);
        bookDBManager = new BookDBManager(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_message)
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                deleteRecord(pos);

                                if (bookDBManager.removeFood(bookList.get(pos).get_id())) {
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    bookList.clear();
                                    bookList.addAll(bookDBManager.getAllFood());
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancle, null)
                        .setCancelable(false)
                        .show();

                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Book book = bookList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("food", book);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });
    }

//    private void deleteRecord(int pos) {
//        FoodDBHelper foodDBHelper = new FoodDBHelper(this);
//        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();
//        String whereClause = foodDBHelper.COL_ID + "=?";
//        String[] whereArgs = new String[] { String.valueOf(foodList.get(pos).get_id()) };
//        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
//        if (result > 0) {
//            Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT).show();
//            foodList.clear();
//            foodList.addAll(foodDBManager.getAllFood());
//            adapter.notifyDataSetChanged();
//        } else {
//            Toast.makeText(this, "삭제 실패", Toast.LENGTH_SHORT).show();
//        }
//        foodDBHelper.close();
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        readAllFood();
        bookList.clear();
        bookList.addAll(bookDBManager.getAllFood());
        adapter.notifyDataSetChanged();
    }

//    private void readAllFood() {
//        foodList.clear();
//
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null);
//
//        while(cursor.moveToNext()) {
//            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
//            String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
//            String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
//            foodList.add ( new Food (id, food, nation) );
//        }
//
//        cursor.close();
//        dbHelper.close();
//    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }
}
