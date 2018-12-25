import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of Integers you want in the array: ");
        int size = keyboard.nextInt();

        Integer[] randomArray = new Integer[size];
        Integer[] copy = new Integer[size];
        Random randomInt = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomInt.nextInt();
            copy[i] = randomArray[i];
        }


        //Making all of the different types of ordered arrays
        Arrays.sort(randomArray);
        Integer[] orderedArray = Arrays.copyOf(randomArray,randomArray.length);
        inverseArray(orderedArray,copy);
        Integer[] reverseArray = Arrays.copyOf(orderedArray,orderedArray.length);

        /**
         * Selection Sort
         */
        System.out.println("------Selection Sort------");
        //Sorting a randomly ordered array
        reloadArray(randomArray,copy);
        long startTime = System.currentTimeMillis();
        SortAlgorithms.SelectionSort.sort(randomArray);
        System.out.println("Selection Sort time with randomly ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting a inversely ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.SelectionSort.sort(reverseArray);
        System.out.println("Selection Sort time with inversely ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting an ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.SelectionSort.sort(orderedArray);
        System.out.println("Selection Sort time with ordered integers is " + (System.currentTimeMillis() - startTime) + " ms" + "\n");

        /**
         * Bubble Sort
         */

        System.out.println("-----Bubble Sort-----");
        //Sorting  a randomly ordered array
        reloadArray(randomArray,copy);
        startTime = System.currentTimeMillis();
        SortAlgorithms.BubbleSort.sort(randomArray);
        System.out.println("Bubble Sort time with randomly ordered integer is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting a inversely ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.BubbleSort.sort(reverseArray);
        System.out.println("Bubble Sort time with inversely ordered integer is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting an ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.BubbleSort.sort(orderedArray);
        System.out.println("Bubble Sort time with ordered integers is " + (System.currentTimeMillis() - startTime) + " ms" + "\n");

        /**
         * Insertion Sort
         */
        System.out.println("------Insertion Sort------");
        //Sorting a randomly ordered array
        reloadArray(randomArray,copy);
        startTime = System.currentTimeMillis();
        SortAlgorithms.InsertionSort.sort(randomArray);
        System.out.println("Insertion Sort time with randomly ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting a inversely ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.InsertionSort.sort(reverseArray);
        System.out.println("Insertion Sort time with inversely ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting an ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.SelectionSort.sort(orderedArray);
        System.out.println("Insertion Sort time with ordered integers is " + (System.currentTimeMillis() - startTime) + " ms" + "\n");

        /**
         * Shell Sort
         */
        System.out.println("------Shell Sort------");
        //Sorting a randomly ordered array
        reloadArray(randomArray,copy);
        startTime = System.currentTimeMillis();
        SortAlgorithms.ShellSort.sort(randomArray);
        System.out.println("Shell Sort time with randomly ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting a inversely ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.ShellSort.sort(reverseArray);
        System.out.println("Shell Sort time with inversely ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting an ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.ShellSort.sort(orderedArray);
        System.out.println("Shell Sort time with ordered integers is " + (System.currentTimeMillis() - startTime) + " ms" + "\n");

        /**
         * Merge Sort
         */
        System.out.println("------Merge Sort------");
        //Sorting a randomly ordered array
        reloadArray(randomArray,copy);
        startTime = System.currentTimeMillis();
        SortAlgorithms.MergeSort.sort(randomArray);
        System.out.println("Merge Sort time with randomly ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting a inversely ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.MergeSort.sort(reverseArray);
        System.out.println("Merge Sort time with inversely ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting an ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.MergeSort.sort(orderedArray);
        System.out.println("Merge Sort time with ordered integers is " + (System.currentTimeMillis() - startTime) + " ms" + "\n");

        /**
         * Quick Sort
         */
        System.out.println("------Quick Sort------");
        //Sorting a randomly ordered array
        reloadArray(randomArray,copy);
        startTime = System.currentTimeMillis();
        SortAlgorithms.QuickSort.sort(randomArray);
        System.out.println("Quick Sort time with randomly ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting a inversely ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.QuickSort.sort(reverseArray);
        System.out.println("Quick Sort time with inversely ordered integers is " + (System.currentTimeMillis() - startTime) + " ms");

        //Sorting an ordered array
        startTime = System.currentTimeMillis();
        SortAlgorithms.QuickSort.sort(orderedArray);
        System.out.println("Quick Sort time with ordered integers is " + (System.currentTimeMillis() - startTime) + " ms" + "\n");

    }


    public static void reloadArray(Integer[] items, Integer[] copy){
        for (int i = 0; i < items.length; i++) {
            items[i] = copy[i];
        }

    }

    public static void inverseArray(Integer[] orderedArray, Integer[] copy){
        for (int i  = 0; i < orderedArray.length / 2; i++){
            int temp = orderedArray[i];
            orderedArray[i] = orderedArray[orderedArray.length - i - 1];
            orderedArray[orderedArray.length - i - 1] = temp;
        }
        reloadArray(orderedArray,copy);
    }
}

