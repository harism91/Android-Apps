package com.example.mcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mcalc.MortgageModel;


public class MainActivity extends AppCompatActivity
{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    public void buttonClicked(View v)
    {

        String p = ((EditText) findViewById(R.id.pBox)).getText().toString();
        String n = ((EditText) findViewById(R.id.aBox)).getText().toString();
        String r = ((EditText) findViewById(R.id.iBox)).getText().toString();


        MortgageModel model = new MortgageModel(p, n, r);
        String answer = "$"+model.computeExactPayment();

        ((TextView) findViewById(R.id.answer)).setText(answer);

    }

}