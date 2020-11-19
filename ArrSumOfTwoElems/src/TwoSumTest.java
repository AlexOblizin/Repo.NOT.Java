import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(new int[]{1, 2, 3, 5, 7, 99, 12}, 8);
        assertEquals(0,result[0]);
        assertEquals(4,result[1]);
    }
}