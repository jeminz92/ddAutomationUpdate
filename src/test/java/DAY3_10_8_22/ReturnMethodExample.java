package DAY3_10_8_22;

public class ReturnMethodExample {
    public static void main(String[] args) {

        // the result of return method is equal to the value you store in the new variable
      int value =  ReusableClass.returnTwoAddNumbers(5,10);
        //now you can set additional parameters to the value since it is stored as a variable (int)
        System.out.println("new value is " + (value-3));
    }
}
