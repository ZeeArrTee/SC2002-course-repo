package lab4_3_2;

import java.util.Scanner;

    interface shape{
        public abstract double findarea();
        public abstract double calVolume();
    }
///////////////////////////////////////////////////////////////////////////////
    class triangle implements shape{
        int height;
        int base;

        public triangle(int height, int base){
            this.height = height;
            this.base = base;
        }

        public static triangle createtriangle(){
            int height2;
            int base2;

            Scanner sc = new Scanner(System.in);
            System.out.println( "please input the height of the triangle \n" );
            height2 = sc.nextInt();
            System.out.println( "please input the base of the triangle \n" );
            base2 = sc.nextInt();

            triangle tri = new triangle(height2,base2);
            //sc.close();
            return tri;

        }
        @Override
        public double findarea(){
            return (0.5 * base *height);
        }
        @Override
        public double calVolume(){
            return -1;
        }

    }
////////////////////////////////////////////////////////////////////////////
    class Square implements shape{
        int height;

        public Square(int height){
            this.height = height;
        }

        public static Square createSquare(){
            int height2;

            Scanner sc = new Scanner(System.in);
            System.out.println( "please input the length of the side of the square \n" );
            height2 = sc.nextInt();
      

            Square tri = new Square(height2);
            //sc.close();
            return tri;

        }
        @Override
        public double calVolume(){
            return -1;
        }
        @Override
        public double findarea(){
            return (height*height);
        }
    }
//////////////////////////////////////////////////////////////////////
    class rectangle implements shape{
        int height; //length
        int base; //breadth

        public rectangle(int height, int base){
            this.height = height;
            this.base = base;
        }

        public static rectangle createRectangle(){
            int height2;
            int base2;

            Scanner sc = new Scanner(System.in);
            System.out.println( "please input the height of the rectangle \n" );
            height2 = sc.nextInt();
            System.out.println( "please input the base of the rectangle \n" );
            base2 = sc.nextInt();

            rectangle tri = new rectangle(height2,base2);
            //sc.close();
            return tri;

        }
        @Override
        public double calVolume(){
            return -1;
        }
        @Override
        public double findarea(){
            return (base *height);
        }

    }
/////////////////////////////////////////////////////////////////////////////////////
    class circle implements shape{
        int radius;

        public circle(int radius){
            this.radius = radius;
        }

        public static circle createCircle(){
            int radius2;

            Scanner sc = new Scanner(System.in);
            System.out.println( "please input the radius of the circle \n" );
            radius2 = sc.nextInt();

            circle tri = new circle(radius2);
            //sc.close();
            return tri;

        }
        @Override
        public double calVolume(){
            return -1;
        }
        @Override
        public double findarea(){
            return (Math.PI*radius*radius);
        }

        

    }

    ///////////////////////////////////////////////////////////////////////////////
public class Shape2DApp {
        public static void main(String[] args) {

            int numOfShapes=0;
            int count = 0;
            shape[] shapeList = null;

            while (true){
                int choice = 0;
                System.out.println("""

                    ----------------MAIN MENU-------------------------------------------------------------------------------------------

                    (1) input the total number of shapes: \n
                    (2) choose the shape and enter the required dimension/s for the selected shape(s) \n
                    (3) choose the type of calculation \n
                    (4) end

                    ---------------------------------------------------------------------------------------------------------------------
                    """);
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("input the total number of shapes: \n");
                        numOfShapes = sc.nextInt();

                        shapeList = new shape[numOfShapes];
                        break;
                    
                    case 2:
                        int temp = numOfShapes;
                        while ( temp > 0 ){

                            int choice2 = 0;
                            

                            System.out.println("""
                                Please Choose The Shape: \n
                                (1) Triangle \n
                                (2) Square \n
                                (3) Rectangle \n
                                (4) Circle \n

                                *input a number outside 1-4 to exit choice menu \n
                            """);

                            choice2 = sc.nextInt();

                            System.out.println("CHOICE 2 = " +choice2 +"\n");

                            switch (choice2){
                                case 1: 
                                    triangle tr = triangle.createtriangle();
                                    shapeList[count] = tr;
                                    count ++;
                                    break;

                                case 2:
                                    Square sq = Square.createSquare();
                                    shapeList[count] = sq;
                                    count ++;
                                    break;

                                case 3:
                                    rectangle rc = rectangle.createRectangle();
                                    shapeList[count] = rc;
                                    count ++;
                                    break;

                                case 4:
                                    circle cr = circle.createCircle();
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
                            break;
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
