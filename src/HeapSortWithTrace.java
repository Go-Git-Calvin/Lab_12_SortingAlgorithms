/**
 * Created by Calvin Wong on 11/17/14.
 */
import java.util.*;

public class HeapSortWithTrace {

    int exchanges = 0;
    int comparisons = 0;

    /**
     * Sort the array using heapsort algorithm.
     * @pre table contains Comparable items.
     * post table is sorted.
     * @param table The array to be sorted
     */
    //@Override
    public <T extends Comparable<T>>  void sort(T[] table) {
        buildHeap(table);

        shrinkHeap(table);
    }

    /**
     * buildHeap transforms the table into a heap.
     * @pre  The array contains at least one item.
     * @post All items in the array are in heap order.
     * @param table The array to be transformed into a heap
     */
    private <T extends Comparable<T>>  void buildHeap(T[] table) {
        int n = 1;

        while (n < table.length) {
            n++; // Add a new item to the heap and reheap.
            int child = n - 1;
            int parent = (child - 1) / 2; // Find parent.
            while (parent >= 0
                    && table[parent].compareTo(table[child]) < 0) {
                comparisons++;
                swap(table, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    /**
     * shrinkHeap transforms a heap into a sorted array.
     * @pre All items in the array are in heap order.
     * @post The array is sorted.
     * @param table The array to be sorted
     */
    private <T extends Comparable<T>>  void shrinkHeap(T[] table) {
        int n = table.length;

        while (n > 0) {
            n--;
            swap(table, 0, n);
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break; // No more children.
                }
                int rightChild = leftChild + 1;
                // Find the larger of the two children.
                int maxChild = leftChild;
                if (rightChild < n // There is a right child.
                        && table[leftChild].compareTo(table[rightChild]) < 0) {
                    maxChild = rightChild;
                    comparisons++;
                }
                // If the parent is smaller than the larger child,
                if (table[parent].compareTo(table[maxChild]) < 0) {
                    // Swap the parent and child.
                    swap(table, parent, maxChild);
                    // Continue at the child level.
                    parent = maxChild;
                    comparisons++;
                } else { // Heap property is restored.
                    break;
                }
            }
        }
    }

    /**
     * Swap the items in table[i] and table[j].
     * @param table The array that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private <T extends Comparable<T>>  void swap(T[] table,
                                                 int i, int j) {
        exchanges++;
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
}
