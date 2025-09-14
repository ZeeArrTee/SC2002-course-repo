package lab2;

import java.util.Scanner;
public class Lab2p1 {
    public static void main(String[] args)
    {
   int choice;
   Scanner sc = new Scanner(System.in);
   do {
        System.out.println("Perform the following methods:");
        System.out.println("1: miltiplication test");
        System.out.println("2: quotient using division by subtraction");
        System.out.println("3: remainder using division by subtraction");
        System.out.println("4: count the number of digits");
        System.out.println("5: position of a digit");
        System.out.println("6: extract all odd digits");
        System.out.println("7: quit");
        choice = sc.nextInt();

        switch (choice) {
            case 1: /* add mulTest() call */
            mulTest();
            break;
            case 2: /* add divide() call */
            System.out.print("m = ");
            int m = sc.nextInt();
            System.out.print("n = ");
            int n = sc.nextInt();
            divide(m,n);
            break;
            case 3: /* add modulus() call */
            System.out.print("m = ");
            int m1 = sc.nextInt();
            System.out.print("n = ");
            int n1 = sc.nextInt();
            modulus(n1,m1);
            break;
            case 4: /* add countDigits() call */
            System.out.print("n = ");
            int digi = sc.nextInt();
            countDigits(digi);
            break;
            case 5: /* add position() call */
            System.out.print("number = ");
            int num = sc.nextInt();
            System.out.print("postion = ");
            int num2 = sc.nextInt();
            position(num,num2);
            break;
            case 6: /* add extractOddDigits() call */
            System.out.print("numer = ");
            int n2 = sc.nextInt();
            extractOddDigits(n2);
            break; 
            case 7: System.out.println("Program terminating ….");
            break;
        }
    } while (choice < 7);}

    public static void mulTest(){
        Scanner sc = new Scanner(System.in);
        int correctAnsNo = 0;
        for (int i = 0; i<5 ; i++){
            int question1= (int) ((Math.random()*9)+1);
            int question2= (int) ((Math.random()*9)+1);
            int correctans= question1 * question2;
            System.out.println("How much is " +question1+ " times " +question2+ "?");
            int userInput = sc.nextInt(); 
            if (userInput == correctans){
                correctAnsNo ++;
            
            }

        
        }
        System.out.println(+correctAnsNo+ " out of 5 are correct.");

        }
        public static void divide(int m,int n){   
            int SubCount = 0;
            int originalm = m;
            while (m>=n){
                m= m -n;
                SubCount++;

            }
            System.out.println(originalm + " / " + n + " = " +SubCount);
            }

        public static int modulus(int n, int m){
            int originalm = m;
            while (m>=n){
                m= m - n;

            }
            System.out.println(originalm + " % " + n + " = " +m);
            return 0;
        }
        public static int countDigits(int n) {
            if (n<0){
                System.out.print("ERROR!!!\n");
                return 0;
            }
            else{
                int count = 0;
                while (n>0){
                    n=n/10;
                    count++;
                }
                System.out.println("number of digits = " + count);
                return 0;
            }
            
        }
        public static int position(int n, int digit){
            int count = 1;    
            while (n>0){
                    int temp = n % 10;
                    if (temp == digit){
                        System.out.println("position = " +count);
                        return count;}
                    n = n/10;
                    count++;
                    

                }
                System.out.println("position = -1"); 
                return -1;

        }
        public static long extractOddDigits(long n){
            if (n<0){
                System.out.println("error");
                return 0;
            }
            long newnum = 0;
            while (n>0){
                long temp = n % 10; //get last digit
                if (temp % 2 !=0){ 
                newnum = newnum*10 + temp;
                }

                n = n/10;
                

            }
            long reversed = 0; //reverse it
            while (newnum > 0) {
                reversed = reversed * 10 + newnum % 10;
                newnum = newnum / 10;}
                if (reversed ==0){
                    reversed = -1;}
                System.out.println(reversed); 
                return reversed;
        }

    }
    