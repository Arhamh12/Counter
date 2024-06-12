package app;

import java.util.Scanner;

public class Ahmed {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean calc = true;
        while (calc) {
            
        
           System.out.println("What is your age?");
           int age = scnr.nextInt();
           System.out.println("What is your first name?");
           String name = scnr.next();

           System.out.println("Hello " + name + "! you were born at " +(2022-age));
           System.out.println("Am I correct?");
           String answer = scnr.next();
           

            System.out.println("Close system?(Y/N)");
            String calcs = scnr.next();
            if (calcs.equals("Y")) {
                System.out.println("GoodBye!");
                calc = false;
            }
        }
    }
    
}
