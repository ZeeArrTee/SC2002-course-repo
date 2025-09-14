import java.util.Scanner;

public class Strings {
    // --------------------------------------------
// Reads in an array of integers, sorts them,
// then prints them in sorted order.
// --------------------------------------------
public static void main (String[] args)
{
	String[] intList; //class
	int size;
	Scanner scan = new Scanner(System.in);
	System.out.print ("\nHow many Strings do you want to sort? ");
	size = scan.nextInt();
    scan.nextLine();
    intList = new String[size]; //intlist list
	
	for (int i = 0; i < size; i++){
        System.out.println ("\nEnter the string...");
		intList[i] = scan.nextLine();}

        Sorting.insertionSort(intList);
	System.out.println ("\nYour numbers in sorted order...");

	for (int i = 0; i < size; i++){
		System.out.print(intList[i] + " ");
	System.out.println ();
	}}  
}
