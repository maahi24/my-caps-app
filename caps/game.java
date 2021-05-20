package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class game {
    private CountryDB db;


    public game() {
        this.db = new CountryDB();

    }

    public String qa() {
        List<String> capitals = db.getCapitals();

        int n = capitals.size();
        int index = (int) (Math.random() * (n + 1));
        String c = capitals.get(index);
        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        if (Math.random() < 0.5) {
            String w = "What is the capital of " + ref.getName() + "?" + "\n" + c;
            return w;



        } else {
          String x= c + "is the capital of ?"+"\n" + ref.getName();
          return x;
        }

    }
}




