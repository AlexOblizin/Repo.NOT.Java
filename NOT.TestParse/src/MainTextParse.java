import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MainTextParse {
    public static void main(String[] args) throws IOException {
        String fileName = "F:/Edu/TestParse.csv";
        readUsingScanner(fileName);
    }

    private static void readUsingScanner(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        //читаем построчно
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\,");
            for (int i = 0; i < line.length; i++) {
                double a = Double.parseDouble(line[i]);
                if (a >= 0) {
                    System.out.println(a);
                }
            }
        }
    }
}
