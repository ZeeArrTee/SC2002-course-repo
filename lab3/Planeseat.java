package lab3;

public class Planeseat {
    int SeatId;
    boolean assigned;
    int customerId;

    public Planeseat(int SeatId){ //constructor
        this.SeatId = SeatId;
        assigned = false;
        customerId = 0;
     }
    public int getSeatId(){
        return SeatId;
    }   
    public int getcustomerId(){
        return customerId;
    }
    public boolean isOccupied(){
        return assigned;
    }
    public void assign(int customerId){
        this.customerId = customerId;
        assigned = true;
    } 
    public void unassign(){
        this.customerId = 0;
        this.assigned = false;
    }
}
