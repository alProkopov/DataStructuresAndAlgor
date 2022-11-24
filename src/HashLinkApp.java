public class HashLinkApp {
    public static void main(String[] args) {
        ChainHashTable myChain = new ChainHashTable(10);
        HashItem item1 = new HashItem(1);
        HashItem item5 = new HashItem(5);
        HashItem item10 = new HashItem(10);
        HashItem item11 = new HashItem(11);
        myChain.insert(item1);
        myChain.insert(item5);
        myChain.insert(item10);
        myChain.insert(item11);


    }

}

class ChainHashTable extends HashTable {
    LinkList[] data;
    int size;

    ChainHashTable(int size) {
        super(size);
        data = new LinkList[size];
        this.size = size;
    }

    public void insert(HashItem item) {
        int hashKey = toHash(item.getKey());
        Link current =
    }
}

