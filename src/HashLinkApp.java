public class HashLinkApp {
    public static void main(String[] args) {
        ChainHashTable myChain = new ChainHashTable(10);
        myChain.insert(3);
        myChain.insert(2);
        myChain.insert(4);
        myChain.insert(1);
        myChain.insert(11);

//        myChain.insert(item1);
//        myChain.insert(item5);
//        myChain.insert(item10);
//        myChain.insert(item11);


    }

}

class ChainHashTable extends HashTable {
    LinkList[] data;
    int size;

    ChainHashTable(int size) {
        super(size);
        data = new LinkList[size];
        this.size = size;

        for (int i = 0; i < size; i++){
            data[i] = new LinkList();
        }
    }

    public void insert(int key) {

        int hashKey = toHash(key);
        LinkList list = data[hashKey];



        list.insertFirst(key);
    }

    public int findItem(int key){
        int hashKey = toHash(key);
        LinkList list = data[hashKey];
        return list.find(key).getKey();
    }

    public int removeItem(int key) {
        int hashKey = toHash(key);
        LinkList list = data[hashKey];
        return list.delete(key).getKey();
    }
}

