package ddwucom.mobile.text04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHelloClick(View v) {
        EditText editText1 = findViewById(R.id.etName);
        EditText editText2 = findViewById(R.id.etPhone);
        String name = editText1.getText().toString();
        String phone = editText2.getText().toString();

        Toast.makeText(this, "안녕하세요, 저는 "+name+" 입니다.\n전화번호는 "+phone+" 입니다.", Toast.LENGTH_LONG).show();
    }

    public void onExitClick(View v) {
        finish();
    }
}
