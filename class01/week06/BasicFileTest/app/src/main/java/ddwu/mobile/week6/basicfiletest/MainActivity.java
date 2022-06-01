package ddwu.mobile.week6.basicfiletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    final static String IN_FILE_NAME = "infile.txt";
    final static String EXT_FILE_NAME = "extfile.txt";
    final static String CACHE_FILE_NAME = "cachefile.txt";

    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);

        SharedPreferences pref = getSharedPreferences("config", 0);
        etText.setText(pref.getString("text_data", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getSharedPreferences("config", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("text_data", etText.getText().toString());
        editor.commit();
    }

    public void onInClick(View v) {
        switch(v.getId()) {
            case R.id.btnInWrite:
                String data = etText.getText().toString();
                File saveFile = new File(getFilesDir(), IN_FILE_NAME);
                try {
//                    FileOutputStream fos = new FileOutputStream(saveFile);
                    FileOutputStream fos = openFileOutput(IN_FILE_NAME, Context.MODE_APPEND);
                    fos.write(data.getBytes());
                    fos.flush();
                    fos.close();
                } catch (IOException e) { e.printStackTrace(); }
                break;
            case R.id.btnInRead:
                String path = getFilesDir() + "/" + IN_FILE_NAME;
                File readFile = new File(path);
                try {
                    FileReader fileReader = new FileReader(readFile);
                    BufferedReader br = new BufferedReader(fileReader);
                    String line = "";
                    String result = "";
                    while ((line = br.readLine()) != null) {
                        result += line;
                    }
                    etText.setText(result);
                    br.close();
                } catch (IOException e) { e.printStackTrace(); }
                break;
            case R.id.btnInDelete:
                File inFiles = getFilesDir();
                File[] files = inFiles.listFiles();
                for(File target : files) {
                    target.delete();
                }
                break;
        }
    }

    public void onExtClick(View v) {
        switch (v.getId()) {
            case R.id.btnExtWrite:
                if (isExternalStorageWritable()) {
                    File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                            "myalbm");
                    if (!file.mkdir()) {
                        Log.d(TAG, "directory not created");
                    }
                    String data = etText.getText().toString();
                    File saveFile = new File(file.getPath(), EXT_FILE_NAME);
                    try {
                        FileOutputStream fos = new FileOutputStream(saveFile);
                        fos.write(data.getBytes());
                        fos.flush();
                        fos.close();
                    } catch (IOException e) { e.printStackTrace(); }
                }
                break;
            case R.id.btnExtRead:
                if (isExternalStorageWritable()) {
                    String path = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath()
                            + "/myalbm/" + EXT_FILE_NAME;
                    File readFile = new File(path);
                    try {
                        FileReader fileReader = new FileReader(readFile);
                        BufferedReader br = new BufferedReader(fileReader);
                        String line = "";
                        String result = "";
                        while ((line = br.readLine()) != null) {
                            result += line;
                        }
                        etText.setText(result);
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btnExtDelete:
                String path = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath()
                        + "/myalbm";
                File inFiles = new File(path);
                File[] files = inFiles.listFiles();
                for(File target : files) {
                    target.delete();
                }
                break;
        }
    }

    public void onCacheClick(View v) {
        switch(v.getId()) {
            case R.id.btnCacheWrite:
                String data = etText.getText().toString();
                File saveFile = new File(getCacheDir(), CACHE_FILE_NAME);
                try {
                    FileOutputStream fos = new FileOutputStream(saveFile);
//                    FileOutputStream fos = openFileOutput(CACHE_FILE_NAME, Context.MODE_APPEND);
                    fos.write(data.getBytes());
                    fos.flush();
                    fos.close();
                } catch (IOException e) { e.printStackTrace(); }
                break;
            case R.id.btnCacheRead:
                String path = getCacheDir() + "/" + CACHE_FILE_NAME;
                File readFile = new File(path);
                try {
                    FileReader fileReader = new FileReader(readFile);
                    BufferedReader br = new BufferedReader(fileReader);
                    String line = "";
                    String result = "";
                    while ((line = br.readLine()) != null) {
                        result += line;
                    }
                    etText.setText(result);
                    br.close();
                } catch (IOException e) { e.printStackTrace(); }
                break;
            case R.id.btnCacheDelete:
                File inFiles = getCacheDir();
                File[] files = inFiles.listFiles();
                for(File target : files) {
                    target.delete();
                }
                break;
        }
    }

    private boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private boolean isExternalStorageReadable() {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED ||
                Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED_READ_ONLY;
    }

}