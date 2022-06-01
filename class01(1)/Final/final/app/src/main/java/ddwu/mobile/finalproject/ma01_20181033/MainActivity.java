package ddwu.mobile.finalproject.ma01_20181033;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ddwu.mobile.finalproject.R;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Book> bookList;
    private BookAdapter bookAdapter;
    private ListView listView;
    BookDBManager bookDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookDBManager = new BookDBManager(this);

        bookList = bookDBManager.getAllBook();

        bookAdapter = new BookAdapter(this, R.layout.custom_adapter_view, bookList);

        listView = findViewById(R.id.customListView);

        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = bookList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("book", book);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("책 삭제")
                        .setMessage(bookList.get(pos).getTitle() + "책을 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(bookDBManager.removeBook(bookList.get(pos).get_id())){
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    bookList.clear();
                                    bookList.addAll(bookDBManager.getAllBook());
                                    bookAdapter.notifyDataSetChanged();
                                }
                                else {
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        bookList.clear();
        bookList.addAll(bookDBManager.getAllBook());
        bookAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onMenuClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_add:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
            case R.id.m_titleSearch:
                Intent intent2 = new Intent(this, SearchTitleActivity.class);
                startActivity(intent2);
                break;
            case R.id.m_authorSearch:
                Intent intent3 = new Intent(this, SearchAuthorActivity.class);
                startActivity(intent3);
                break;
            case R.id.m_info:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("개발자 소개")
                        .setMessage("과목 : 모바일소프트웨어\n분반 : 01\n학번 : 20181033\n학과 : 컴퓨터학과\n이름 : 홍서연\n한 마디 : 고양이가 세상을 구한다!")
                        .setPositiveButton("확인", null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.m_fin:
                finish();
                break;
        }
    }
}