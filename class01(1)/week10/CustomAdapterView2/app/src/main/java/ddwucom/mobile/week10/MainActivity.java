package ddwucom.mobile.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CustomData> customDataList;
    private CustomAdapter customAdapter;
    private ListView listView;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customDataList = new ArrayList<CustomData>();

        dataManager = new DataManager(customDataList);

        dataManager.setting();

        customAdapter = new CustomAdapter(this, R.layout.custom_adapter_view, customDataList);

        listView = findViewById(R.id.customAdapterView);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, customDataList.get(position).getSigu() + " " + customDataList.get(position).getDong() + " 날씨는 " + customDataList.get(position).getWeather(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                customDataList.remove(position);
                return true;
            }
        });
    }
}
