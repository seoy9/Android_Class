package ddwucom.mobile.week7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.gga:
                Toast.makeText(this, "짜장면은 맛있다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ggam:
                Toast.makeText(this, "짬뽕은 맵다", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void onHanItemClick (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.kim:
                Toast.makeText(this, "김치찌게는 시다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sun:
                Toast.makeText(this, "순두부찌게는 우주 최고다", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
