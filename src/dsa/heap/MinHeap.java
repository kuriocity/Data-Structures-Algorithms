package dsa.heap;

public class MinHeap {
    int[] array;
    int size;
    int capacity;

    MinHeap(int c) {
        this.capacity = c;
        array = new int[capacity];
        size = 0;
    }

    int left(int index) {
        return 2 * index + 1;
    }

    int right(int index) {
        return 2 * index + 2;
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    void insert(int element) {

    }

    void minHeapify(int index) {

    }

    void maxHeapify(int index) {

    }

    int extractMin() {
        return -1;
    }

    void decreaseKey(int index, int value) {

    }

    void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);

    }

    /**
     * <h2>Given random array rearrange its elements to form min heap</h2>
     */
    void buildMinHeap() {


    }

    void buildMaxHeap() {

    }
    void heapSort() {

    }


}
