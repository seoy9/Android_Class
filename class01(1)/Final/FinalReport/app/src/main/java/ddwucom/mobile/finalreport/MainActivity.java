// 과제명: 도서 관리 앱
// 분반: 01 분반
// 학번: 20181033 성명: 홍서연
// 제출일: 2020년 6월 28일
package ddwucom.mobile.finalreport;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Book> bookList = null;
//    private BookAdapter bookAdapter;
    private ListView listView;
//    BookDBHelper dbHelper;
    BookDBManager bookDBManager;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bookList = new ArrayList<Book>();

//        bookList.add( new Book(1, "제목", "저자", "출판사", "내용요약"));
        bookDBManager = new BookDBManager(this);

        bookList = bookDBManager.getAllBook();

        bookAdapter = new BookAdapter(this, R.layout.custom_adapter, bookList);

        listView = findViewById(R.id.customListView);

        listView.setAdapter(bookAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("연락처 삭제")
                        .setMessage(bookList.get(pos).getTitle() + "를 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (bookDBManager.removeBook(bookList.get(pos).get_id())) {
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    bookList.clear();
                                    bookList.addAll(bookDBManager.getAllBook());
//                                    bookAdapter.notifyDataSetChanged();
                                    bookAdapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
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
                intent.putExtra("book", book);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        bookList.clear();
        bookList.addAll(bookDBManager.getAllBook());
//        bookAdapter.notifyDataSetChanged();
        bookAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onMenuClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_bookAdd:
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                break;
            case R.id.m_information:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("개발자 소개")
                        .setMessage("학번 : 20181033\n 학과 : 컴퓨터학과\n 이름 : 홍서연\n")
                        .setPositiveButton("확인", null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.m_finish:
                finish();
                break;
        }
    }
}
