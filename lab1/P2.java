package sc2002.lab1;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter salary: ");
        int salary = scanner.nextInt();
        
        System.out.print("Enter merit points: ");
        int merit = scanner.nextInt();
        
        String grade;
        
        if (salary >= 700 && salary <= 899) {
            if (salary >= 700 && salary <= 799 && merit < 20) {
                grade = "B";
            } else {
                grade = "A";
            }
        } else if (salary >= 600 && salary <= 799) {
            if (salary >= 600 && salary <= 649 && merit < 10) {
                grade = "C";
            } else {
                grade = "B";
            }
        } else if (salary >= 500 && salary <= 649) {
            grade = "C";
        } else {
            grade = "Invalid salary range";
        }
        
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
