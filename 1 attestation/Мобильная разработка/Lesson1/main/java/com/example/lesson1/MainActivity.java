package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnOutputText;
    TextView txtViewOutputText;
    EditText editTextPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOutputText = findViewById(R.id.btnOutputText);
        txtViewOutputText = findViewById(R.id.txtViewOutputText);
        editTextPersonName = findViewById(R.id.editTextPersonName);

        btnOutputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtViewOutputText.setText(editTextPersonName.
                        getText().toString() + " is learning Android development!");
            }
        });

    }


}