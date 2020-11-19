import HomeWorks.Palindrome.ArrayInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntTest {

    @Test
    void isPalindrome() {
        ArrayInt arr = new ArrayInt();
        boolean actual = arr.isPalindrome(new int[]{1,2,2,1});
       assertEquals(true,actual);
    }
}