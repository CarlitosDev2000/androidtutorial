package com.carloscordova.tutorial;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class RegisterActivity extends AppCompatActivity{
    private static final String LOG = "regsiterLayout";
    EditText usernameWrite;
    EditText passwordWrite;
    EditText mailWrite;
    EditText numberWrite;
    Button registerNow;
    Toast toastRegister;
    @Override
    protected void onCreate(Bundle RegisterField) {
        super.onCreate(RegisterField);
        Log.i(LOG, "++ ON CREATE ++");
        setContentView(R.layout.data_register);
        usernameWrite = findViewById(R.id.editTextUsername) ;
        passwordWrite = findViewById(R.id.editTextPassword);
        mailWrite = findViewById(R.id.editTextMail);
        numberWrite = findViewById(R.id.editTextNumber);
        registerNow = findViewById(R.id.buttonForRegister);
        registerNow.setOnClickListener(view ->{
            GetInformation();
        });
    }
    private void loadInformation(){
        SharedPreferences material = getSharedPreferences("saveInformation", Context.MODE_PRIVATE);
        String userSave = material.getString("username", "not info");
        String passwordSave = material.getString("password", "not info");
        String mailSave = material.getString("mail", "not info");
        String numberSave = material.getString("phoneNumber", "not info");
        usernameWrite.setText(userSave);
        passwordWrite.setText(passwordSave);
        mailWrite.setText(mailSave);
        numberWrite.setText(numberSave);
        loadInformation();
    }
    private void GetInformation(){
        SharedPreferences material = getSharedPreferences("saveInformation", Context.MODE_PRIVATE);
        String userSave = usernameWrite.getEditableText().toString();
        String passwordSave = passwordWrite.getEditableText().toString();
        String mailSave = mailWrite.getEditableText().toString();
        String numberSave = numberWrite.getEditableText().toString();
        SharedPreferences.Editor editor = material.edit();
        editor.putString("username", userSave);
        editor.putString("password", passwordSave);
        editor.putString("mail", mailSave);
        editor.putString("phoneNumber", numberSave);
        editor.apply();

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
