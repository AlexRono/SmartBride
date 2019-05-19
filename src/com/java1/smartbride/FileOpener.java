package com.java1.smartbride;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileOpener {
    static BufferedReader reader;
    static {
        try {
            reader = new BufferedReader(
new FileReader("D:\\Java_Projects\\Java_1\\smart bride\\FileSource\\ChallengersList.csv"));
        } catch (FileNotFoundException ex1){
            ex1.printStackTrace();
        }
    }

    Groom[] grooms = new Groom[20];
    int groomCount = 0;

    public Groom[] listGen(){
        try{

        while(true){

           String line = reader.readLine();

            if (line == null){
                break;
            }

            if (line.isEmpty()){
                continue;
            }

            if (groomCount >= grooms.length){
                Groom[] newGrooms = new Groom[grooms.length * 2];
                for (int i = 0; i < grooms.length; i++) {
                    newGrooms[i] = grooms[i];
                }
                grooms = newGrooms;
            }

            String[] cellStrings = line.split("[;,]");
            if (cellStrings.length >= 2){
                String name = cellStrings[0];
                int IQ = Integer.parseInt(cellStrings[1]);

                Groom groom = new Groom();
                groom.name = name;
                groom.iq = IQ;

                grooms[groomCount] = groom;
                groomCount++;
            }
        }
        reader.close();
        } catch (IOException ex2){ ex2.printStackTrace(); }

        Groom[] processedGrooms = new Groom[groomCount];
        System.arraycopy(grooms,0,processedGrooms,0,groomCount);
        return processedGrooms;
    }
}


