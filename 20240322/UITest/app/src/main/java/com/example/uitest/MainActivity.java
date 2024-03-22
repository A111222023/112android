package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }
    public void sendString(View view){
        EditText editinput = (EditText) findViewById(R.id.editinput);
        String btnSend = editinput.getText().toString();

        Intent intent = new Intent(this,DisplayStringActivity.class);
        intent.putExtra ("userinput",btnSend);
        startActivity(intent);
    }
}
