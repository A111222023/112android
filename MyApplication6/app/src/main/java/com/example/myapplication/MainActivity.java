package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view){
        EditText editName = (EditText) findViewById(R.id.editName);
        TextView txtShow = (TextView) findViewById(R.id.txtShow);
        String name = editName.getText().toString();
        txtShow.setText("你的名字"+name);
    }
}