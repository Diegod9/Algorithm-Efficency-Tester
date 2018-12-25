import java.util.*;

/**
 * Diego Delgado
 * 11/14/18
 */

public class SortAlgorithms {

    public static class SelectionSort {
        public static void sort(Comparable[] table) {
            int n = table.length;
            for (int fill = 0; fill < n - 1; fill++) {
                int posMin = fill;

                for (int next = fill + 1; next < n; next++) {
                    if (table[next].compareTo(table[posMin]) < 0) {
                        posMin = next;
                    }
                }
                Comparable temp = table[fill];
                table[fill] = table[posMin];
                table[posMin] = temp;

            }
        }
    }

    public static class BubbleSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
            int pass = 1;
            boolean exchanges = false;
            do {
                exchanges = false;

                for (int i = 0; i < table.length - pass; i++) {
                    if (table[i].compareTo(table[i + 1]) > 0) {
                        T temp = table[i];
                        table[i] = table[i + 1];
                        table[i + 1] = temp;
                        exchanges = true;
                    }
                }
                pass++;
            } while (exchanges);
        }
    }

    public static class InsertionSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
            for (int nextPos = 1; nextPos < table.length; nextPos++) {
                insert(table, nextPos);
            }
        }

        private static  <T extends Comparable<T>> void insert(T[] table, int nextPos) {
            T nextVal = table[nextPos];
            while (nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
                table[nextPos] = table[nextPos - 1];
                nextPos--;
            }
            table[nextPos] = nextVal;
        }
    }

    /*
     * Shell sort has O(n^3/2). It is a divide and conquoer version of insterion sort.
     *Shell sort divides the array into many smaller subarrays using insertion sort
     *
     */

    public static class ShellSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
            int gap = table.length / 2;
            while (gap > 0) {
                for (int nextPos = gap; nextPos < table.length; nextPos++) {
                    insert(table, nextPos, gap);
                }

                if (gap == 2) {
                    gap = 1;
                } else {
                    gap = (int) (gap / 2.2);
                }
            }
        }

        private static  <T extends Comparable<T>> void insert(T[] table, int nextPos, int gap) {
            T nextVal = table[nextPos];
            while ((nextPos > gap - 1) && (nextVal.compareTo(table[nextPos - gap]) < 0)) {
                table[nextPos] = table[nextPos - gap];
                nextPos -= gap;
            }

            table[nextPos] = nextVal;
        }
    }


    public static class MergeSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
            //A table with one element is sorted already
            if (table.length > 1) {
                //Split table into halves
                int halfSize = table.length / 2;
                T[] leftTable = (T[]) new Comparable[halfSize];
                T[] rightTable = (T[]) new Comparable[table.length - halfSize];
                System.arraycopy(table, 0, leftTable, 0, halfSize);
                System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);

                //Sort the halves
                sort(leftTable);
                sort(leftTable);

                //Merge the halves
                merge(table, leftTable, rightTable);
            }
        }

        private static  <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence) {
            int i = 0; //Index into the left input sequence
            int j = 0; //Index into the right input sequence
            int k = 0; //Index into the output sequence

            //While there is data in both input sequences
            while (i < leftSequence.length && j < rightSequence.length) {
                //Find the smaller and insert it into the output sequence
                if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
                    outputSequence[k++] = leftSequence[i++];
                } else {
                    outputSequence[k++] = rightSequence[j++];
                }
            }
            //Copy remaining input from the left sequence into the output
            while (i < leftSequence.length) {
                outputSequence[k++] = leftSequence[i++];
            }
            //Copy remaining input from right sequence into output
            while (j < rightSequence.length) {
                outputSequence[k++] = rightSequence[j++];
            }
        }
    }

    public static class QuickSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
            //Sort the whole table
            quickSort(table, 0, table.length - 1);
        }
        private static <T extends Comparable<T>> void quickSort(T[] table, int first, int last){
            if (first < last){ //There is data to be stored
                //Partition the table
                int pivIndex = partition(table, first, last);
                //Sort the left half
                quickSort(table, first, pivIndex - 1);
                //Sort the right half
                quickSort(table, pivIndex + 1, last);
            }
        }

        private static <T extends Comparable<T>> void swap(T[] table, int i, int j){
            T temp = table[i];
            table[i] = table[j];
            table[j] = temp;
        }

        private static <T extends Comparable<T>> int partition(T[] table, int first, int last){

            //Select the first item as the pivot value
            T pivot = table[first];
            int up = first;
            int down = last;

            do{
                while ((up < last) && (pivot.compareTo(table[up]) >= 0)){
                    up ++;
                }
                while (pivot.compareTo(table[down]) < 0){
                    down--;
                }
                if (up < down) { //if up is to the left of down
                    //Exchange table[up] and table[down]
                    swap(table, up, down);
                }
            } while (up < down);
            swap(table, first, down);
            return down;
        }
    }

}





