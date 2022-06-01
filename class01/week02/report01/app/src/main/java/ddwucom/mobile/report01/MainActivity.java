package ddwucom.mobile.report01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onClick(View v) {
		Intent intent = null;
		
		switch (v.getId()) {
			case R.id.btnOpenAllContact:
				intent = new Intent(this, AllContactsActivity.class);
				break;
			case R.id.btnAddNewContact:
				intent = new Intent(this, InsertContactActivity.class);
				break;
		}
		if (intent != null) startActivity(intent);
	}
	
}
