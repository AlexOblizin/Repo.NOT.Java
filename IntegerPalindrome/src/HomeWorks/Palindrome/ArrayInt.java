package HomeWorks.Palindrome;

import java.util.Scanner;

public class ArrayInt {

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите число: ");
        int number = scanner.nextInt();

        return number;
    }

    public static int[] array(int input) {
        int count = 0;
        while (input > 0) {
            input = input / 10;
            count++;
        }
        return new int[count];
    }

    public static int[] arrFilled() {
        int i;
        int tmp = getInt();
        int[] arrayTmp = array(tmp);
        for (i = 0; i < arrayTmp.length; i++) {
            arrayTmp[i] = tmp % 10;
            tmp /= 10;
        }

        return arrayTmp;
    }

    public boolean isPalindrome(int[] arr) {
        boolean ispal = true;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                ispal = false;
                break;
            }
        }
        return ispal;
    }
}