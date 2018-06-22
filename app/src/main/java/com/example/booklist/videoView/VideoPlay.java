package com.example.booklist.videoView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.booklist.R;

import java.io.File;

public class VideoPlay extends AppCompatActivity {
    VideoView videoView;
    MediaController mc;

    //퍼미션용
    final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100;
    boolean permissionCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_view);

        videoView = (VideoView)findViewById(R.id.videoView);
        mc = new MediaController(this);
        videoView.setMediaController(mc); // 비디오뷰에 컨트롤러 연결
        permissionCheck();
        if(permissionCheck) startVideo(); // 퍼미션 등록시 비디오 실행
    }

    private void startVideo() {
        File sdcard = Environment.getExternalStorageDirectory(); //내부저장소에 경로 가져오는 객체
        String video_path = sdcard.getAbsolutePath() + "/BigBuck.mp4";
        videoView.setVideoPath(video_path);
        videoView.start();


    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
            // 퍼미션 등록 여부 확인( ~ 5.0까지)
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                // 퍼미션 등록할 지를 확인(6.0부터 ~ )
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        } else {
            // 퍼미션이 시스템에 등록이 되었다면
            permissionCheck = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                // 퍼미션 등록 되어 정상적으로 비디오 실행 처리
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startVideo();
                } else {
                    // 퍼미션 없는 등록 안되서 오류나는 부분 처리
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("경고, 퍼미션 등록 실패");
                    builder.setCancelable(false);

                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplication(),"퍼미션 등록을 확인하여 주세요.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create();
                    builder.show();
                }
        }
    }
}
