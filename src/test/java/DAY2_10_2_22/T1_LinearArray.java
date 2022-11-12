package DAY2_10_2_22;

public class T1_LinearArray {

    public static void main(String[] args) {
        //declare a String array variable.
        String[] zipCode;
        //defining zipcode values for the linear string array
        zipCode = new String[]{"11218","11222","10001","11377"};
        //print a value from zipcode. Array always starts from 0 index
        String[] StreetAddress;
        StreetAddress = new String[]{"12121"};
        System.out.println("zipcode: "+zipCode[3] + " " + zipCode[2]);

        System.out.println("here is an extra set of zipcodes: " +zipCode[3]);
        //end of main
        String[] Characters;
        Characters = new String[]{"1111","2222","3333","4444","5555"};
        System.out.println("here are some characters: " +Characters[0] + " " + Characters[3]);

        String[] joeBiden;
        joeBiden = new String[]{"120101","101001","10101010","10101010"};
        System.out.println(joeBiden[0]);


    }
}
