//1.	Is quick sort the best way of finding median? Why? (5%)
//No, quick sort is one of good ways to find median value. In the best case or in average case, it has asymptotic complexity of O(n*logn), however, in the worst case its complexity is O(n^2).
//2.	What is another good way of finding median? Please provide your explanation. (5%)
//Merge sort is another good way to find median. Both quick sort and merge sort use divide and conquer approach and have O(n*logn) complexity in the best and average case.
package noiseremoving;

public class CollectionSort<E extends Comparable<E>> {

    private E[] array;

//this method takes an array of elements of any type as input and sets it as the array to be sorted
    public void setArray(E[] array) {
        this.array = array;
    }

//this method calls recursive method below
    public void quickSort() {
        quickSort(0, array.length - 1);
    }

//this method is recursive method to implement quick sort algorithms
    private void quickSort(int h, int t) {
        if (h < t) {
            int pivotIndex = partition(h, t);
            quickSort(h, pivotIndex - 1);
            quickSort(pivotIndex + 1, t);
        }
    }

//this method partitions the sub-array to be sorted
    private int partition(int h, int t) {
        E pivot = array[t];
        int i = h - 1;

        for (int j = h; j < t; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, t);
        return i + 1;
    }

//this method swaps elements in the array
    private void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
