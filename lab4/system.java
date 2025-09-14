public class Rectangle{
    private double  width,height;
    private static int numrectangel;

    public Rectangle(){
        this(1.0,2.0);
    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
        numrectangel++;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double h){
        height = h;
    }
    public void setWidth(double w){
        width = w;
    }
    }
public class system{
    public static void main(String[] args) {
        Rectangle rect;
        rect = new Rectangle();

        System.out.println("height = "+rect.getHeight());
        System.out.println
    }
    
}