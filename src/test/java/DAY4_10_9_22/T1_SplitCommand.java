package DAY4_10_9_22;

public class T1_SplitCommand {

    public static void main(String[] args) {

        //declare a string variable
        String message = "My name is John";
        //extract out John by using String array
        String[] splitMessage = message.split(" ");
        System.out.println("result: " + splitMessage[1]);

        //extracting each character from a string
        String message2 = "abc";
        String [] splitMessage2 = message2.split("");
        System.out.println("Index 3 is: " + splitMessage2[1]);

    }
}
