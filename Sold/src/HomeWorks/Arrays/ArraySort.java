package HomeWorks.Arrays;

public class ArraySort {

    public static void main(String[] args) {

        int tmp;
        boolean sorted = false;

        int arr[] = new int[15];
        System.out.print("\n\t\t Массив => ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print("\'" + arr[i] + "\'" + " ");
        }
        System.out.println();

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    sorted = false;
                }
            }
        }

        System.out.print("\nМассив по возр. => ");
        Output.output(arr);

        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    sorted = false;
                }
            }
        }

        System.out.print("\nМассив по убыв. => ");
        Output.output(arr);
    }

}

class Output {
    public static void output(int arr[]) {
        for (int a : arr) {
            System.out.print("\'" + a + "\'" + " ");
        }
        System.out.println();
    }
}


