package com.example.user.taller2;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Carros>carros = new ArrayList<>();
    public static void agregar (Carros c){
        carros.add(c);
    }
    public static ArrayList<Carros> obtener(){
        return carros;
    }
}
