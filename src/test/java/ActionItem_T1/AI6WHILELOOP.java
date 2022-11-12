package ActionItem_T1;

public class AI6WHILELOOP {
    public static void main(String[] args) {
        String[] region = {"North", "South", "East", "West"};
        int[] areaCode = {201, 718, 212, 656};
        int i = 0;
        // declaring integer variable as 0 , declaring strings, declaring integer variable as areacode
        while (i <  region.length) {
            while (i < areaCode.length) {
                // end of while loop



                // declaring string variable and data, integer variable and data
                System.out.println("My region is " + region[0] + " And my area code is " + areaCode[0]);
                 i++;

                // print statement

            }
        }
    }
}