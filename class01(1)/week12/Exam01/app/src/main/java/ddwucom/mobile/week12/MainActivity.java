package ddwucom.mobile.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button:
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                String text = editText.getText().toString();
                intent.putExtra("text", text);

                startActivity(intent);
                break;
        }
    }
}