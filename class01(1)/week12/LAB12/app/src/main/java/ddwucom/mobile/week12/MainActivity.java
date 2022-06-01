package ddwucom.mobile.week12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static int REQ_CODE = 100;
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
//                Intent intent = new Intent(MainActivity.this, SubActivity2.class);

//                String id = "cooling";
//
//                intent.putExtra("id", id);
//
//                ArrayList<String> foods = new ArrayList<String>();
//                foods.add("사과");
//                foods.add("배");
//                foods.add("오렌지");
//
//                intent.putExtra("foods", foods);

//                startActivityForResult(intent, REQ_CODE);

//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:012-3456-7890"));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case REQ_CODE:
                if(resultCode == RESULT_OK) {
                    String result = data.getStringExtra("result_data");
                    Log.d(TAG, "Result : " + result);
                } else {
                    Log.d(TAG, "Cancled");
                }
            break;
        }
    }
}