public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length / 2; i++) { //заполнение задом наперед
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }

        System.out.println();
        for (int c : arr) {
            System.out.print(c + " ");

        }
    }
}
