/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.olamundo;

/**
 *
 * @author evyla
 */
public class OlaMundo {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String carros[] = new String[5];

        for (int j = 0; j < carros.length; j++) {
            System.out.println(carros[j]);
            System.out.println(j);
        }
        
        int i = 0;
        while (i < carros.length) {
            System.out.println(carros[i]);
            System.out.println(i);
        }
    }
}
