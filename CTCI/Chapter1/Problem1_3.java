package ctci.chapter1;

public class Problem1_3 {
    public static void main(String[] theArgs) {
        for (String arg : theArgs) {
            char[] input = new char[100];
            for (int i = 0; i < arg.length(); i++) {
                input[i] = arg.charAt(i);
            }
            URLify(input, arg.length());
            System.out.println(input);
        }
    }

    public static void URLify(char[] input, int trueLen) {
        int spaceCount = 0;

        for (int i = 0; i < trueLen; i++) {
            if (input[i] == ' ') spaceCount++;
        }

        if (spaceCount != 0) {

            int newInd = trueLen - 1 + 2 * spaceCount;

            for(int oldInd = trueLen - 1; oldInd >= 0; oldInd--) {
                if (input[oldInd] == ' ') {
                    input[newInd--] = '0';
                    input[newInd--] = '2';
                    input[newInd--] = '%';
                } else input[newInd--] = input[oldInd];
            }

        }
    }
}