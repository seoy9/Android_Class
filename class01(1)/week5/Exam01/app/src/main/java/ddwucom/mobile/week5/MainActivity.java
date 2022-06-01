package ddwucom.mobile.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    int sound;

    AudioManager audioManager;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.dingdong, 1);

        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btnToast:
                Toast.makeText(this, "홍서연", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSound:
//                soundPool.play(sound, 1, 1, 0, 0, 1);
                audioManager.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
                break;
            case R.id.btnVibration:
//                vibrator.vibrate(1000);
                vibrator.vibrate(new long[] {240, 50, 150, 80}, 0);
                break;
            case R.id.btnVibrationCancle:
                vibrator.cancel();
                break;
        }
    }
}
