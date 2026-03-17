package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Intent intent = getIntent();

        String resume = "Nom : "     + safe(intent.getStringExtra("nom"))     +
                "\nEmail : " + safe(intent.getStringExtra("email"))   +
                "\nPhone : " + safe(intent.getStringExtra("phone"))   +
                "\nAdresse : "+ safe(intent.getStringExtra("adresse"))+
                "\nVille : " + safe(intent.getStringExtra("ville"));

        ((TextView) findViewById(R.id.recap)).setText(resume);
        findViewById(R.id.btnRetour).setOnClickListener(v -> finish());
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
