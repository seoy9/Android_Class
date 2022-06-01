package ddwucom.mobile.finalproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    ImageView ivPoster;
    TextView tvTitle;
    EditText etDate;
    EditText etGenre;
    EditText etTogether;
    RatingBar ratingBar;
    EditText etMemo;

    ReviewDBHelper helper;
    ReviewDBManager manager;
    ImageFileManager imageFileManager;

    ReviewDto dto;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_review);
        dto = (ReviewDto) getIntent().getSerializableExtra("dto");

        imageFileManager = new ImageFileManager(this);

        ivPoster = findViewById(R.id.ivUpdatePoster);
        tvTitle = findViewById(R.id.tvUpdateTitle);
        etDate = findViewById(R.id.et_updateDate);
        etGenre = findViewById(R.id.et_updateGenre);
        etTogether = findViewById(R.id.et_updateTogether);
        ratingBar = findViewById(R.id.updateRatingBar);
        etMemo = findViewById(R.id.et_updateMemo);

        Bitmap savedBitmap = imageFileManager.getBitmapFromTemporary(dto.getImageLink());

        if(savedBitmap != null) {
            ivPoster.setImageBitmap(savedBitmap);
        } else {
            ivPoster.setImageResource(R.mipmap.ic_launcher);
        }

        tvTitle.setText(dto.getTitle());
        etDate.setText(dto.getDate());
        etGenre.setText(dto.getGenre());
        etTogether.setText(dto.getTogether());
        ratingBar.setRating(dto.getRating());
        etMemo.setText(dto.getMemo());

        id = dto.getId();

        helper = new ReviewDBHelper(this);
        manager = new ReviewDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
//                DB 데이터 업데이트 작업 수행

                String date = etDate.getText().toString();
                String genre = etGenre.getText().toString();
                String together = etTogether.getText().toString();
                int rating = (int) ratingBar.getRating();
                String memo = etMemo.getText().toString();
                boolean result;

                if(date.equals("") || genre.equals("") || together.equals(""))
                    result = false;
                else {
                    dto.setDate(date);
                    dto.setGenre(genre);
                    dto.setTogether(together);
                    dto.setRating(rating);
                    dto.setMemo(memo);
                    result = manager.updateReview(dto);
                }

                if(result) {
                    setResult(RESULT_OK);
                } else
                    setResult(RESULT_CANCELED);

                finish();
                break;
            case R.id.btn_updateCancle:
//                DB 데이터 업데이트 작업 취소

                setResult(RESULT_CANCELED);

                finish();
                break;
        }
    }


}
