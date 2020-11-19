import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Loader {

    private final static String COMMAND_LIST = "LIST";
    private final static String COMMAND_EXIT = "EXIT";
    private final static String COMMAND_COOL = "COOL";
    private final static String FOUND = "найден";
    private final static String NOTFOUND = "не найден или введён простой номер";

    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 199;
        int regRND;

        String str;

        long start;
        long duration;

        List<String> licensePlates = new ArrayList<>();

        //ввел список coolNum просто для облегчения проверки наличия крутого номера в списке licensePlates
        List<String> coolNum = new ArrayList<>();

        for (int i = 0; i < 3000000; i++) {

            regRND = Generator.regionRandom(MIN, MAX);

            if (regRND < 10) {
                str = Generator.letterRandom() + (int) (Math.random() * 10)
                        + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                        + Generator.letterRandom() + Generator.letterRandom() + "0" + regRND;
            } else {
                str = Generator.letterRandom() + (int) (Math.random() * 10)
                        + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                        + Generator.letterRandom() + Generator.letterRandom() + regRND;
            }

            licensePlates.add(str);


            if (Generator.isCool(str)) {
                coolNum.add(str);
            }
        }

        Set<String> hset = new HashSet<>();
        hset.addAll(licensePlates);

        Set<String> tset = new TreeSet<>();
        tset.addAll(licensePlates);

        Collections.sort(licensePlates, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(coolNum, String.CASE_INSENSITIVE_ORDER);

        while (true) {
            String userInput = UserInput.getLine();

            if (Verify.numPattern(userInput)) {

                System.out.println("Вы ввели номер авто!");

                if (!licensePlates.contains(userInput)) System.out.println("Номера в списках НЕТ.\n");
                else System.out.println("Номер в списках ЕСТЬ.\n");

                start = System.nanoTime();

                if (licensePlates.contains(userInput) && Generator.isCool(userInput)) {
                    duration = System.nanoTime() - start;
                    System.out.println("Поиск перебором: \"крутой\" номер " + FOUND + ", поиск занял " + duration
                            + " наносекунд");

                } else {
                    duration = System.nanoTime() - start;
                    System.out.println("Поиск перебором: \"крутой\" номер " + NOTFOUND + ", поиск занял " + duration
                            + " наносекунд");
                }

                start = System.nanoTime();

                if (Collections.binarySearch(licensePlates, userInput) >= 0 && Generator.isCool(userInput)) {
                    duration = System.nanoTime() - start;
                    System.out.println("Бинарный поиск: \"крутой\" номер " + FOUND + ", поиск занял " + duration
                            + " наносекунд");
                } else {
                    duration = System.nanoTime() - start;
                    System.out.println("Бинарный поиск: \"крутой\" номер " + NOTFOUND + ", поиск занял " + duration
                            + " наносекунд");
                }

                start = System.nanoTime();

                if (hset.contains(userInput) && Generator.isCool(userInput)) {
                    duration = System.nanoTime() - start;
                    System.out.println("Поиск в HashSet: \"крутой\" номер " + FOUND + ", поиск занял " + duration
                            + " наносекунд");

                } else {
                    duration = System.nanoTime() - start;
                    System.out.println("Поиск в HashSet: \"крутой\" номер " + NOTFOUND + ", поиск занял " + duration
                            + " наносекунд");
                }

                start = System.nanoTime();

                if (tset.contains(userInput) && Generator.isCool(userInput)) {
                    duration = System.nanoTime() - start;
                    System.out.println("Поиск в TreeSet: \"крутой\" номер " + FOUND + ", поиск занял " + duration
                            + " наносекунд");

                } else {
                    duration = System.nanoTime() - start;
                    System.out.println("Поиск в TreeSet: \"крутой\" номер " + NOTFOUND + ", поиск занял " + duration
                            + " наносекунд");
                }

                continue;
            }

            if (userInput.equals(COMMAND_COOL) || userInput.equals(COMMAND_COOL.toLowerCase())) {
                System.out.println("\n\t\tСписок \"крутых\" номеров из всех сгенерированных: \n");
                coolNum.forEach((a) -> System.out.print(a + " *** "));
            } else if (userInput.equals(COMMAND_LIST) || userInput.equals(COMMAND_LIST.toLowerCase())) {
                System.out.println("\n\t\tСписок номеров авто: \n");
                licensePlates.forEach((a) -> System.out.print(a + " *** "));

            } else if (userInput.equals(COMMAND_EXIT) || userInput.equals(COMMAND_EXIT.toLowerCase())) {

                break;

            } else {

                System.out.println("неверная команда!");

            }
        }
    }
}

class Generator {

    public static String letterRandom() {
        char[] chars = "ABEKMHOPCTYX".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(chars[random.nextInt(chars.length)]);
        String output = sb.toString();
        return output;
    }

    public static int regionRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static boolean isCool(String coolNum) {
        String str = coolNum.substring(1, 4);
        if (str.charAt(0) == str.charAt(1) && str.charAt(0) == str.charAt(2)) {
            return true;
        } else {
            return false;
        }
    }
}

class UserInput {

    public static String getLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВаши действия: ");
        String str = scanner.nextLine();

        return str;
    }
}

class Verify {

    static boolean numPattern(final String hex) {
        Matcher matcherN = Pattern.compile("[ABEKMHOPCTYX]" +
                "[0-9]{3}" +
                "[ABEKMHOPCTYX]{2}" +
                "[0-9]{1,3}").matcher(hex);
        return matcherN.matches();

    }
}
