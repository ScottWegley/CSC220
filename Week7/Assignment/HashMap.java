package Week7.Assignment;

public class HashMap<KEYTYPE, DATATYPE> extends HashMapBase<KEYTYPE, DATATYPE> {

    public HashMap(int i) {
        N = i;
        hashmap = new SingleLinkedList[N];
    }

    @Override
    protected int hash(Object key) {
        String s = key.toString();
        int h = 0, high;
        for (int i = 0; i < s.length(); ++i) {
            h = ( h << 4 ) + s.charAt(i);
            if ((high = h & 0xF0000000) != 0) {
                h ^= high >> 24;
            }
            h &= ~high;
        }
        return h;
    }

    @Override
    public void add(Object key, Object e) {
        int loc = hash(key) % hashmap.length;
        if(hashmap[loc] == null) {
            hashmap[loc] = new SingleLinkedList<HashMapNode<KEYTYPE, DATATYPE>>();
            hashmap[loc].add(new HashMapNode<KEYTYPE,DATATYPE>((KEYTYPE)key, (DATATYPE)e));
            return;
        }
        for(HashMapNode<KEYTYPE, DATATYPE> x : hashmap[loc]){
            if(x.key.equals(key)) {
                x.value = (DATATYPE) e;
                return;
            }
        }
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
