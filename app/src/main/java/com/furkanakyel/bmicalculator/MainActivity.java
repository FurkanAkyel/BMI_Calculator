package com.furkanakyel.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextHeight = findViewById(R.id.boy);
        EditText editTextWeight = findViewById(R.id.kilo);
        Button button = findViewById(R.id.hesapla);
        TextView textView = findViewById(R.id.sonuc);
        TextView textIndex = findViewById(R.id.index);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float boy = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float kilo = Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmi = kilo / (boy * boy);
                textView.setText(String.valueOf(bmi));
                if(bmi < 18.5) {
                    textIndex.setText("Zayıfsınız");
                }else if (bmi < 25) {
                    textIndex.setText("Kilonuz normal");
                }else if (bmi < 30) {
                    textIndex.setText("Kilonuz normalin üstünde");
                }else {
                    textIndex.setText("Obezsiniz");
                }
            }
        });
    }
}