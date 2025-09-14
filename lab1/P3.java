package sc2002.lab1;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter starting value: ");
        int start = scanner.nextInt();
        System.out.print("Enter the ending value: ");
        int end = scanner.nextInt();
        System.out.print("Enter the increment value: ");
        int increment = scanner.nextInt();

        if (start > end) {
            System.out.println("Error input!!");
            scanner.close();
            return;
        }

        double conversionRate = 1.82;

        System.out.println("\nTable1:");
        System.out.println("US$  S$");
        System.out.println("--------------");
        for (int temp1 = start; temp1 <= end; temp1 += increment) {
            double sgd = temp1 * conversionRate; 
            System.out.printf("%-4d %.2f\n", temp1, sgd);  
        }

        System.out.println("\nTable2:");
        System.out.println("US$  S$");
        System.out.println("--------------");
        int temp2 = start;
        while (temp2 <= end) {
            double sgd2 = temp2 * conversionRate;  
            System.out.printf("%-4d %.2f\n", temp2, sgd2);  
            temp2 += increment;
        }

        // Table3: Using a do/while loop
        System.out.println("\nTable3:");
        System.out.println("US$  S$");
        System.out.println("--------------");
        int temp3 = start;
        do {
            double sgd3 = temp3 * conversionRate; 
            System.out.printf("%-4d %.2f\n", temp3, sgd3);  
            temp3 += increment;
        } while (temp3 <= end);

       
        scanner.close();
    }
}