package com.example.alterdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private String[] items = {"Samsung", "Oppo", "Apple", "ASUS"};
    private boolean[] itemsChecked = {false, true, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於本書")
                        .setMessage("Android程式設計與應用\n作者:陳惠安\n教師:恰克虎")
                        .setCancelable(false)
                        .setPositiveButton("確定", null)
                        .show();
            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認")
                        .setMessage("確認結束本程式")
                        .setPositiveButton("確定", MainActivity.this)
                        .setNegativeButton("取消", MainActivity.this)
                        .show();
            }
        });

        Button btnColor = findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇一個顏色")
                        .setItems(new String[]{"紅色", "黃色", "綠色"}, MainActivity.this)
                        .setNegativeButton("取消", MainActivity.this)
                        .show();
            }
        });

        Button btnSelect = findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選單")
                        .setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // Handle item clicks if needed
                            }
                        })
                        .setPositiveButton("確定", null)
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                finish();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(MainActivity.this, "取消退出", Toast.LENGTH_SHORT).show();
                break;
            case 0:
                findViewById(R.id.btnColor).setBackgroundColor(Color.RED);
                break;
            case 1:
                findViewById(R.id.btnColor).setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                findViewById(R.id.btnColor).setBackgroundColor(Color.GREEN);
                break;
        }        String msg="";
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                for(int index=0;index<items.length;index++){
                    if (itemsChecked[index])
                        msg+=items[index]+"\n";
                }
               // TextView.txvShow=(TextView)
        }
    }
}