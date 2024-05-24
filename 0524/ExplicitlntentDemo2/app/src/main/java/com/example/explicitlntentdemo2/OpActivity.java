package com.example.explicitlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OpActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opactivity);

        // 初始化UI元素
        radioGroup = findViewById(R.id.rg);
        checkBox = findViewById(R.id.chkDivide);
        Button button = findViewById(R.id.button2);

        // 設置按鈕點擊監聽器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    // 計算方法
    private void calculate() {
        // 獲取選中的運算符號
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            // 如果沒有選擇運算符號，顯示提示信息
            Toast.makeText(this, "請選擇一種運算符號", Toast.LENGTH_SHORT).show();
            return;
        }

        // 獲取選中的 RadioButton
        RadioButton radioButton = findViewById(selectedId);
        String operator = radioButton.getText().toString();

        // 獲取是否選中整數除法的狀態
        boolean isDivideChecked = checkBox.isChecked();

        // 在此處執行您的運算邏輯，並根據選項執行整數或浮點數除法

        // 以下示例僅顯示所選運算符號和整數除法的狀態
        String message = "您選擇的運算符號是：" + operator + "\n是否選擇了整數除法：" + isDivideChecked;

        // 顯示計算結果
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}