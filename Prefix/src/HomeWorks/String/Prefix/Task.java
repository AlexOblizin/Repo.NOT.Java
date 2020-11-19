package HomeWorks.String.Prefix;

public class Task {


    public static void longestCommonPrefix(String[] strings) {
        String prefixTmp = "";
        String prefix;
        int count = 0;
//        char[] arr = returnTheLessString(strings).toCharArray();
        for (int k = 0; k < strings.length - 1; k++) {
            count++;
            for (int i = 0; i < returnTheLessString(strings).length(); i++) {
                if (strings[k].charAt(i) == strings[k + 1].charAt(i) && count <= 1) {
                    prefixTmp += strings[k].charAt(i);
                } else break;
            }
        }

        prefix = probe(prefixTmp, strings);
        System.out.println(prefix);

        count = 0;
        for (String str : strings) {
            if (str.startsWith(prefix)) {
                count++;
            } else break;
        }
        if (count == strings.length) System.out.println("Максимальный префикс => " + prefix);
        else System.out.println("Общего префикса нет");

    }

    public static String returnTheLessString(String[] strings) {
        String str = "";
        int length = strings[0].length();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();

            if (strings[i].length() < length) {
                length = strings[i].length();
            }
            if (strings[i].length() == length) {
                str = strings[i];
            }
        }
        return str;
    }

    public static String probe(String s, String[] strings) {
        String output = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length && i < strings.length; i++) {
            if (charArray[i] == strings[i].charAt(i)) {
                output += charArray[i];

            }
        }
        return output;

    }
}
