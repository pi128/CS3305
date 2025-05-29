// Name: James Widner
// Class: CS3305/w03
// Term: Spring 2025
//Instructor: Prof. Wang
// Assignment: #1
// IDE: Visual Studio Code

package vowel;

import java.util.Scanner;

public class vowels {
   
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean sent = true;
        String inputStr = "";
        while (sent){
            System.out.print("-----MAIN MENU-----\n" + //
                    "1. Read input string\n" + //
                    "2. Compute number of vowels\n" + //
                    "3. Exit program\n" + //
                    "Enter option number: ");
            int resp = scan.nextInt();
            scan.nextLine();
            System.out.println();
            
            
            switch (resp){
                case 1 -> {
                    System.out.print("Enter a string: ");
                    inputStr = scan.nextLine();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("You entered string: " + inputStr + "\nNumber of vowels:   " + countVowels(inputStr));
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Shutting down...");
                    scan.close();
                    sent = false;
                    
                }
            }
        }

    }
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char first = Character.toLowerCase(str.charAt(0));
        int count;

        if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
            count = 1;
        } else {
            count = 0;
        }
        return count + countVowels(str.substring(1));       
    }
}
