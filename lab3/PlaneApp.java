package lab3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//class Planeseat {}

class Plane{
    public static final int MAX_SEATS = 12;
    Planeseat[] seat = new Planeseat[MAX_SEATS]; //creates an empty array
    int numEmptySeat = MAX_SEATS;
    public Plane(){
        for (int i = 0 ; i < MAX_SEATS ; i++){
            seat[i] = new Planeseat(i+1); //creates plane object in the empty array
        }
    }
    private Planeseat[] sortSeats(){
        //Planeseat[] copy = new Planeseat[MAX_SEATS];
        Planeseat[] copy = Arrays.copyOf(seat,MAX_SEATS);
        //for (int i=0; i < MAX_SEATS; i++){
            //copy[i] = new Planeseat(seat[i].getSeatId()); //creates new object at each instance
            //copy[i].assign(seat[i].getcustomerId()); //creates customer id

        Arrays.sort(copy,Comparator.comparing(Planeseat::getcustomerId));

        return copy;
    }
    public void showNumEmptySeats(){
        int sum = 0;
        for (int i=0;i<MAX_SEATS;i++){
            if (seat[i].isOccupied()==false){
                sum ++;
            }
        }
        numEmptySeat = sum;
        System.out.println("There are " + numEmptySeat + " empty seats. \n");
    }
    public void showEmptySeats(){
        System.out.println("the following seats are empty:\n");
        for (int i = 0; i < MAX_SEATS; i++){
            if (seat[i].isOccupied() == false){
                System.out.println("SeatId:"+seat[i].getSeatId()+"\n");
            }
        }
    }
    public void showAssignedSeats(boolean bySeatId){
        System.out.println("The seat assignments are as follows:\n");
        if (bySeatId == false){//customerid
            Planeseat[] copy1 = this.sortSeats(); //returns a sorted copy assigned to copy1
            for(int i = 0 ; i<MAX_SEATS ; i++){
                if (copy1[i].isOccupied()==true){
                System.out.println("SeatId "+ copy1[i].getSeatId() + " assigned to CustomerID:" + copy1[i].getcustomerId()+ "\n");
            }
        }
            }
        else{
            Planeseat[]copy2 =Arrays.copyOf(seat,MAX_SEATS);
            Arrays.sort(copy2,Comparator.comparingInt(Planeseat::getSeatId));
            for(int i = 0 ; i<MAX_SEATS ; i++){
                if (copy2[i].isOccupied()==true){
                System.out.println("SeatId "+ copy2[i].getSeatId() + " assigned to CustomerID:" + copy2[i].getcustomerId()+ "\n");
        }}
        }
    }
    public void assignSeat(int Sid, int Cid){
        for(int i=0 ; i<MAX_SEATS ; i++){
            if(seat[i].getSeatId()==Sid){
                if(seat[i].isOccupied()==false){ 
                seat[i].assign(Cid);
                System.out.println("Successfully assigned\n");
                return;}
                else{
                    System.out.println("the seat is already occupied!\n");
                    return;
                }
            }
        }
        System.out.println("the seatID does not exist\n");
    }
    public void unAssignSeat(int seatID){
        for(int i=0 ; i<MAX_SEATS ; i++){
            if(seat[i].getSeatId()==seatID){
                if(seat[i].isOccupied()==true){ 
                seat[i].unassign();
                System.out.println("Successfully unassigned\n");
                return;}
                else{
                    System.out.println("the seat is already empty!\n");
                    return;
            }
            
            }
        }
        System.out.println("the seatID does not exist\n");
    }
}

public class PlaneApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Plane plane = new Plane();
        do {
            System.out.println("""
                    (1) Show number of empty seats \n
                    (2) Show the list of empty seats \n
                    (3) Show the list of seat assignments by seat ID \n
                    (4) Show the list of seat assignments by customer ID \n
                    (5) Assign a customer to a seat \n
                    (6) Remove a seat assignment \n
                    (7) Exit \n

                    Enter the number of your choice:"""); 
            choice = sc.nextInt();

            switch (choice) {
                case 1: //emptyseatsno
                plane.showNumEmptySeats();
                    break;
                case 2: //emptyseatslist
                plane.showEmptySeats();
                    break;
                case 3: //list of seatID
                plane.showAssignedSeats(true);
                    break;
                case 4: //list of CustomerID
                plane.showAssignedSeats(false);
                    break;
                case 5: //Assignments
                int sid;
                int cid;
                System.out.println("Assigning Seat...\n");
                System.out.println("Please enter seatID: ");
                sid = sc.nextInt();
                System.out.println("Please enter customerID: ");
                cid = sc.nextInt();
                plane.assignSeat(sid,cid);
                    break;
                case 6: //remove a seat assignment
                System.out.println("Enter SeatID to unassign customer from: ");
                int rem = sc.nextInt();
                plane.unAssignSeat(rem);
                System.out.println("Seat Unassigned! \n");
                    break;
                default:
                    System.out.println("input invalid\n");
                case 7:
                return;
            }

        }while(choice<7);
        sc.close();
    }   
    
}