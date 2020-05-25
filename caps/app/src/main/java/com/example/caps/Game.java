package com.example.caps;
import android.view.View;
import android.widget.EditText;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private String question;
    private Game game;
    private String answer;
    private int score;
    private int qNum;
    public static void main(String args[])
    {

        CountryDB db = new CountryDB();
        List<String> capitals = db.getCapitals();
        System.out.println(capitals.size());
        String c = capitals.get(107);
        System.out.println(c);

        Map<String, Country> data= db.getData();
        System.out.println(data.size());
        Country ref= data.get(c);
        System.out.println(ref.toString());




    }
    private CountryDB db;

    public Game()
    {
        this.db=new CountryDB();
        this.qa();
    }
    public String qa()
    {
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index =(int)(n * Math.random());
        String c = capitals.get(index);
        System.out.println(c);
        Map<String, Country> map = db.getData();
        Country ref= map.get(c);

        if(Math.random()<0.5)
        {
            question = "What is the capital of " + ref.getName() + "\n" + ref.getCapital();
        }
        else
        {
            question = ref.getCapital() + " is the capital of" + "\n" + ref.getName();
        }
        return question;
    }

}
