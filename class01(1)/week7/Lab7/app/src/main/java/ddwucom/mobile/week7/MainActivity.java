package ddwucom.mobile.week7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    final static int MENU_FIRST = 100;
    final static int MENU_SECOND = 200;

    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = findViewById(R.id.textView);

//        registerForContextMenu(textview);

        popup = new PopupMenu(this, textview);

        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "Hi!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        textview.setOnTouchListener(
                new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popup.show();
                        return true;
                    }
                }
        );
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.textView:
                //메뉴를 만드는 객체 추가
                //코드로 추가
                menu.setHeaderTitle("Context Menu");
                menu.add(0, MENU_FIRST, 0, "FIRST");
                menu.add(0, MENU_SECOND, 0, "SECOND");
                //xml 메뉴를 inflation
                menu.setHeaderTitle("Context Menu");
                getMenuInflater().inflate(R.menu.menu_context, menu);

                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        return super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case MENU_FIRST:
                Log.i(TAG, "context 1");
                break;
            case MENU_SECOND:
                Log.i(TAG, "context 2");
                break;
            case R.id.third:
                Log.i(TAG, "context 3");
                break;
            case R.id.fourth:
                Log.i(TAG, "context 4");
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.group_menu, menu);
        return true;
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (true) {
//            menu.clear();
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//        }
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
//        switch (item.getItemId()) {
//            case R.id.item01:
//                Log.i(TAG, "item01 is clicked!");
//                break;
//            case R.id.subItem01:
//                Log.i(TAG, "subItem01 is clicked!");
//                break;
//            case R.id.subItem02:
//                Log.i(TAG, "subItem02 is clicked!");
//                break;
//        }
        switch (item.getItemId()) {
            case R.id.gItem01:
                if(item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                break;
            case R.id.gItem02:
                if(item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                break;
            case R.id.gItem03:
                item.setChecked(true);
                break;
            case R.id.gItem04:
                item.setChecked(true);
                break;
        }
        return true;
    }

    public void onMenuItemClick (MenuItem item) {
        Log.i(TAG, "item01 is clicked!!!");
    }
}
