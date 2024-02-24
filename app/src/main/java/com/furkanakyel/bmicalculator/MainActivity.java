package com.furkanakyel.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        button.setOnClickListener(view -> {
            String boyStr = editTextHeight.getText().toString();
            String kiloStr = editTextWeight.getText().toString();

            if (boyStr.isEmpty() || kiloStr.isEmpty()) {
                textIndex.setText(R.string.boyunu_kilonuzu_giriniz);
                return;
            }

            try {
                float boy = Float.parseFloat(boyStr) / 100;
                float kilo = Float.parseFloat(kiloStr);

                if (boy == 0) {
                    textIndex.setText(R.string.boy_sifir_olamaz);
                    return;
                }

                float bmi = kilo / (boy * boy);
                textView.setText(String.valueOf(bmi));

                if (bmi == 0) {
                    textIndex.setText(R.string.hatali_deger_girdiniz);
                } else if (bmi < 18.5) {
                    textIndex.setText(R.string.zayifsiniz);
                } else if (bmi < 25) {
                    textIndex.setText(R.string.kilonuz_normal);
                } else if (bmi < 30) {
                    textIndex.setText(R.string.kilonuz_normalin_ustunde);
                } else {
                    textIndex.setText(R.string.obezsiniz);
                }
            } catch (NumberFormatException e) {
                textIndex.setText(R.string.gecerli_boy_kilo);
            }
        });
    }
}
