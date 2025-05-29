// Name: James Widner
// Class: CS3305/w03
// Term: Spring 2025
//Instructor: Prof. Wang
// Assignment: #1
// IDE: Visual Studio Code



public class Rectangle {
    private double width;
    private double height;

    public Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }

    public Rectangle (){
        width = 1.00;
        height = 1.00;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getArea(){
        return height*width;
    }
    public double getPerimeter(){
        return (width+height) * 2;
    }
    public String printRectangle(String objectName){
        return "Rectangle " + objectName + " is " + width + " units wide and " + height + " units high.";
    }
}
