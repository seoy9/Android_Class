package ddwucom.mobile.test05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayout layout = findViewById(R.id.linearLayout);
        layout = findViewById(R.id.linearLayout);
    }

    public void onClick (View v) {
        //LinearLayout layout = findViewById(R.id.linearLayout);

        switch(v.getId()) {
            case R.id.btnVertical:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
            case R.id.btnHorizontal:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
        }
    }
}
