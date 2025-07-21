public class Rectangle {
    private double width;
    private double height;

    public Rectangle(){
        width = 1.0;
        height = 1.0;
    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double GetWidth(){
    return this.width;
    }

    public double GetHeight(){
        return this.height;
    }

    public double GetArea(){
        return this.width * this.height;
    }

    public double GetPerimeter(){
        return 2 * (this.width + this.height);
    }

    public void printRectangle(String objectName){
        Console.WriteLine( "Rectangle "+ objectName + " is " + this.width + " units wide and " + this.height + " units high.");
    }
}