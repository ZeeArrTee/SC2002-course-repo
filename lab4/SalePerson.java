
public class SalePerson implements Comparable<SalePerson>{
    private String firstName;
    private String lastName;
    private int totalSales;

    public SalePerson(String firstname, String lastName, int totalSales){ //constructor
        this.firstName = firstname;
        this.lastName = lastName;
        this.totalSales = totalSales;
     }

    public SalePerson SalePerson(){
        SalePerson saleperson = new SalePerson(null,null,0);
        return saleperson;
    }

    public String toString(){

        return (firstName + "," + lastName + ":" + totalSales);

    }

    public boolean equals(SalePerson guyPerson){

        if ((guyPerson.firstName.equals(this.firstName)) && (guyPerson.lastName.equals(this.lastName))){
            
            return true;

        }

        else{
            return false;
        }

    }

    public int compareTo(SalePerson mSalePerson){
        if (this.totalSales < mSalePerson.totalSales){
            return (this.totalSales - mSalePerson.totalSales);
        }
        if (this.totalSales > mSalePerson.totalSales){
            return (this.totalSales - mSalePerson.totalSales);
        }

        if (this.totalSales == mSalePerson.totalSales){
            if ((this.lastName.compareToIgnoreCase(mSalePerson.lastName))<0){ //precedes
                return -1;
            }

            if ((this.lastName.compareToIgnoreCase(mSalePerson.lastName))>0){
                return 1;
            }

            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }   

    public String getfirstName(){
            return this.firstName;
        }

    public String getlastName(){
            return this.lastName;
        }

    public int gettotalSales(){
            return this.totalSales;
    }


}