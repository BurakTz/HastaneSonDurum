package com.example.hastanedemo2;

import javafx.application.Application;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Hastalar> hasta=Hastalar.getHastalar();
        for(Hastalar h:hasta){
            System.out.println(h.isim);
        }





    }
}