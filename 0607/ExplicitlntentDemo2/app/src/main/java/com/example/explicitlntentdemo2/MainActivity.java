package com.example.explicitlntentdemo2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    ActivityResultLauncher launcher = registerForActivityResult(new ResultContract(), new ActivityResultCallback<String>() {
        @Override
        public void onActivityResult(String o) {
            output.setText("計算結果"+o);
        }
    });

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
    class ResultContract extends ActivityResultContract<Boolean,String >{

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean aBoolean) {
            Intent intent =new Intent(MainActivity.this, OpActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01",((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("OPERAND02",((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        public String parseResult(int i, @Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString();
        }
    }
}
