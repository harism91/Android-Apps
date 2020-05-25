package com.example.kryptonote;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ca.roumani.i2c.Utility;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onEncrypt(View v)
    {
        String key = ((EditText)findViewById(R.id.key)).getText().toString();
        String data = ((EditText)findViewById(R.id.data)).getText().toString();

        Cipher cy = new Cipher(key);
        String result = cy.Encrypt(data);

        ( (TextView)findViewById(R.id.data)).setText(result);
    }
    public void onDecrypt(View v)
    {
        String key = ((EditText)findViewById(R.id.key)).getText().toString();
        String data = ((EditText)findViewById(R.id.data)).getText().toString();

        Cipher cy = new Cipher(key);
        String result = cy.Decrypt(data);

        ( (TextView)findViewById(R.id.data)).setText(result);
    }


    public void onSave(View v) throws IOException
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast label = Toast.makeText(this, "Note saved.", Toast.LENGTH_LONG);
            label.show();
        }
        catch (Exception e)
        {
            Toast label =Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

    public void onLoad(View v) throws IOException
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show = "";
            for (int c = fr.read(); c != -1; c = fr.read())
            {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
            Toast label = Toast.makeText(this, "Note Loaded.", Toast.LENGTH_LONG);
            label.show();
        }catch (Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }
}
