package com.pjqdyd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements OnCheckedChangeListener {

    private CheckBox cbEat;
    private CheckBox cbSleep;
    private CheckBox cbCoding;
    private Map<String, String> likeMap = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取控件
        cbEat =  findViewById(R.id.cbEat);
        cbSleep = findViewById(R.id.cbSleep);
        cbCoding = findViewById(R.id.cbCoding);
        // 绑定事件
        cbEat.setOnCheckedChangeListener(this);
        cbSleep.setOnCheckedChangeListener(this);
        cbCoding.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton checkBox, boolean checked) {
        switch (checkBox.getId()) {
            case R.id.cbEat:
                likeMap.put("eat", checked ? "吃" : "");
                break;
            case R.id.cbSleep:
                likeMap.put("sleep", checked ? "睡觉" : "");
                break;
            case R.id.cbCoding:
                likeMap.put("coding", checked ? "敲代码" : "");
                break;
            default:
                break;
        }
    }

    public void submit(View v) {//当按钮点击后
        // 循环读取爱好
        StringBuilder likeStr = new StringBuilder();
        if (likeMap.size() == 0) {
            String no = "这个人完全没有爱好!";
            Toast.makeText(MainActivity.this, no, Toast.LENGTH_SHORT).show();
        } else {
            //likeMap.entrySet().stream().filter((e) -> e.getValue() != "").forEach(e -> likeStr.append(e.getValue()));
            likeMap.forEach((key, value) -> likeStr.append(" ").append(value));
            Toast.makeText(MainActivity.this, "你的爱好: " + likeStr, Toast.LENGTH_SHORT).show();
        }

    }

}
