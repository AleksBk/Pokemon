package com.aleksandra;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class App {
    public static void main(String[] argv) {
        try {
            Pokemon pokemon = new Pokemon("charizard");
            pokemon.wypisz();
        } catch (IOException e) {
            e.printStackTrace();
        }

 
}
