package CTCI.Chapter1;

public class Problem1_5 {
    public static void main(String[] theArgs) {
        if (theArgs.length == 0) {
            theArgs = new String[]{
                "abc", "abcd",      // true
                "abc", "abb",       // true
                "abc", "ab",        // true
                "abc", "abcde",     // false
                "abc", "cde",       // false
                "abc", "bc"         // true
            };
        }
        for (int i = 0; i < theArgs.length; i++) {
            System.out.println(oneAway(theArgs[i], theArgs[++i]));
        }
    }

    /**
     * Returns if the two input strings can be made equal with a single:
     *  - Character insert
     *  - Character removal
     *  - Character replacement
     * @param str1
     * @param str2
     * @return
     */
    public static boolean oneAway(String str1, String str2) {
        System.out.println(str1 + " | " + str2);

        String shorter, longer;

        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        if (str1.length() <= str2.length()) {
            shorter = str1;
            longer = str2;
        } else {
            shorter = str2;
            longer = str1;
        }

        // Check if you can just edit one
        boolean diffFound = false;
        int shortPtr = 0, longPtr = 0;

        while (shortPtr < shorter.length()) {
            if (shorter.charAt(shortPtr) != longer.charAt(longPtr)) {
                if (diffFound) return false;
                diffFound = true;
                longPtr++;
            }
            shortPtr++;
            longPtr++;
        }

        return true;
    }
}