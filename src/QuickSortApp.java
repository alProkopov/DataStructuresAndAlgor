public class QuickSortApp {
    public static void main(String[] args) {
        int[] myArr = new int[]{4, 3, 1, 8, 6, 2, 7, 1, 2, 3};
        quickSort(myArr, 0, myArr.length - 1);
        for (int item : myArr) {
            System.out.print(item + " ");
        }


    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);

        quickSort(array, start, index - 1);
        quickSort(array, index, end);
    }

    public static int partition(int[] array, int start, int end) {
        int startIndex = start;
        int endIndex = end;
        int pivot = array[startIndex];

        while (startIndex <= endIndex) {

            while (array[startIndex] < pivot) {
                startIndex++;
            }

            while (array[endIndex] > pivot) {
                endIndex--;
            }

            if (startIndex <= endIndex) {
                swap(array, startIndex, endIndex);
                startIndex++;
                endIndex--;
            }
        }
        return startIndex;
    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
