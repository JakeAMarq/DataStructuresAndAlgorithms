package ctci.chapter1;

public class Problem1_6 {
    public static void main(String[] theArgs) {
        if (theArgs.length == 0) {
            theArgs = new String[]{
                //Insert test cases here
                "abc",
                "aabb",
                "aabbb",
                "aaabbccc"
            };
        }

        for (String arg : theArgs) {
            System.out.println(arg);
            System.out.println(compressedString(arg));
        }
    }

    public static String compressedString(String input) {
        if (input.length() == 0) return input;

        StringBuilder result = new StringBuilder();

        char current = input.charAt(0);
        int count = 0, lenDiff = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == current) {
                count++;
            } else {
                result.append(current).append(count);
                lenDiff -= count - 2;

                if (input.length() - i < lenDiff) return input;

                current = input.charAt(i);
                count = 1;
            }
        }
        result.append(current).append(count);

        return result.length() < input.length() ? result.toString() : input;
    }
}