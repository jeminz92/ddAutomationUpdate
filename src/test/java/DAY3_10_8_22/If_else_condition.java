package DAY3_10_8_22;

public class If_else_condition {

        public static void main(String[] args) {
            //declaring two integer variables for if else conditions
            String s1, s2, s3;
            int a, b;
            a = 2;
            b = 3;
            s1 = "Good bye";
            s2 = "Good bye";
            s3 = "Good hi";


            // verify if a is less than b or not
            if (s1 == s2) {
                System.out.println("This is wrong");
                // end of if

            } else {
                System.out.println("This is right");
            } // end of else
            if (a > b) {
                System.out.println("a is less than b");
            // can be any statement will only print if a < b //
            } else { System.out.print("a is either greater or equal to b");
            }// end of else condition
        }// end of main
        } // end of class


