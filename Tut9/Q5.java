package Tut9;
public class Q5{
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int sum = 0;
        for (int num: array){
            if (num % 2 == 0){
                sum += num;
            }
        }
        System.out.println(sum);
        
    }
}

