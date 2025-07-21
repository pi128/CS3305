using System;

public class Program {
    public static void Main(string[] args){
        Rectangle myRectangle = new Rectangle();

        Console.Write("Enter width for your rectangle: ");
        double userWidth = Convert.ToDouble(Console.ReadLine());

        Console.Write("Enter height for your rectangle: ");
        double userHeight = Convert.ToDouble(Console.ReadLine());

        Rectangle userRectangle = new Rectangle(userWidth, userHeight);

        Console.WriteLine($"The are of my rect is {userRectangle.GetArea():0.00}");
        userRectangle.GetArea();
    }
}