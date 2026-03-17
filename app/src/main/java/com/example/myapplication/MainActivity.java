package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nom, email, phone, adresse, ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom     = findViewById(R.id.nom);
        email   = findViewById(R.id.email);
        phone   = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        ville   = findViewById(R.id.ville);

        findViewById(R.id.btnEnvoyer).setOnClickListener(v -> envoyer());
    }

    private void envoyer() {
        String sNom   = nom.getText().toString().trim();
        String sEmail = email.getText().toString().trim();

        if (sNom.isEmpty() || sEmail.isEmpty()) {
            Toast.makeText(this, "Nom et Email sont obligatoires.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(this, Screen2Activity.class);
        i.putExtra("nom",     sNom);
        i.putExtra("email",   sEmail);
        i.putExtra("phone",   phone.getText().toString().trim());
        i.putExtra("adresse", adresse.getText().toString().trim());
        i.putExtra("ville",   ville.getText().toString().trim());
        startActivity(i);
    }
}