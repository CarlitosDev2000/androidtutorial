package com.carloscordova.tutorial;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class CompleteRequest extends AppCompatActivity {
    private static final String LOG = "information_layout";
    ConstraintLayout secondLayout;
    EditText username;
    EditText paasword;
    Button buttonLogin;
    Button buttonRegister;
    @Override
    protected void onCreate(Bundle entraceField) {
        super.onCreate(entraceField);
        Log.i(LOG, "++ ON CREATE ++");
        setContentView(R.layout.information_layout);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);
        username = findViewById(R.id.editTextText2);
        paasword = findViewById(R.id.editTextTextPassword2);
        buttonLogin.setOnClickListener (view -> {
            if (username.getEditableText().toString().equals("carlitos") && paasword.getEditableText().toString().equals("carlitos")){
                Toast.makeText(CompleteRequest.this, "Login successfull", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(CompleteRequest.this, "LOGIN FAILED", Toast.LENGTH_LONG).show();

            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteRequest.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i(LOG, "+++ ON START +++");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(LOG, "+ ON RESUME +");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(LOG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(LOG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG, "- ON DESTROY -");
    }
}
