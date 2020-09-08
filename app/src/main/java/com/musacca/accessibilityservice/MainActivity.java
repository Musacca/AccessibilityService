package com.musacca.accessibilityservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private Button startbtn, stopbtn, playbtn, stopplay;
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private static final String LOG_TAG = "AudioRecording";
    private static final String TAG = "MyAccessibilityService";
    public static boolean isAudioRecording;
    private static String mFileName = null;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
    String csv = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/LogOutput.csv");
    public static CSVWriter writer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn = (Button) findViewById(R.id.btnRecord);
        stopbtn = (Button) findViewById(R.id.btnStop);
        playbtn = (Button) findViewById(R.id.btnPlay);
        stopplay = (Button) findViewById(R.id.btnStopPlay);
        stopbtn.setEnabled(false);
        playbtn.setEnabled(false);
        stopplay.setEnabled(false);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/AudioRecording.3gp";
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckPermissions()) {
                    if (isAccessibilitySettingsOn(MainActivity.this)) {
                        try {
                            writer = new CSVWriter(new FileWriter(csv));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        stopbtn.setEnabled(true);
                        startbtn.setEnabled(false);
                        playbtn.setEnabled(false);
                        stopplay.setEnabled(false);
                        mRecorder = new MediaRecorder();
                        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mRecorder.setOutputFile(mFileName);
                        try {
                            mRecorder.prepare();
                        } catch (IOException e) {
                            Log.e(LOG_TAG, "prepare() failed");
                        }
                        mRecorder.start();
                        isAudioRecording = true;
                        Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(getApplicationContext(), "Enable Accessibility service", Toast.LENGTH_LONG).show();

                }
                else
                {
                    RequestPermissions();
                }
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopbtn.setEnabled(false);
                startbtn.setEnabled(true);
                playbtn.setEnabled(true);
                stopplay.setEnabled(true);
                mRecorder.stop();
                mRecorder.release();
                mRecorder = null;
                Toast.makeText(getApplicationContext(), "Recording Stopped", Toast.LENGTH_LONG).show();
                isAudioRecording = false;
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopbtn.setEnabled(false);
                startbtn.setEnabled(true);
                playbtn.setEnabled(false);
                stopplay.setEnabled(true);
                mPlayer = new MediaPlayer();
                try {
                    mPlayer.setDataSource(mFileName);
                    mPlayer.prepare();
                    mPlayer.start();
                    Toast.makeText(getApplicationContext(), "Recording Started Playing", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "prepare() failed");
                }
            }
        });
        stopplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.release();
                mPlayer = null;
                stopbtn.setEnabled(false);
                startbtn.setEnabled(true);
                playbtn.setEnabled(true);
                stopplay.setEnabled(false);
                Toast.makeText(getApplicationContext(), "Playing Audio Stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Test ", "---------------->.>> " + isAccessibilitySettingsOn(this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_AUDIO_PERMISSION_CODE:
                if (grantResults.length > 0) {
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (permissionToRecord && permissionToStore) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean CheckPermissions() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void RequestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
    }

    public static boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        //your package /   accesibility service path/class
        final String service = "com.musacca.accessibilityservice/com.musacca.accessibilityservice.Service.MyAccessibilityService";

        boolean accessibilityFound = false;
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_ENABLED);
            Log.v(TAG, "accessibilityEnabled = " + accessibilityEnabled);
        } catch (Settings.SettingNotFoundException e) {
            Log.e(TAG, "Error finding setting, default accessibility to not found: "
                    + e.getMessage());
        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            Log.v(TAG, "***ACCESSIBILIY IS ENABLED*** -----------------");
            String settingValue = Settings.Secure.getString(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                TextUtils.SimpleStringSplitter splitter = mStringColonSplitter;
                splitter.setString(settingValue);
                while (splitter.hasNext()) {
                    String accessabilityService = splitter.next();

                    Log.v(TAG, "-------------- > accessabilityService :: " + accessabilityService);
                    if (accessabilityService.equalsIgnoreCase(service)) {
                        Log.v(TAG, "We've found the correct setting - accessibility is switched on!");
                        return true;
                    }
                }
            }
        } else {
            Log.v(TAG, "***ACCESSIBILIY IS DISABLED***");
        }

        return accessibilityFound;
    }
}