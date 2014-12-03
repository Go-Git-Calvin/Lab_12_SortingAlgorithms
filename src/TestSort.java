import java.util.Random;

/**
 * TestSort.java
 *
 * Created by Calvin Wong on 11/17/14.
 *
 * Tester for Sort Algorithms
 */
public class TestSort {

    public static void main(String[] args) {

        // Integer array
        Integer[] numbers = new Integer[500];
        Random rand = new Random();

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(500);
        }

        // String array
        String[] strings = { "Alonzo", "Aliza", "Tequila", "Jannie", "Alfonso", "Elbert", "Lakisha", "Fredia",
        "Delfina", "Marquis", "Rickie", "Edra", "Dirk", "Melvina", "Crysta", "Rona", "Latanya", "Debrah", "Delphia",
        "Curtis", "Calvin", "Paul", "Eric", "Danny", "Benson", "Amare", "Carmello", "Pierce" };

        // Bubble Sort
        long startTime = System.currentTimeMillis();
        BubbleSortWithTrace.sort(numbers); // Bubble Sort
        BubbleSortWithTrace.sort(strings);
        long endTime = System.currentTimeMillis();
        System.out.println("Time it took: " + ((endTime-startTime) / 1000.0) + " seconds");

        // Heap Sort
        HeapSortWithTrace heap = new HeapSortWithTrace();
        long start = System.currentTimeMillis();
        heap.sort(numbers); // Heap sort
        heap.sort(strings);
        long end = System.currentTimeMillis();
        System.out.println("Time it took Heap sort: " + ((end - start) / 1000.0) + " seconds");

        // Insertion Sort
        long start2 = System.currentTimeMillis();
        InsertionSortWithTrace.sort(numbers); // Insertion Sort
        InsertionSortWithTrace.sort(strings);
        long end2 = System.currentTimeMillis();
        System.out.println("Time it took InsertionSort: " + ((end2 - start2) / 1000.0));

        // Quick Sort
        long start3 = System.currentTimeMillis();
        QuickSort1WithTrace.sort(numbers); // Quick Sort
        QuickSort1WithTrace.sort(strings);
        long end3 = System.currentTimeMillis();
        System.out.println("Time it took QuickSort: " + ((end3 - start3) / 1000.0));

        // Selection Sort
        long start4 = System.currentTimeMillis();
        SelectionSortWithTrace.sort(numbers); // Selection Sort
        SelectionSortWithTrace.sort(strings);
        long end4 = System.currentTimeMillis();
        System.out.println("Time it took SelectionSort: " + ((end4 - start4) / 1000.0));

    }
} // end of class
