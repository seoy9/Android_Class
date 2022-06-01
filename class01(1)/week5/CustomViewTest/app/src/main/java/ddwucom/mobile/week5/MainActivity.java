package ddwucom.mobile.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    Random random;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(count == 1) {
                    random = new Random();

                    myView.setCircleX(100);
                    myView.setCircleY(100);
                    myView.setCircleR((random.nextInt(3) + 1) * 100);

                    count++;

                    myView.invalidate();
                }
                else {
                    random = new Random();

                    myView.setCircleX(random.nextInt(myView.getWidth()));
                    myView.setCircleY(random.nextInt(myView.getHeight()));
                    myView.setCircleR((random.nextInt(3) + 1) * 100);

                    count++;

                    myView.invalidate();
                }

                break;
        }
    }
}
