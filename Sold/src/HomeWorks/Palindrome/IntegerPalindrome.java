package HomeWorks.Palindrome;

import java.util.Scanner;

public class IntegerPalindrome {
    public static void main(String[] args) {
        ArrayInt arint = new ArrayInt();
        while (true) {
            System.out.println("Число палиндром? - " + arint.isPalindrome(ArrayInt.arrFilled()));
        }
    }
}


/*
class Scratch {
    public static void main(String[] args)  {
        try {
            throw new NotFoundTomatException("Хрень");

        } catch (NotFoundTomatException e){
            System.out.println("Caught " + e.getMessage());

        }
    }
}
class NotFoundTomatException extends Exception{

    public NotFoundTomatException(String aaa) {
        super(aaa);
    }
}
*/
