public class MergeSortApp {
    public static void main(String[] args) {
        Array myArr = new Array(10);
        myArr.insert(4);
        myArr.insert(3);
        myArr.insert(5);
        myArr.insert(2);
        myArr.insert(1);
        myArr.insert(7);
        myArr.insert(6);
        myArr.display();
        myArr.mergeSort();
        myArr.display();

    }
}

class Array {
    protected int[] a;
    int size;

    Array(int maxSize) {
        a = new int[maxSize];
        size = 0;
    }

    public void insert(int data) {
        a[size++] = data;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void mergeSort() {
        int[] workSpace = new int[size];
        mergeSortRec(workSpace, 0, size - 1);
    }

    private void mergeSortRec(int[] workSpace, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortRec(workSpace, start, mid);
        mergeSortRec(workSpace, mid + 1, end);
        merge(workSpace, start, mid +1, end);
    }

    private void merge(int[] workSpace, int start, int mid, int end) {
        int saveMid = mid;
        int saveStart = start;
        int nums = end - start + 1;
        int index = 0;

        while (start < saveMid && mid <= end) {
            if (a[start] <= a[mid]) {
                workSpace[index++] = a[start++];
            } else {
                workSpace[index++] = a[mid++];
            }

        }

        while (start < saveMid) {
            workSpace[index++] = a[start++];
        }

        while (mid <= end) {
            workSpace[index++] = a[mid++];
        }

        for (int i = 0; i < nums; i++) {
            a[saveStart + i] = workSpace[i];
        }


    }


}
