import java.util.Arrays;
import java.util.Scanner;

public class Search {
    public static void linearSearch(int[] array, int key) {
        int value = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                value = i;
            }
        }
        System.out.println("\nUsing Linear Search:");
        if (value == -1) {
            System.out.println("Search key NOT FOUND");
        } else {
            System.out.println("Search key FOUND at index " + value + ".");
        }
    }

    public static void linearSearchImproved(int[] array, int key) {
        int value = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                value = i;
                break;
            }
        }
        System.out.println("\nUsing Linear Search (Optimized):");
        if (value == -1) {
            System.out.println("Search key NOT FOUND");
        } else {
            System.out.println("Search key FOUND at index " + value + ".");
        }
    }

    public static void interpolationSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        System.out.println("\nUsing Interpolation Search:");
        while (low <= high && key >= array[low] && key <= array[high]) {
            if (low == high) {
                if (array[low] == key) {
                    System.out.println("Search key FOUND at index " + low + ".");
                } else {
                    System.out.println("Search key NOT FOUND");
                }
                return;
            }

            int pos = low + (((key - array[low]) * (high - low)) / (array[high] - array[low]));

            if (array[pos] == key) {
                System.out.println("Search key FOUND at index " + pos + ".");
                return;
            }

            if (array[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int len = scanner.nextInt();
        System.out.print("Enter the elements in the array:\n");
        
        int[] inputArray = new int[len];
        for (int i = 0; i < len; i++) {
            inputArray[i] = scanner.nextInt();
        }
        Arrays.sort(inputArray);
        System.out.println("The sorted array is: " + Arrays.toString(inputArray));

        System.out.print("Enter the search key: ");
        int key = scanner.nextInt();

        long startTimeLS = System.nanoTime();
        linearSearch(inputArray, key);
        long stopTimeLS = System.nanoTime();
        System.out.println("Execution time: " + (stopTimeLS-startTimeLS)+ " ns");

        long startTimeLSO = System.nanoTime();
        linearSearchImproved(inputArray, key);
        long stopTimeLSO = System.nanoTime();
        System.out.println("Execution time: " + (stopTimeLSO-startTimeLSO)+ " ns");
        
        long startTimeI = System.nanoTime();
        interpolationSearch(inputArray, key);
        long stopTimeI = System.nanoTime();
        System.out.println("Execution time: " + (stopTimeI-startTimeI)+ " ns");
    }
}