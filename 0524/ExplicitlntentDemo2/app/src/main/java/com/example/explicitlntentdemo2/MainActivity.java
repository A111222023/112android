package com.example.explicitlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.lblOutput);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtOpd1 = findViewById(R.id.txtOpd1);
                EditText txtOpd2 = findViewById(R.id.txtOpd2);

                // 創建一個新的 Intent 物件
                Intent intent = new Intent(MainActivity.this, OpActivity.class);

                // 創建一個 Bundle 物件，用於存儲需要傳遞的數據
                Bundle bundle = new Bundle();

                // 將運算數字放入 Bundle 中
                bundle.putString("OPERAN001", txtOpd1.getText().toString());
                bundle.putString("OPERAN002", txtOpd2.getText().toString());

                // 將 Bundle 放入 Intent 中
                intent.putExtras(bundle);

                // 啟動新的 Activity 並等待結果
                startActivityForResult(intent, 1);
            }
        });
    }
}
