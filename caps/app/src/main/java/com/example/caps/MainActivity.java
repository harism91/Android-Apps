package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ca.roumani.i2c.Utility;


import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum ;
    private String log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        qNum = 1;
        answer="";
        log="";
        game= new Game();
        ask();
    }
    private void ask ()
    {
        ((TextView)findViewById(R.id.score)).setText("Score = " + score);
        ((TextView)findViewById(R.id.qNum)).setText("Q# " + qNum);
        ((EditText)findViewById(R.id.answer)).setText("");
        String qNa = game.qa();
        String [] r = qNa.split("\\r?\\n");
        question = r[0];
        answer = r[1];
        ((TextView)findViewById(R.id.question)).setText(question);
    }

    public void onDone (View v)
    {
        String s=((EditText)findViewById(R.id.answer)).getText().toString();

        if(s.equalsIgnoreCase(answer)){
            score++;
            ((TextView)findViewById(R.id.score)).setText("Score = " + score);
        }
        log+="Q#" +qNum+":"+question+"\n"+"Your Answer= "+s+"\n Correct Answer = "+answer+"\n";
        ((TextView)findViewById(R.id.log)).setText(log);
        qNum++;
        ask();
        if(qNum == 10)
        {
            finish();
        }
    }
    public void finish()
    {
        findViewById(R.id.done).setEnabled(false);
        ((TextView)findViewById(R.id.qNum)).setText("Game Over");
    }

}
