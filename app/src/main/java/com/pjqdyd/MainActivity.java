package com.pjqdyd;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        EditText editPassword  = findViewById(R.id.editPassword);
        //editText.setText("hello");
        //editText.setTextColor(Color.BLUE);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener((view) -> {
            System.out.println(editText.getText().toString());
            System.out.println(editPassword.getText().toString());
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        });
    }

}
