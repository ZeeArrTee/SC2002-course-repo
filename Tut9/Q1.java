package Tut9;




public class Q1 {

    public static <T> void printArray(T[] array){
        for (T element:array){
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] intager= {1,2,3,4,5};
        printArray(intager);
    }
    
}
