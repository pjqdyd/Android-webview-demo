package com.pjqdyd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        //btn.setOnClickListener(new MyListener());
        btn.setOnClickListener(view -> {
            System.out.println("点击了一下");
            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
        });

    }

//    public class MyListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            System.out.println("点击了一下");
//            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
//        }
//    }
}
