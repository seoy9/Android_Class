package ddwucom.mobile.week6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //뷰 클래스 생성 후 리스너를 구현하는 방법
//        MyView view = new MyView(this);
//        view.setOnTouchListener(view);
//        setContentView(view);

        setContentView(R.layout.activity_main);
//        hello();    //메소드 사용 : method call

        ConstraintLayout layout = findViewById(R.id.layout);

//        TextView textView = findViewById(R.id.textView);
//        textView = findViewById(R.id.textView);
        final TextView textView = findViewById(R.id.textView);

        layout.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
//                        Toast.makeText(MainActivity.this, "Layout Touch!", Toast.LENGTH_SHORT).show();
//                        textView.setText("Layout Touch!!!");
                        if(event.getAction() == MotionEvent.ACTION_DOWN) {
                            textView.setText("Action Down!!!");
                        } else if(event.getAction() == MotionEvent.ACTION_MOVE) {
                            textView.setText("Action Move!!!");
                        } else if(event.getAction() == MotionEvent.ACTION_UP) {
                            textView.setText("Action Up!!!");
                        }
                        return true;
                    }
                }
        );

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        //기본 방법 : 클래스 생성 후 적용
        MyClick myClick = new MyClick();
        button1.setOnClickListener(myClick);

        //엑티비티가 리스너를 구현
        button2.setOnClickListener(this);

        //익명 클래스의 객체 사용
        button3.setOnClickListener(myClickListener);

        //익명 클래스의 임시 객체 사용
        button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //this : OnClickListener 자신을 가리키게 됨
                        Toast.makeText(MainActivity.this, "다섯번째 익명 클래스 임시 객체 방식!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void onMyClick(View v) {
        Toast.makeText(this, "위젯 방식!", Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //this : OnClickListener 자신을 가리키게 됨
            Toast.makeText(MainActivity.this, "네번째 익명 클래스 방식!", Toast.LENGTH_SHORT).show();
        }
    };

    class MyView extends View implements View.OnTouchListener {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.YELLOW);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Toast.makeText(MainActivity.this, "세번째 자체 구현 방식!", Toast.LENGTH_SHORT).show();
            return true;
            //true : 이 이벤트 핸들러로 인해 이벤트 수행이 끝났다 더 이상 신경 쓸 필요 없다 / 처리 완료시
            //false : 이 이벤트를 처리할 수 있는 핸들러가 있으면 이벤트를 전달 / 처리를 계속해야 할 경우
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "두번째 Activity 방식!", Toast.LENGTH_SHORT).show();
    }

    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //this만 적으면 MyClick이 들어감 -> 명시적으로 MainActivity를 적어줘야 함
            Toast.makeText(MainActivity.this, "첫번째 방식!", Toast.LENGTH_SHORT).show();
        }
    }


    //메소드 선언 <- 운영체제(시스템) 호출  method callback
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Toast.makeText(this, "Touch Event!!!", Toast.LENGTH_SHORT).show();
////        return super.onTouchEvent(event);
//        return true;
//    }

    //메소드 선언
    private void hello() {
        Toast.makeText(this, "Hello!!", Toast.LENGTH_SHORT).show();
    }
}
