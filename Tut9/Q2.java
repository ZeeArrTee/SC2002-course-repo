package Tut9;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,5,3,25,2);
        Collections.sort(numbers,Collections.reverseOrder());
        System.out.print("reverse order = " + numbers);

        Collections.shuffle(numbers);
        System.out.print("shuffled order = " + numbers);

        System.out.print("max = " + Collections.max(numbers));
        System.out.print("min = " + Collections.min(numbers));
    }    
}
