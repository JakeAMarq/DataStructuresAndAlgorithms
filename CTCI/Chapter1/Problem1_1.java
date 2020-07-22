package ctci.chapter1;

import java.util.HashSet;

public class Problem1_1 {
    public static void main(String[] theArgs) {
        for (String arg : theArgs) {
            System.out.println(isUnique(arg));
        }
    }

    /**
     * Return true if string is unique
     */
    public static boolean isUnique(String input) {

        /*
         * Hash table implementation
         * 
         */
        // HashSet<Character> chars = new HashSet<>();
        // char current;
        // for (int i = 0; i < input.length(); i++) {
        //     current = input.charAt(i);
        //     if (chars.contains(current)) return false;
        //     chars.add(current);
        // }
        // return true;

        // Using bit vector
        int checker = 0, current;
        for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i) - 'a';
            if (((checker >> current) & 1) > 0) return false;
            checker |= 1 << current;
        }
        return true;
    }
}