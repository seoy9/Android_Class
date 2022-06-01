package ddwucom.mobile.week11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        final int selectedIndex;
        final boolean[] selectedItems = {false, false, false, false};
        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.order_layout, null);

        switch (v.getId()) {
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

//                builder.setTitle("대화상자 제목");
//                builder.setMessage("대화상자 메시지");
//                builder.setIcon(R.mipmap.ic_launcher);
//                builder.setPositiveButton("확인버튼", null);
//                builder.setNeutralButton("대기버튼", null);
//                builder.setNegativeButton("취소버튼", null);
//                builder.show();

                builder.setTitle("대화상자 제목")
//                        .setMessage("대화상자 메시지")
//                        .setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this, "선택: " + foods[which], Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                selectedIndex = which;
//                            }
//                        })
//                        .setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                selectedItems[which] = isChecked;
//                            }
//                        })
                        .setView(orderLayout)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
////                                Toast.makeText(MainActivity.this, "확인버튼 눌렀습니다", Toast.LENGTH_SHORT).show();
//                                String[] foods = getResources().getStringArray(R.array.foods);
////                                Toast.makeText(MainActivity.this, "선택: " + foods[selectedIndex], Toast.LENGTH_SHORT).show();
//
//                                String result = "선택: ";
//                                for(int i = 0; i < selectedItems.length; i++) {
//                                    if(selectedItems[i]) {
//                                        result += foods[i] + " ";
//                                    }
//                                }
//                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                                EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                                EditText etQuantity = orderLayout.findViewById(R.id.etQuantity);
                                CheckBox cbPayment = orderLayout.findViewById(R.id.cbPayment);

                                Toast.makeText(MainActivity.this, "제품: " + etProduct.getText() + " 수량: " + etQuantity.getText() + " 착불 결제: " + cbPayment.isChecked(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("대기버튼", null)
                        .setNegativeButton("취소버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .show();

//                Dialog dlg = builder.create();
//                dlg.setCanceledOnTouchOutside(false);
//                dlg.show();
        }
    }
}
