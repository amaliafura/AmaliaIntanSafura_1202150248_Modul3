package com.example.android.amaliaintansafura_1202150248_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {
    private EditText mUsername; //
    private EditText mPassword;
    public static final String EXTRA_MESSAGE = "resii";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mUsername = (EditText) findViewById(R.id.username); //memanggil id editText di .xml
        mPassword = (EditText) findViewById(R.id.password);
    }

    public void onSignIn(View view) {
        String user = mUsername.getText().toString(); //membuat variabel user dan pass utnuk menampung hasil get id username damn password
        String pass = mPassword.getText().toString();
        if(user.equals("EAD") && pass.equals("MOBILE")) {
            Intent intent = new Intent(this, MainActivity.class); //proses saat login berjalan
            intent.putExtra(EXTRA_MESSAGE, user);
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(this, "Gagal Login", Toast.LENGTH_SHORT);//proses saat password yang kita masukkan salah
            toast.show();
        }
    }
}
