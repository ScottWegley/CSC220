package Week7.Assignment;

// -- you will need to change this import statement
//    to bring in your DoubleLinkedList from the
//    appropriate package

public abstract class HashMapBase<KEYTYPE, DATATYPE> {

    /**
     * the table will hold 257 (default value) linked-lists
     * (prime number larger than the number of items we want
     * to store in the table, ideally 2 * number of values)
     * the default size of the hashmap array, below
     */
    protected int N = 257;

    /**
     * a HashMap is an array of linked-lists of Node<KEYTYPE, DATATYPE>
     * accessed through and index provided by a hash function
     */
    protected SingleLinkedList<HashMapNode<KEYTYPE, DATATYPE>> hashmap[];

    // -- while it cannot be specifed here (because abstract classes
    // cannot contain an constructor, your extending class should
    // include a constructor where the argument is the size of the
    // hashmap, replacing the default value of N above. The constructor
    // must allocate the hashmap[] array and initialize each of its
    // locations with a DoubleLinkedList<Node<KEYTYPE, DATATYPE>>
    //
    // public HashMap(int N)

    /**
     * the hash function
     * 
     * @param key: the value to be hashed
     * @return: the hash value
     */
    protected abstract int hash(KEYTYPE key);

    /**
     * adds a Node<KEYTYPE, DATATYPE> object to the hashmap
     * the node can be added anywhere in the specified linked-list
     * 
     * @param key: the location in the hashmap where e will be inserted
     * @param e:   the object to be inserted
     */
    public abstract void add(KEYTYPE key, DATATYPE e);

    // -- returns an array that contains the size (length) of each
    // linked-list in the hashmap
    /**
     * @return
     */
    public abstract int[] getSizes();

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < hashmap.length; ++i) {
            if (hashmap[i] != null) {
                int j;
                for (j = 0; j < hashmap[i].size() - 1; ++j) {
                    s += hashmap[i].get(j) + ", ";
                }
                s += hashmap[i].get(j) + "\n";
            }
        }
        return s;
    }

    /**
     * Inner class to define the node used by the linked-list
     *
     * @param <KEYTYPE>:  the key type
     * @param <DATATYPE>: the data type
     */
    public class HashMapNode<KEYTYPE, DATATYPE> {

        // -- the object value
        public KEYTYPE key;
        public DATATYPE value;

        // -- parameter is assigned to value
        public HashMapNode(KEYTYPE key, DATATYPE value) {
            this.key = key;
            this.value = value;
        }

        // -- uses toString of object stored at value
        public String toString() {
            return "<" + key + ", " + value + ">";
        }

        @Override
        public boolean equals(Object o) {
            HashMapNode<KEYTYPE, DATATYPE> e = (HashMapNode<KEYTYPE, DATATYPE>) o;
            KEYTYPE lhsK = this.key;
            DATATYPE lhsV = this.value;

            KEYTYPE rhsK = this.key;
            DATATYPE rhsV = this.value;

            return lhsK.equals(rhsK) && lhsV.equals(rhsV);
        }
    }
}
