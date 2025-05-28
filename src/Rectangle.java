public class Rectangle {
    private double width = 1.00;
    private double height = 1.00;

    public Rectangle (double width, double height){
        this.width = width;
        this.height = height;

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
    public String printRectangle(String objectName, Rectangle r){
        return "Rectangle " + objectName + " is " + r.getWidth() + " units wide and " + getHeight() + " units high.";
    }
}
