package com.example.appsdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtuser, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);
    }

    public void iniciar(View view) {
        if (txtuser.getText().toString().isEmpty() || txtpass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete Campos!", Toast.LENGTH_LONG).show();

        } else if (txtuser.getText().toString().equals("admin") && txtpass.getText().toString().equals("123")){
            Intent i = new Intent(this, PrincipalActivity.class);
            startActivity(i);
            String user = txtuser.getText().toString();
            txtuser.setText("");
            txtpass.setText("");
        }else{
            Toast.makeText(this, "Usuario no valido!", Toast.LENGTH_LONG).show();
        }
    }

    public void AcercaDe(View view) {
        Intent i = new Intent(this, Developers.class);
        startActivity(i);
    }
}