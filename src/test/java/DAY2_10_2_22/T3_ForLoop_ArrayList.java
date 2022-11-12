package DAY2_10_2_22;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {


    public static void main(String[] args) {
        //declare and define the arrayList for zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10001");
        zipCode.add("11219");
        zipCode.add("02017");
        zipCode.add("99997");
        zipCode.add("40501");
        zipCode.add("56078");

        //call for a loop to print out all the zipcode values from the array list
        //if you want to control the end point by number, then put the actual number instead of zipcode.size
        //for array list it uses .size() to get the count of the list but linear array it uses .length() to get the count of the list


        for (int i = 0; i < 5; i++){
            //print out each zipcode automatically
            System.out.println("Zipcode: " + zipCode.get(i));



        }//end of for loop
    }//end of main
}//end of java class
