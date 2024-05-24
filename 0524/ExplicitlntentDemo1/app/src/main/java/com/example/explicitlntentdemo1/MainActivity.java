package com.example.S;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.explicitlntentdemo1.FActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtC = findViewById(R.id.txtC);
                int tempC = Integer.parseInt(txtC.getText().toString());
                EditText editText = findViewById(R.id.editTextText);

                // 創建一個新的 Intent 對象
                Intent intent = new Intent(MainActivity.this, FActivity.class);

                // 創建一個 Bundle 對象，用於存儲需要傳遞的數據
                Bundle bundle = new Bundle();

                // 將攝氏溫度和地點放入 Bundle 中
                bundle.putInt("TEMPC", tempC);
                bundle.putString("PLACE", editText.getText().toString());

                // 將 Bundle 放入 Intent 中
                intent.putExtras(bundle);

                // 啟動新的 Activity
                startActivity(intent);
            }
        });
    }
}