package sc2002.lab1;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter height: ");
        int height = scanner.nextInt();
    
        if (height <= 0) {
            System.out.println("Error input!!");
            scanner.close();
            return;
        }
    
        for (int i = 1; i <= height; i++) {
            StringBuilder pattern = new StringBuilder();

            for (int j = 1; j <= i; j++) {
                if (j % 2 == 1) {
                    pattern.append("AA");
                } else {
                    pattern.append("BB");
                }
            }
    
            System.out.println(pattern.toString());
        }

        scanner.close();
    }
}