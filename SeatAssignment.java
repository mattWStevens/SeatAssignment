/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatassignment;
import java.util.Scanner;

/**
 *
 * @author mstevens
 */
public class SeatAssignment 
{ 
    public static void main(String[] args) 
    {
        Airplane a = new Airplane();
        Scanner input = new Scanner(System.in);
        
        boolean running = true;
        
        a.showSeating();
        
        System.out.println();
        System.out.println();
        
        String choice = "";
        
        while (running)
        {
            System.out.println("Would you like to: ");
            System.out.println();
            System.out.println("Add a passenger (A)");
            System.out.println("Show the available seating (S)");
            System.out.print("Or quit (Q): ");
            
            choice = input.nextLine();
            
            choice = choice.toUpperCase();
            
            if (choice.equals("A"))
            {
                System.out.println();
                a.addPassengers();
                
                System.out.println();
                System.out.println();
                
                running = a.quit();
                System.out.println();
            }
            
            if (choice.equals("S"))
            {
                System.out.println();
                a.showSeating();
                
                System.out.println();
                System.out.println();
                
                running = a.quit();
                System.out.println();
            }
            
            if (choice.equals("Q"))
            {
                System.out.println();
                System.out.println("System now exiting...");
                break;
            }
        }
    }  
}
