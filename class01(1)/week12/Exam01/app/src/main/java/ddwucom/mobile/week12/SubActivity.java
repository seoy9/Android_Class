package ddwucom.mobile.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        EditText editText = findViewById(R.id.editText);

        Intent intent = getIntent();

        String text = intent.getStringExtra("text");

        editText.setText(text);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                finish();
                break;
        }
    }
}