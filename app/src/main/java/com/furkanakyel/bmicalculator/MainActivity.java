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

        EditText editTextHeight = findViewById(R.id.height);
        EditText editTextWeight = findViewById(R.id.weight);
        Button button = findViewById(R.id.calculate_button);
        TextView textView = findViewById(R.id.result);
        TextView textIndex = findViewById(R.id.index);

        button.setOnClickListener(view -> {
            String heightStr = editTextHeight.getText().toString();
            String weightStr = editTextWeight.getText().toString();

            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                textIndex.setText(R.string.enter_height_weight);
                return;
            }

            try {
                float height = Float.parseFloat(heightStr) / 100;
                float weight = Float.parseFloat(weightStr);

                if (height == 0) {
                    textIndex.setText(R.string.height_cannot_be_zero);
                    return;
                }

                float bmi = weight / (height * height);
                textView.setText(String.valueOf(bmi));

                if (bmi == 0) {
                    textIndex.setText(R.string.invalid_value);
                } else if (bmi < 18.5) {
                    textIndex.setText(R.string.underweight);
                } else if (bmi < 25) {
                    textIndex.setText(R.string.normal_weight);
                } else if (bmi < 30) {
                    textIndex.setText(R.string.weight_above_normal);
                } else {
                    textIndex.setText(R.string.you_are_obese);
                }
            } catch (NumberFormatException e) {
                textIndex.setText(R.string.enter_valid_height_weight);
            }
        });
    }
}
