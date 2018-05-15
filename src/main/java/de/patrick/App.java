package de.patrick;

import java.util.Scanner;

/**
 * Hello world!
 *Author Patrick Spang
 */
public class App 
{
	///Main Methode zum starten des Programms
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
