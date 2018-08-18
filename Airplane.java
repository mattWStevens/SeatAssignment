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
public class Airplane 
{
    private int[] firstSeats;
    private int[] econSeats;
    private int firstLeft;
    private int econLeft;
    private int firstIndex;
    private int econIndex;
    
    public Airplane()
    {
        firstSeats = new int[20];
        econSeats = new int[90];
        firstLeft = 20;
        econLeft = 90;
        firstIndex = 0;
        econIndex = 0;
        
        for (int i = 0; i < firstSeats.length; i++)
        {
            firstSeats[i] = 0;
        }
        
        for (int i = 0; i < econSeats.length; i++)
        {
            econSeats[i] = 0;
        }
    }
    
    public void addPassengers()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Would you like First Class or " + 
                           "Economy? (first/economy): ");
        
        String answer = input.nextLine();
        answer = answer.toLowerCase();
        
        if (answer.equals("first"))
        {
            System.out.print("Would you like to purchase tickets for " +
                               "1 or 2 passengers?: ");
            int num = input.nextInt();
            
            if (num > 2)
            {
                System.out.println("Sorry, you may not purchase " +
                                   "more than 2 tickets.");
            }
            
            else
            {  
                addFirst(num);  
            }
        }
        
        else
        {
            System.out.print("You may purchase 1 to 3 tickets, " +
                               "how many would you like?: ");
            int num = input.nextInt();
            
            if (num > 3)
            {
                System.out.println("Sorry, you may not purchase " +
                                   "more than 3 tickets.");
            }
            
            else
            {
                addEcon(num); 
            }
        }
    }
    
    private void addFirst(int numPass)
    {
        if (firstLeft - numPass < 0 || firstLeft == 0)
        {
            System.out.println("Sorry, we do not have enough " +
                               "spaces left.");
        }
        
        else
        {
            firstLeft -= numPass;
            
            for (int i = 0; i < numPass; i++)
            {
                firstSeats[firstIndex] = 1;
                firstIndex++;
            }
        }
    }
    
    private void addEcon(int numPass)
    {
        if (econLeft - numPass < 0 || econLeft == 0)
        {
            System.out.println("Sorry, we do not have enough " + 
                               "spaces left.");
        }
        
        else
        {
            econLeft -= numPass;
            
            for (int i = 0; i < numPass; i++)
            {
                econSeats[econIndex] = 1;
                econIndex++;
            }
        }
    }
    
    public boolean quit()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Would you like to continue? (yes/no): ");
        String answer = input.nextLine();
        answer = answer.toLowerCase();
        
        if (answer.equals("yes"))
        {
            return true;
        }
        
        else
        {
            System.out.println();
            System.out.println("System exiting...");
            return false;
        }
    }
    
    private void showFirstSeating()
    {
        System.out.println("First Class:");
        System.out.println("--------------");
        
        int count = 0;
        int i = 0;
        
        while (i < firstSeats.length)
        {
            if (count == 2)
            {
                System.out.print("\t");
                count++;
            }
            
            else
            {
                if (count == 5)
                {
                    System.out.println("\n");
                    count = 0;
                }
                
                else    
                {
                    System.out.print(firstSeats[i]);
                    i++;
                    count++;
                }
            }
        }
    }
    
    private void showEconSeating()
    {
        System.out.println();
        System.out.println();
        System.out.println("Economy Class:");
        System.out.println("-----------------");
        
        int eCount = 0;
        int j = 0;
        
        while (j < econSeats.length)
        {
            if (eCount == 3)
            {   
                System.out.print("\t");
                eCount++;
            }
            
            else
            {
                if (eCount == 7)
                {
                    System.out.println("\n");
                    eCount = 0;
                }
                
                else
                {
                    System.out.print(econSeats[j]);
                    j++;
                    eCount++;
                }    
            }
        }
    }
    
    public void showSeating()
    { 
        showFirstSeating();
        showEconSeating();
    }      
}