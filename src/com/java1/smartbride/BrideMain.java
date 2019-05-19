package com.java1.smartbride;

import java.util.Scanner;

public class BrideMain {
    public static void main(String[] args) {

        FileOpener incomingFile = new FileOpener();
        Groom[] sortedApplicants = sortGroom(incomingFile.listGen());
        displayGroom(sortedApplicants);
    }

    public static Groom[] sortGroom(Groom[] incoming){
        int iterationCount = incoming.length;
        boolean isSorted;
        do {
            isSorted = false;
            for (int i = 0; i < iterationCount - 1; i++) {
                if (incoming[i].iq < incoming[i+1].iq){
                    Groom temp = incoming[i+1];
                    incoming[i+1] = incoming[i];
                    incoming[i] = temp;
                    isSorted = true;
                }
            }
            iterationCount = iterationCount - 1;

        } while (isSorted != false);
        return incoming;
    }

    public static void displayGroom(Groom[] applicants){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello!");
        System.out.println("This program allows you to choose a groom by IQ.");
        System.out.println("We prepared a list of " + applicants.length + " possible grooms for you.");
        System.out.println("They are already sorted by IQ.");
        System.out.println("Please specify how many applicants you would like to see:");
        int groomQuantity = sc.nextInt();
        while (groomQuantity > applicants.length){
            System.out.println("We have only " + applicants.length + " people in the list.");
            System.out.println("Please specify a number between 0 and " + applicants.length);
            groomQuantity = sc.nextInt();
        }
        for (int groomN = 0; groomN < groomQuantity; groomN++) {
            System.out.println("№" + (groomN+1) + applicants[groomN].toString());
        }
    }
}
