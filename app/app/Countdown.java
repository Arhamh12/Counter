package app;

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.Scanner;

public class Countdown {
    
    public static void main(String[] args) {

        String x = "Hello!";
        String xx = x;
        
        for (int i = xx.length()-1; i < xx.length(); i--) {
            if (xx.length() == 0) {
                break;
                
            }
             
            System.out.println(xx.substring(0, x.length()-1));   
        }
    }

    
   
}