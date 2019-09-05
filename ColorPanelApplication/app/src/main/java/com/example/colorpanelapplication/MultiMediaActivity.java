package com.example.colorpanelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.InputStream;
import java.net.URL;
import java.util.Locale;

public class MultiMediaActivity extends AppCompatActivity {

    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_media);

        videoView = findViewById(R.id.videoView);
        // Tạo bộ điều khiển
        if (mediaController == null) {
            mediaController = new MediaController(MultiMediaActivity.this);
            // Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(videoView);
            // Sét đặt bộ điều khiển cho VideoView.
            videoView.setMediaController(mediaController);
        }

        try {

//            String nameUrl = "http://videos.4fanclub.vn/android/Udemy%20-%20The%20Essential%20Android%20O%20Developer%20Course/07%20The%20User%20Interface%20Part%201%20-%20Layouts/020%20View%20and%20View%20Groups-en.srt";
//            InputStream inputStream = new URL(nameUrl).openStream();
////            MediaFormat mediaFormat =
//            videoView.setVideoPath("http://videos.4fanclub.vn/android/Udemy%20-%20The%20Essential%20Android%20O%20Developer%20Course/122%20Overview.mp4");
//            videoView.addSubtitleSource(inputStream, MediaFormat.createSubtitleFormat("text/srt", Locale.ENGLISH.getLanguage()));
            Uri uri=Uri.parse("android.resource://"+getPackageName()+"/raw/future");
            videoView.setVideoURI(uri);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();

        // Sự kiện khi file video sẵn sàng để chơi.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                // Khi màn hình Video thay đổi kích thước
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
}
