import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    while (true) {
        int input = userInput();
        Solution solution = new Solution();
        System.out.println("это палиндром (true/false)? - " + solution.isPalindrome(input));
    }

    }
    boolean isPalindrome (int number){
        int intgr;
        int output;
        while (number > 0) { // избавляемся от разрядов исходника (input) - двигаемся по нему влево
            // и выходим из цикла, когда введенное число закончится (двигаться некуда будет).
            output = number % 10;
            List<Integer> array = new ArrayList<>();
            array.add(output);
            number = number / 10; // а здесь двигаемся влево по введенной цифре, пока она не станет равна 0,
            // то есть закончится

        }

        return true;
    }
    static int userInput(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nВаши действия: ");
            int number = scanner.nextInt();

            return number;
        }
    }
}
