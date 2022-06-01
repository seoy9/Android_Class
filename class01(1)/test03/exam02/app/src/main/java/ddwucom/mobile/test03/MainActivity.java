package ddwucom.mobile.test03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //TextView myText = new TextView(this);
        TextView myText = null;
        //String text = "Android Programing!";
        // ....
        //text = "mobile";
        //...
        myText.setText("Android Programing!");
        setContentView(myText);
    }
}
