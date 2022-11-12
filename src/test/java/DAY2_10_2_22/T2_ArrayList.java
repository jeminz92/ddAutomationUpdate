package DAY2_10_2_22;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
        //declare and define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //now add the values for countries array
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");

        //print usa from the countries list

        System.out.println("Countries Value: " + countries.get(0));

        //call an integer array list for streetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(333);
        streetNumber.add(222);
        System.out.println("First Street Number: " + streetNumber.get(1));
        System.out.println(streetNumber.get(1));

        }
}

