package de.patrick;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Groﬂbuchstaben eingeben:" );
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String output = input.toUpperCase();
        System.out.println(output);
        scan.close();
    }
}
