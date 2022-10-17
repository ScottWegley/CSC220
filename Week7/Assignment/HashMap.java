package Week7.Assignment;

public class HashMap<KEYTYPE, DATATYPE> extends HashMapBase<KEYTYPE, DATATYPE> {

    public HashMap(int i) {
        N = i;
        hashmap = new SingleLinkedList[N];
    }

    @Override
    protected int hash(Object key) {
        String s = key.toString();
        int sum = 0;
        // -- Sum up all the characters in the string
        for (int i = 0; i < s.length(); ++i) {
            sum += s.charAt(i);
        }
        // Return the sum mod the table size
        return sum;
    }

    @Override
    public void add(Object key, Object e) {
        int loc = hash(key) % hashmap.length;
        if (hashmap[loc] == null) {
            hashmap[loc] = new SingleLinkedList<HashMapNode<KEYTYPE, DATATYPE>>();
            hashmap[loc].add(new HashMapNode<KEYTYPE, DATATYPE>((KEYTYPE) key, (DATATYPE) e));
            return;
        }
        for (HashMapNode<KEYTYPE, DATATYPE> x : hashmap[loc]) {
            if (x.key.equals(key)) {
                System.out.println("Hash Match between " + x.key + " and " + key + ": " + hash(x.key));
                x.value = (DATATYPE) e;
                return;
            }
        }
        hashmap[loc].add(new HashMapNode<KEYTYPE, DATATYPE>((KEYTYPE) key, (DATATYPE) e));
    }

    @Override
    public int[] getSizes() {
        int[] sizes = new int[hashmap.length];
        for (int i = 0; i < hashmap.length; i++) {
            sizes[i] = hashmap[i].size;
        }
        return sizes;
    }

}
