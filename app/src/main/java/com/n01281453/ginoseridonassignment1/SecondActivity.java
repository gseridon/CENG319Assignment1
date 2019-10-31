package com.n01281453.ginoseridonassignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // Make sure this method is before super.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Return button
        Button returnButton = findViewById(R.id.returnbutton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Get the message from main.
        processData();

    }

    public void processData()
    {
        Bundle extras = getIntent().getExtras();

        if (extras == null) { return; }
        String studentID = extras.getString("STUDENT_ID");
        String secretMessage = extras.getString("SECRET_MESSAGE");

        if (studentID != null)
        {
            TextView sIDvalue = (TextView) findViewById(R.id.sentSID);
            sIDvalue.setText(studentID);
        }

        if (secretMessage != null)
        {
            TextView secretMessageValue = (TextView) findViewById(R.id.sentMessage);
            secretMessageValue.setText(secretMessage);
        }

    }
}
