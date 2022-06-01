/* 과제명 : 모바일 소프트웨어 중간평가 과제
*  분반: 01분반
*  학번: 20181033, 성명: 홍서연
*  제출일: 2020년 05월 24일 */

package ddwucom.mobile.midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    int first;
    int second;
    double result;
    String operator;
    Intent intent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button btnEqual = findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(equalClick);

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText.setHint("");
            }
        });

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "+";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("+");
            }
        });

        Button btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "-";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("-");
            }
        });

        Button btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "*";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("*");
            }
        });

        Button btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "/";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("/");
            }
        });

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn0:
              editText.setText(editText.getText().toString() + "0");
              break;
            case R.id.btn1:
                editText.setText(editText.getText().toString() + "1");
                break;
            case R.id.btn2:
                editText.setText(editText.getText().toString() + "2");
                break;
            case R.id.btn3:
                editText.setText(editText.getText().toString()+ "3");
                break;
            case R.id.btn4:
                editText.setText(editText.getText().toString()+ "4");
                break;
            case R.id.btn5:
                editText.setText(editText.getText().toString() + "5");
                break;
            case R.id.btn6:
                editText.setText(editText.getText().toString() + "6");
                break;
            case R.id.btn7:
                editText.setText(editText.getText().toString() + "7");
                break;
            case R.id.btn8:
                editText.setText(editText.getText().toString() + "8");
                break;
            case R.id.btn9:
                editText.setText(editText.getText().toString() + "9");
                break;
        }
    }

    View.OnClickListener equalClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                second = Integer.parseInt(editText.getText().toString());

                switch (operator) {
                    case "+":
                        result = first + second;
                        editText.setText(String.valueOf(result));
                        break;
                    case "-":
                        result = first - second;
                        editText.setText(String.valueOf(result));
                        break;
                    case "*":
                        result = first * second;
                        editText.setText(String.valueOf(result));
                        break;
                    case "/":
                        result = (double) first / second;
                        if(Double.isInfinite(result)) {
                            Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                            editText.setText("");
                            editText.setHint("");
                        } else
                            editText.setText(String.valueOf(result));
                        break;
                }
            } catch (ArithmeticException a) {
                Toast.makeText(MainActivity.this, "연산 오류" , Toast.LENGTH_SHORT).show();
                editText.setText("");
                editText.setHint("");
            } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    editText.setHint("");

            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.original:
                item.setChecked(true);
                break;
            case R.id.scientific:
                item.setChecked(true);
                intent = new Intent(getApplicationContext(), SciActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}
