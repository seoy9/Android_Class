package ddwucom.mobile.test04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText editText = findViewById(R.id.editText);
        String originalNumber = editText.getText().toString();
        String newNumber ="";

        switch (v.getId()){
            case R.id.btnOne:
                newNumber = "1";
                editText.setText(originalNumber+newNumber);
                break;
            case R.id.btnTwo:
                newNumber = "2";
                editText.setText(originalNumber+newNumber);
                break;
            case R.id.btnThree:
                newNumber = "3";
                editText.setText(originalNumber+newNumber);
                break;
            case R.id.btnClear:
                editText.setText("");
                break;
        }
    }
}
