package com.pjqdyd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final List<Integer> imageList = Arrays.asList(R.drawable.img1, R.drawable.img2, R.drawable.img3);
    private int imageIndex = 0; //显示的图片下标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.image_view);

        Button btnPrevious = findViewById(R.id.btn_previous); //上一张
        btnPrevious.setOnClickListener(view -> {
            imageIndex = imageIndex-1 < 0 ? 2 : imageIndex-1;
            imageView.setImageResource(imageList.get(imageIndex));

        });

        Button btnNext = findViewById(R.id.btn_next); //下一张
        btnNext.setOnClickListener(view -> {
            imageIndex = imageIndex+1 > 2 ? 0 : imageIndex+1;
            imageView.setImageResource(imageList.get(imageIndex));
        });

        Button btnWebView = findViewById(R.id.btn_web_view); //WebView
        btnWebView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
