import java.util.Scanner;

public class AnnApp {
    static int size;
    static int count;
    static char[] array = new char[5];

    public static void main(String[] args) {
        String string = getString();
        doAnag(size);
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        size = string.length();

        for (int i = 0; i < size; i++)
            array[i] = string.charAt(i);

        return string;
    }

    public static void printWord() {
        System.out.print(++count + " ");
        for (char chr : array)
            System.out.print(chr);
        System.out.println();
    }

    public static void doAnag(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            doAnag(newSize - 1);
            if (newSize == 2) {
                printWord();
            }
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int j;
        int pos = size - newSize;
        char tmp = array[pos];
        for (j = pos + 1; j < size; j++) {
            array[j - 1] = array[j];
        }
        array[j - 1] = tmp;

    }
}
