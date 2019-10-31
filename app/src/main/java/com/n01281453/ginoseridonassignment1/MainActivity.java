package com.n01281453.ginoseridonassignment1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /* To set up splash screen:
    - set the AppTheme.Launcher Theme in styles.xml, use launch_screen in drawable directory
    - Create the splash screen .xml
    - use the Launcher defined in styles as the startup theme (Do this in AndroidManifest.xml)
    - Set up the Theme with Launch Theme in onCreate method in the MainActivity.java
    */

    /* Changing the app's icon:
    - upload the icon into drawable
    - set the android:icon="@drawable/iconname" in AndroidManifest.xml
    - set the android:roundIcon="@drawable/iconname" in AndroidManifest.xml
    */

    /* Setting multiple activities:
    - Don't forget to add them as <activity android:name=".NewActivity" />
    - Remember your imports and "extends AppCompatActivity"
    - Have a .xml file for the layout of the new activity in layout folder; use this for setContentView
    */


    /* Other notes:
    - Use android:inputType="textPassword" for a password textview
    - Use android:hint="Message" to do a placeholder(hint) text
    */

    FloatingActionButton fab;
    EditText studentID;
    EditText secretMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        findAllView();
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(MainActivity.this,SecondActivity.class);
                sendIntent.putExtra(getString(R.string.studentID_Intent), String.valueOf(studentID.getText()));
                sendIntent.putExtra(getString(R.string.message_intent), String.valueOf(secretMessage.getText()));
                startActivity(sendIntent);
            }
        });
    }

    private void findAllView() {
        fab = findViewById(R.id.fab);
        studentID = findViewById(R.id.enterName);
        secretMessage = findViewById(R.id.enterMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.quit) {
            finishAndRemoveTask(); // Quits
        }

        return super.onOptionsItemSelected(item);
    }
}
