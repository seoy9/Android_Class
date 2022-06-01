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

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String original;
    int first;
    int second;
    double result;
    String operator;
    int selectedLayout;
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

        Button btnPower = findViewById(R.id.btnPower);
        btnPower.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "power";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("power");
            }
        });

        Button btnRoot = findViewById(R.id.btnRoot);
        btnRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "root";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("root");
            }
        });

        Button btnSin = findViewById(R.id.btnSin);
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "sin";
                first = Integer.parseInt(editText.getText().toString());
                editText.setText("");
                editText.setHint("sin");
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
            if(!editText.getText().toString().equals(""))
                second = Integer.parseInt(editText.getText().toString());

            switch(operator) {
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
                    result =  first / second;
                    editText.setText(String.valueOf(result));
                    break;
                case "power":
                    result = Math.pow(first, second);
                    editText.setText(String.valueOf(result));
                    break;
                case "root":
                    result = Math.sqrt(first);
                    editText.setText(String.valueOf(result));
                    break;
                case "sin":
                    result = Math.sin(first);
                    editText.setText(String.valueOf(result));
                    break;
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.normal:
                item.setChecked(true);
                break;
            case R.id.scientific:
                item.setChecked(true);
//                intent = new Intent(getApplicationContext(), SciActivity.class);
//                startActivity(intent);
                break;
        }
        return true;
    }
}
