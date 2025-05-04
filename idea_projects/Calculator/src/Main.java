import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int ask;
        int number1;
        int number2;
        int number3;

        System.out.println("Which function do u want to use?");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        ask = in.nextInt();

        System.out.println("Enter number 1");
        number1 = in.nextInt();

        System.out.println("Enter number 2");
        number2 = in.nextInt();

        switch(ask){
            case 1:
                number3 = number1 + number2;
                System.out.println(number3);
                break;
            case 2:
                number3 = number2 - number1;
                System.out.println(number3);
                break;
            case 3:
                number3 = number1 * number2;
                System.out.println(number3);
                break;
            case 4:
                number3 = number1 / number2;
                System.out.println(number3);

        }


    }
}