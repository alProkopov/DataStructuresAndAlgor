public class binaryRec {
    static int[] array;


    public static void main(String[] args) {
        array = new int[]{1, 4, 9, 17, 21, 36, 42};
        int low = 0;
        int up = array.length - 1;

        int key = 36;

        System.out.println(binarySearch(key, low, up));
    }

    public static int binarySearch(int key, int start, int end) {
        int current = (start + end) / 2;
        if (array[current] == key) {
            return current;
        }
        if (start > end) {
            return -1;
        }
        if (array[current] < key) {
            return binarySearch(key, current + 1, end);
        } else {
            return binarySearch(key, start, current - 1);
        }
    }
}
