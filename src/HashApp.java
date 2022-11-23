public class HashApp {
    public static void main(String[] args) {

        HashTable myTable = new HashTable(10);
        HashItem item1 = new HashItem(1);
        HashItem item5 = new HashItem(5);
        HashItem item10 = new HashItem(10);
        HashItem item11 = new HashItem(11);
        myTable.insert(item1);
        myTable.insert(item5);
        myTable.insert(item10);
        myTable.insert(item11);

        System.out.println(myTable.find(5).getKey());

        myTable.remove(1);
        System.out.println(myTable.find(11).getKey());


    }
}

class HashTable {
    private HashItem[] data;
    private int size;

    private HashItem nonItem;

    HashTable(int size) {
        data = new HashItem[size];
        this.size = size;
        nonItem = new HashItem(-1);
    }


    private int toHash(int key) {
        return key % size;
    }

    public HashItem find(int key) {
        int hashKey = toHash(key);

        while (data[hashKey] != null) {
            if (data[hashKey].getKey() == key) {
                return data[hashKey];
            }
            hashKey += 1;
            hashKey %= size;
        }
        return nonItem;

    }

    public void insert(HashItem item) {
        int hashKey = toHash(item.getKey());
        while (data[hashKey] != null && data[hashKey].getKey() != -1) {
            hashKey += 1;
            hashKey %= size;
        }

        data[hashKey] = item;
    }

    public HashItem remove(int key) {
        int hashKey = toHash(key);

        while (data[hashKey].getKey() != key) {
            if (data[hashKey] == null) {
                return nonItem;
            }

            hashKey += 1;
            hashKey %= size;
        }
        HashItem tmp = data[hashKey];
        data[hashKey] = nonItem;
        return tmp;

    }
}


class HashItem {
    private int data;

    HashItem(int key) {
        data = key;
    }

    public int getKey() {
        return data;
    }

}
