package CTCI.Chapter1;

public class Problem1_4 {
    public static void main(String[] theArgs) {
        for (String arg : theArgs) {
            System.out.println(isPalidromePermutation(arg));
        }
    }

    public static boolean isPalidromePermutation(String input) {
        
        input = input.toLowerCase();
        int[] counts = new int[128]; // assuming ASCII
        char current;
        for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i);
            if (current == ' ') continue;

            counts[current]++;
        }

        boolean oddFound = false;
        for (int count : counts) {
            if (count % 2 == 1) {
                oddFound = !oddFound;
                if (!oddFound) return false;
            }
        }

        return true;
    }
}