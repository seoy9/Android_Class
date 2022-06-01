package ddwucom.mobile.finalproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddReviewActivity extends AppCompatActivity {

	ImageView imageView;
	TextView tvTitle;
	EditText etDate;
	EditText etGenre;
	EditText etTogether;
	EditText etMemo;
	RatingBar ratingBar;

	String title;
	String imageLink;
	String imageFileName;

	ReviewDBManager manager;
	ImageFileManager imageFileManager;
	NetworkManager networkManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_review);

		imageFileManager = new ImageFileManager(this);
		networkManager = new NetworkManager(this);

		title = getIntent().getStringExtra("title");
		imageLink = getIntent().getStringExtra("imageLink");
		imageFileName = getIntent().getStringExtra("imageFileName");

		Log.d("ImageLink: ", imageLink);
		Log.d("ImageFileName: ", imageFileName);

		imageView = findViewById(R.id.img_movie);

		Bitmap savedBitmap = imageFileManager.getBitmapFromTemporary(imageLink);

		if(savedBitmap != null) {
			imageView.setImageBitmap(savedBitmap);
		} else {
			imageView.setImageResource(R.mipmap.ic_launcher);
		}

		tvTitle = findViewById(R.id.tv_title);
		tvTitle.setText(title);

		etDate = findViewById(R.id.et_date);
		etGenre = findViewById(R.id.et_genre);
		etTogether = findViewById(R.id.et_together);
		etMemo = findViewById(R.id.et_meno);
		ratingBar = findViewById(R.id.ratingBar);
		manager = new ReviewDBManager(this);
	}
	
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.btn_save:
//			DB 데이터 삽입 작업 수행
			String date = etDate.getText().toString();
			String genre = etGenre.getText().toString();
			String together = etTogether.getText().toString();
			String memo = etMemo.getText().toString();
			int rating = (int) ratingBar.getRating();
			boolean result;

			if(title.equals("") || date.equals("") || genre.equals("") || together.equals("") || rating == 0) {
				result = false;
			} else {
				result = manager.addNewReview(new ReviewDto(title, date, genre, together, rating, memo, imageLink, imageFileName));
			}

			if(result) {
				Toast.makeText(this, "저장 완료!", Toast.LENGTH_SHORT).show();
				finish();
			} else
				Toast.makeText(this, "필수 항목 미작성!", Toast.LENGTH_SHORT).show();

			break;
		case R.id.btn_cancle:
//			DB 데이터 삽입 취소 수행

			finish();
			break;
		}
	}
}
