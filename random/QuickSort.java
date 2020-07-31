package random;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int low, int high) {
        if (low > high) {
            int temp = low;
            low = high;
            high = temp;
        }

        int partition = partition(list, low, high);

        quickSort(list, low, partition - 1);
        quickSort(list, partition + 1, high);


    }

    private static int partition(int[] list, int low, int high) {
xs
    }

    public static int[] getSortedCopyOf(int[] list) {
        int[] result = Arrays.copyOf(list, list.length);
        sort(result);
        return result;
    }
    
}