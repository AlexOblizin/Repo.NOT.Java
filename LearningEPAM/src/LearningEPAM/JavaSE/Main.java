package LearningEPAM.JavaSE;

public class Main {
    public static void main(String[] args) {





    }
    void aaa(){
        int quizzesCompleted = 0;
        for (int i = 0; i < 5; i++) {
            quizzesCompleted++;
        }
        System.out.println(quizzesCompleted);
    }

    public static double sqr(double arg) {
        while (true); // Удивительно, но КОМПИЛИРУЕТСЯ!
    }

    public static double aaaaa(int a) {

    return a;
    }



    public static double sqr2(double arg) {
        throw new RuntimeException(); // тоже КОМПИЛИРУЕТСЯ!
    }
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }



}

