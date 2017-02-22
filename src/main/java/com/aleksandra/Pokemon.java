package com.aleksandra;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Pokemon {
    private int _id;
    private String _name;
    private int _attack;
    private int _defence;
    private int _health;

    public Pokemon(String name) throws IOException {
        URL url = new URL("http://pokeapi.co/api/v2/pokemon/"+ name);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String jsonString = "";

        while(true){
            String line = in.readLine();

            if(line == null){
                break;
            }

            jsonString+= line;
        }

        JSONObject json = new JSONObject(jsonString);
        _name = json.getString("name");
        _id = json.getInt("id");
        _attack = json.getJSONArray("stats").getJSONObject(4).getInt("base_stat");
        _defence = json.getJSONArray("stats").getJSONObject(3).getInt("base_stat");
        _health = json.getJSONArray("stats").getJSONObject(5).getInt("base_stat");
    }
    public void wypisz(){
        System.out.println("name: "+ _name);
        System.out.println("id: "+ _id);
        System.out.println("attack: "+ _attack);
        System.out.println("defence: "+ _defence);
        System.out.println("health: "+ _health);
    }
}

