package ddwucom.mobile.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    EditText editText;

    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //원본 데이터
//        ArrayList<String> subjectList = new ArrayList<String>();
//        subjectList.add("모바일소프트웨어");
//        subjectList.add("네트워크");
//        subjectList.add("웹서비스");
//        subjectList.add("운영체제");
//        subjectList.add("웹프로그래밍2");

//        String[] subjectList = {"모바일소프트웨어", "네트워크", "웹서비스", "운영체제" ,"웹프로그래밍2"};

//        String[] subjectList = getResources().getStringArray(R.arrays.subjectList);

        subjectManager = new SubjectManager();

        subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, subjectList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "pos: " + position, Toast.LENGTH_SHORT).show();
                selectedPos = position;
                editText.setText(subjectManager.getItem(position));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Long Click: " + position, Toast.LENGTH_SHORT).show();
                subjectManager.removeData(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        editText = findViewById(R.id.editText);

        selectedPos = 0;
    }

    AdapterView.OnItemClickListener itemClickListener  = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "pos: " +position, Toast.LENGTH_SHORT).show();
        }
    };

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                subjectManager.addData(editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;

            case R.id.button2:
                subjectManager.updateData(selectedPos, editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
