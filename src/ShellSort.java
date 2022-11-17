public class ShellSort {

    public static void main(String[] args) {
        ShellArray myArr = new ShellArray(20);
        myArr.insert(3);
        myArr.insert(5);
        myArr.insert(4);
        myArr.insert(2);
        myArr.insert(1);
        myArr.insert(4);
        myArr.insert(5);
        myArr.insert(6);
        myArr.display();
        myArr.shellSort();
        myArr.display();

    }

}

class ShellArray extends Array {

    ShellArray(int maxSize) {
        super(maxSize);
    }

    public void shellSort() {
        int len = this.size;
        int step = len / 2; //можно менять шаг

        while (step > 0) {
            for (int i = step; i < len; i++) {
                int pos = i;
                int temp = a[pos];

                while (pos >= step && temp < a[pos - step]) {
                    a[pos] = a[pos-step];
                    pos = pos - step;
                }
                a[pos] = temp;
            }
            step = step / 2;
        }
    }
}
