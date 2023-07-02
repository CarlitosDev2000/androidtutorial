package com.carloscordova.tutorial;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mainActvity";
    ConstraintLayout layout;
    String holaString;
    String adiosString;
    Button buttonOne;
    Button buttonTwo;
    TextView holaTextView;
    int originalColor;
    boolean isColorChanged = false;
    boolean primerTexto = true;
    String[] messages = {"Hello", "Bye"};
    int messageIndex = 0;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "++ ON CREATE ++");
        setContentView(R.layout.activity_main);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonToEnter);
        holaTextView = findViewById(R.id.hola);
        holaString = getResources().getString(R.string.titleName);
        adiosString = getResources().getString(R.string.titleNameTwo);
        layout = findViewById(R.id.primerLayout);
        originalColor = ContextCompat.getColor(this, R.color.yellow);
        buttonOne.setOnClickListener(view -> {
            if (toast != null) {
                toast.cancel();
            }
            String message = messages[messageIndex];
            toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
            toast.show();
            messageIndex = (messageIndex + 1) % messages.length;

            if (holaTextView.getText().equals(holaString)){
                holaTextView.setText(adiosString);
            }else {
                holaTextView.setText(holaString);
            }
            isColorChanged = !isColorChanged;
            int backgroundColor = isColorChanged ? ContextCompat.getColor(this, R.color.turquoise) : originalColor;
            layout.setBackgroundColor(backgroundColor);
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CompleteRequest.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
         Log.i(TAG, "+++ ON START +++");
    }

    @Override
    public void onResume() {
        super.onResume();
         Log.i(TAG, "+ ON RESUME +");
    }

    @Override
    public void onPause() {
        super.onPause();
         Log.i(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
         Log.i(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         Log.i(TAG, "- ON DESTROY -");
    }

}