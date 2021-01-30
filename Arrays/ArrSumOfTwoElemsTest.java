import static org.junit.jupiter.api.Assertions.*;

class ArrSumOfTwoElemsTest {

    @org.junit.jupiter.api.Test
    void twoSum() {
        ArrSumOfTwoElems underTest = new ArrSumOfTwoElems();
        int[] actual = underTest.twoSum(new int[]{12, 11, 12, 111, 223}, 23);
        int[] expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);
    }
}