package CTCI.Chapter1;

import java.util.HashMap;

public class Problem1_2 {
    public static void main(String[] theArgs) {
        if (theArgs.length % 2 != 0) {
            throw new IllegalArgumentException("Must have an even number of arguments");
        }

        for (int i = 0; i < theArgs.length; i += 2) {
            System.out.println(isPermutation(theArgs[i], theArgs[i + 1]));
        }
    }

    /**
     * Returns true if the two strings are permutations of one another
     */
    public static boolean isPermutation(String s1, String s2) {
        int len = s1.length();
        if (len != s2.length()) return false;

        HashMap<Character, Integer> counts = new HashMap<>();
        char current;
        for (int i = 0; i < len; i++) {
            current = s1.charAt(i);
            counts.put(current, counts.getOrDefault(current, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            current = s2.charAt(i);
            if (counts.containsKey(current)) {
                counts.put(current, counts.get(current) - 1);

                if (counts.get(current) < 0) return false;
            }
        }

        for (Integer num : counts.values()) {
            if (num != 0) return false;
        }

        return true;
    }
}