// Name: James Widner
// Class: CS3305/w03
// Term: Spring 2025
//Instructor: Prof. Wang
// Assignment: #1
// IDE: Visual Studio Code



import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Rectangle myRectangle = new Rectangle();

        
        System.out.print("Enter a width for your Rectangle: ");
        double width = scan.nextDouble();
        System.out.print("Enter a height for you Rectangle: ");
        double height = scan.nextDouble();

        Rectangle yourRectangle = new Rectangle(width, height);

        System.out.println("myRectangle:\n------------ ");
        System.out.println("Width:     " + myRectangle.getWidth());
        System.out.println("Height:    " + myRectangle.getHeight());
        System.out.println("Area:      " + myRectangle.getArea());
        System.out.println("Perimeter: " + myRectangle.getPerimeter());
        System.out.println();
        System.out.println(myRectangle.printRectangle("myRectangle"));
        System.out.println();

        System.out.println("yourRectangle:\n------------ ");
        System.out.println("Width:     " + yourRectangle.getWidth());
        System.out.println("Height:    " + yourRectangle.getHeight());
        System.out.println("Area:      " + yourRectangle.getArea());
        System.out.println("Perimeter: " + yourRectangle.getPerimeter());
        System.out.println();
        System.out.println(yourRectangle.printRectangle("yourRectangle"));
        
        scan.close();

    }
    
}
