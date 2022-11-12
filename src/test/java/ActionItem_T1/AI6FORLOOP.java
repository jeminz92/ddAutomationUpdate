package ActionItem_T1;
    import java.util.ArrayList;


    public class AI6FORLOOP {

        public static void main(String[] args) {
            /* method */
            ArrayList<String> country = new ArrayList<>();
            // Method for ArrayList String
            ArrayList<Integer> countryCode = new ArrayList<>();
            // Method for Arraylist Int
            country.add("Albania");
            country.add("Italy");
            country.add("Montenegro");
            country.add("Spain");
            // data added to variable string
            //adsadsadsadsa
            countryCode.add(111);
            countryCode.add(222);
            countryCode.add(333);
            countryCode.add(444);
            // data added to variable Int
            for (int i = 0; i < 4; i++) {
                // for loop method
                System.out.println("My Country is " + country.get(i) + " And my country code is " + countryCode.get(i));
                // print statement
            }
        }
    }














