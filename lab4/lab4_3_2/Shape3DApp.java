package lab4_3_2;
import java.util.Scanner;


class Sphere extends circle{

    public Sphere(){
        super(0);
    }
    public static Sphere createsSphere(){

        Sphere sp = new Sphere();
        circle cr = circle.createCircle();

        sp.radius = cr.radius;

        return sp;

    }
    @Override
    public double calVolume(){

        return ((4.0/3.0)*Math.PI*this.radius*this.radius*this.radius);

    }

    public double  surfacearea(){

        return (4* Math.PI * this.radius*this.radius);
    }

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////


class pyramid extends triangle{


    public pyramid(){
        super(0,0);

    }

    public static  pyramid createPyramid(){

        pyramid py = new pyramid();
        triangle tri = triangle.createtriangle();
        py.base = tri.base;
        py.height = tri.height;

        return py;

    }
    @Override
    public  double calVolume(){

        return (this.base*this.base*this.height*(1.0/3.0));

    }

}
//////////
/// 
/// ////////////////////////////////////////////////////////////////////////////////
/// 
/// 

class cuboid extends rectangle{

    int thick;

    public cuboid(){
        super(0,0);
    }

    public static cuboid createCuboid(){
        cuboid cd = new cuboid();
        rectangle rc = rectangle.createRectangle();

        cd.base = rc.base;
        cd.height= rc.height;

        Scanner sc = new Scanner(System.in);
            System.out.println( "please input the thickness of the cuboid \n" );
            cd.thick = sc.nextInt();

        return cd;
    }
    @Override
    public  double calVolume(){

        return (super.findarea()*thick);

    }   


}
//////////////////////////////////////////////////////////////////////////
class cone implements shape{ //VOLUME NOT IMPLEMENTED
    triangle tri;
    circle cr;

    public static cone creatCone(){
        cone cone = new cone();
        cone.tri = triangle.createtriangle();
        cone.tri.base = cone.tri.base/2;
        cone.cr = new circle(cone.tri.base);
        return cone;
    }

    public double surfacearea(){
        double slant;
        slant = Math.sqrt(this.tri.base*this.tri.base + this.tri.height*this.tri.height);
        return (Math.PI*this.cr.radius*this.cr.radius + Math.PI*this.cr.radius*slant);

    }
    @Override
    public double findarea(){
        return -1;
    }
    @Override
    public double calVolume(){
        return -1;
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////


class cylinder implements shape{  //VOLUME NOT IMPLEMENTED
    circle cir;
    int height;
    
    public static cylinder createCylinder(){
        Scanner sc = new Scanner(System.in);
        cylinder cylinder = new cylinder();
        cylinder.cir = circle.createCircle();
        System.out.println( "please input the height of the cylinder \n" );
        cylinder.height = sc.nextInt();
        return cylinder;
    }

    public double surfacearea(){
        double a,b;

        a = 2 * Math.PI * this.cir.radius*this.height; //2pirh
        b = 2 * Math.PI * this.cir.radius *this.cir.radius; //2pir^2

        return (a+b);

    }
    @Override
    public double findarea(){
        return -1;
    }
    @Override
    public double calVolume(){
        return -1;
    }

}



////////////////////////////////////////////////////////////////
public class Shape3DApp {
    public static void main(String[] args) {
        
        int numOfShapes=0;
        int count = 0;
        shape[] shapeList = null;

        while (true){
            int choice = 0;
            System.out.println("""

                ----------------MAIN MENU-------------------------------------------------------------------------------------------

                (1) input the total number of shapes: \n
                (2) choose the shape and enter the required dimension/s for the selected 3D shape(s) \n
                (3) choose the type of calculation \n
                (4) end

                ---------------------------------------------------------------------------------------------------------------------
                """);
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("input the total number of 3D shapes: \n");
                    numOfShapes = sc.nextInt();

                    shapeList = new shape[numOfShapes];
                    break;
                
                case 2:
                    int temp = numOfShapes;
                    while ( temp > 0 ){

                        int choice2 = 0;
                        

                        System.out.println("""
                            Please Choose The Shape: \n
                            (1) Pyramid \n
                            (2) Cuboid \n
                            (3) Sphere \n
                            (4) Cone \n
                            (5) Cylinder \n

                            *input a number outside 1-3 to exit choice menu \n
                        """);

                        choice2 = sc.nextInt();

                        System.out.println("CHOICE 2 = " +choice2 +"\n");

                        switch (choice2){
                            case 1: 
                                pyramid pr = pyramid.createPyramid();
                                shapeList[count] = pr;
                                count ++;
                                break;

                            case 2:
                                cuboid cd = cuboid.createCuboid();
                                shapeList[count] = cd;
                                count ++;
                                break;

                            case 3:
                                Sphere sp = Sphere.createsSphere();
                                shapeList[count] = sp;
                                count ++;
                                break;

                            case 4:

                                cone co = cone.creatCone();
                                shapeList[count] = co;
                                count ++;
                                break;

                            case 5:

                                cylinder cr = cylinder.createCylinder();
                                shapeList[count] = cr;
                                count ++;
                                break;




                            default:
                                return;
                        }
                        temp -- ;
                    }

                    break;
                case 3:
                    int choice3;
                    System.out.println("""
                        Please Choose The calculation: \n
                        (1) Area \n
                        (2) Volume \n
                        (3) Sum of Surface areas of cones spheres and cylinders only

                        *input a number outside 1-2 to exit choice menu \n
                    """);

                    choice3 = sc.nextInt();

                    if (choice3 == 1){
                        double sum = 0;
                        for ( int index = 0 ; index < numOfShapes ; index++ ){ //while element exists;
                            //System.out.println( sum + "\n");
                            sum = sum + shapeList[index].findarea();
                        }

                        System.out.println("Total Area = " + sum + "\n");
                        
                    }

                    if (choice3 == 2){
                        double sum = 0;
                        for ( int index = 0 ; index < numOfShapes ; index++ ){ //while element exists;
                            //System.out.println( sum + "\n");
                            sum = sum + shapeList[index].calVolume();
                        }

                        System.out.println("Total volume = " + sum + "\n");
                    }

                    if (choice3 == 3){
                        double sAr = 0;
                        for ( int index = 0 ; index < numOfShapes ; index++ ){ //while element exists;
                            //System.out.println( sum + "\n");
                            if( (shapeList[index] instanceof Sphere)){

                                Sphere sphere = (Sphere) shapeList[index];

                                sAr = sAr + sphere.surfacearea();
                            }

                            if( (shapeList[index] instanceof cylinder)){

                                cylinder cylinder = (cylinder) shapeList[index];

                                sAr = sAr + cylinder.surfacearea();
                            }

                            if( (shapeList[index] instanceof cone)){

                                cone cone = (cone) shapeList[index];

                                sAr = sAr + cone.surfacearea();
                            }

                            else{
                            }

                            
                        }

                        System.out.println("Total suface area = " + sAr + "\n");


                    }

                    else{
                        break;
                    }


                    default:
                        return;
            }


            
        }

    }
}
