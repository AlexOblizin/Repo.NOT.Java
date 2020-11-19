import java.util.Scanner;

public class IntegerReverse {
    public static void main(String[] args) {
        int output = 0;
        int inptmp;
        while (true) {
            output = 0;
            System.out.println("Введите число: ");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            inptmp = input;

            if (inptmp < 0) {
                inptmp = -inptmp;
            }

            while (inptmp > 0) { // избавляемся от разрядов исходника (input) - двигаемся по нему влево
                // и выходим из цикла, когда введенное число закончится (двигаться некуда будет).
                output = output * 10 + inptmp % 10; // к промежуточной сумме
                // каждую итерацию прибавляем найденную в результате остатка от деления последнюю цифру
                inptmp = inptmp / 10; // а здесь двигаемся влево по введенной цифре, пока она не станет равна 0,
                // то есть закончится

            }
            if (input > 0) {
                System.out.println(output);
                continue;
            } else if (input < 0) {
                System.out.println(-output);
                continue;
            }
        }
    }
}
