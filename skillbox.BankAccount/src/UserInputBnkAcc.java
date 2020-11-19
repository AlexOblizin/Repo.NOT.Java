import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputBnkAcc {


    public static String userInput() {
        String input;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВаши действия: ");
        input = scanner.nextLine();

        return input;
    }



    static boolean getCard(String get) {

        Pattern patternCardGet = Pattern.compile("^(getcard\\s+\\d+\\s?)([0-9]+)$");
        Matcher matcherCardGet = patternCardGet.matcher(get);
        return matcherCardGet.matches();
    }

    static boolean getDepo(String get) {

        Pattern pattern = Pattern.compile("^(getdepo\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }

    static boolean getAcc(String get) {

        Pattern pattern = Pattern.compile("^(getacc\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }

    static boolean acc2depo(String get) {

        Pattern pattern = Pattern.compile("^(acc\\s+)(send\\s+)(depo\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }
    static boolean acc2card(String get) {

        Pattern pattern = Pattern.compile("^((acc\\s+)(send\\s+)(card\\s+))([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }
    static boolean depo2acc(String get) {

        Pattern pattern = Pattern.compile("^(depo\\s+)(send\\s+)(acc\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }
    static boolean depo2card(String get) {

        Pattern pattern = Pattern.compile("^(depo\\s+)(send\\s+)(card\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }
    static boolean card2acc(String get) {

        Pattern pattern = Pattern.compile("^(card\\s+)(send\\s+)(acc\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }
    static boolean card2depo(String get) {

        Pattern pattern = Pattern.compile("^(card\\s+)(send\\s+)(depo\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(get);
        return matcher.matches();
    }

    static boolean balance(String balance) {

        Pattern pattern = Pattern.compile("^(balance)$");
        Matcher matcher = pattern.matcher(balance);

        return matcher.matches();
    }

    static boolean exit(String exit) {

        Pattern pattern = Pattern.compile("^(exit)$");
        Matcher matcher = pattern.matcher(exit);

        return matcher.matches();
    }

    static boolean acc(String acc) {

        Pattern pattern = Pattern.compile("^(acc\\s+)([0-9]+)$");
        Matcher matcher = pattern.matcher(acc);

        return matcher.matches();
    }

    static boolean card(String card) {

        Pattern pattern = Pattern.compile("^(card\\s+\\d+\\s?)([A-Za-zА-Яа-яЁё0-9 ]+)$");
        Matcher matcher = pattern.matcher(card);

        return matcher.matches();
    }

    static boolean depo(String depo) {

        Pattern pattern = Pattern.compile("^(depo\\s+\\d+\\s?)([A-Za-zА-Яа-яЁё0-9 ]+)$");
        Matcher matcher = pattern.matcher(depo);

        return matcher.matches();
    }
//    static boolean acc2card(String get) {
//
//        Pattern pattern = Pattern.compile("^(tocard\\s+)([0-9]+)$");
//        Matcher matcher = pattern.matcher(get);
//        return matcher.matches();
//    }
//
//    static boolean acc2depo(String get) {
//
//        Pattern pattern = Pattern.compile("^(todepo\\s+)([0-9]+)$");
//        Matcher matcher = pattern.matcher(get);
//        return matcher.matches();
//    }

}

