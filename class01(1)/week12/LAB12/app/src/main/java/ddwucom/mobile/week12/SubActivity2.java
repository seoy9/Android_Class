package ddwucom.mobile.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", "good!!");
                setResult(RESULT_OK, resultIntent);
                break;
            case R.id.button2:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}