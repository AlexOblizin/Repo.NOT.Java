public class TwoSum {
    public int[] twoSum(int[] array, int inp) {
        System.out.println("Сумма равная " + inp + " получается из элементов с индексами: ");
        for (int i = 0; i < array.length; i++) {
            for (int k = i; k < array.length; k++) {
                if (array[i] + array[k] == inp && i != k) {
                    System.out.print("[" + i + "," + k + "]" + " ");
                    return new int[] {i,k};
                }
            }
        }
        return null;
    }
}
