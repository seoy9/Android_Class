package ddwucom.mobile.week6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String text;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnDisplay);

//        MyClick myClick = new MyClick();
//        button.setOnClickListener(myClick);

//        button.setOnClickListener(myClickListener);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText = findViewById(R.id.editText);
                        textView = findViewById(R.id.tvDisplay);
                        text = editText.getText().toString();
                        textView.setText(text);
                        editText.setText("");
                    }
                }
        );
    }

    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            editText = findViewById(R.id.editText);
            textView = findViewById(R.id.tvDisplay);
            text = editText.getText().toString();
            textView.setText(text);
            editText.setText("");
        }
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText = findViewById(R.id.editText);
            textView = findViewById(R.id.tvDisplay);
            text = editText.getText().toString();
            textView.setText(text);
            editText.setText("");
        }
    };
}
