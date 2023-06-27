package com.carloscordova.tutorial;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mainActvity";
    ConstraintLayout layout;
    String holaString;
    String adiosString;
    Button buttonOne;
    TextView holaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "++ ON CREATE ++");
        setContentView(R.layout.activity_main);
        buttonOne = findViewById(R.id.buttonOne);
        holaTextView = findViewById(R.id.hola);
        holaString = getResources().getString(R.string.titleName);
        adiosString = getResources().getString(R.string.titleNameTwo);
        layout = findViewById(R.id.primerLayout);
        buttonOne.setOnClickListener(view -> {
            Toast.makeText(this, "Hola",Toast.LENGTH_LONG ).show();
            if (holaTextView.getText().equals(holaString)){
                holaTextView.setText(adiosString);
            }else {
                holaTextView.setText(holaString);
            }
            layout.setBackgroundColor(getColor(R.color.turquoise));

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