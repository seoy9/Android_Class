package ddwucom.mobile.test05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static int first;
    public static int second;
    public static int result;
    public static EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etDisplay);
    }

    public void onClick (View v) {
        String originalText = editText.getText().toString();
        switch (v.getId()) {
            case R.id.btn_1:
                editText.setText(originalText + "1");
                break;
            case R.id.btn_2:
                editText.setText(originalText + "2");
                break;
            case R.id.btn_3:
                first = Integer.valueOf(originalText);
                editText.setText("");
                break;
            case R.id.btn_4:
                second = Integer.valueOf(originalText);
                result = first + second;
                editText.setText(String.valueOf(result));
                break;
        }
    }
}
