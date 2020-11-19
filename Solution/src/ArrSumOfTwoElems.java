import java.util.Scanner;

public class ArrSumOfTwoElems {
    public static void main(String[] args) {

        int[] arr = new int[7];

        System.out.print("Массив => ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);

            System.out.print(arr[i] + " ");
        }

        System.out.print("\nВведите число: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Элемент с индексом: " + i + " равен: " + arr[i]);
        }

        twoSum(arr, input);
        sc.close();
    }

    public static void twoSum(int[] array, int inp) {
        System.out.println("Сумма равная " + inp + " получается из элементов с индексами: ");
        for (int i = 0; i < array.length; i++) {
            for (int k = i; k < array.length; k++) {
                if (array[i] + array[k] == inp && i != k) {
                    System.out.print("[" + i + "," + k + "]" + " ");
                }
            }
        }
    }
}
