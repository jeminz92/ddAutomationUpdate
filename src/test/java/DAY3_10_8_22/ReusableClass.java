package DAY3_10_8_22;

public class ReusableClass {
    //create a void method that will add two numbers and execute the print statement
    public static void addTwoNumbers(int a, int b) {
        int result = a + b;
        System.out.println("The result is " + result);

    } // end of addTwoNumbers

    //create a return method that will add two numbers and return the result
    public static int returnTwoAddNumbers(int a, int b) {
        int result = a + b;
        System.out.println("The return result is " + result);
        return result;

    }//end of return two numbers
}// end of java class
