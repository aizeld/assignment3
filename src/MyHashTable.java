public class MyHashTable <K, V>{
    private class hashNode<K,V>{
        private K key;
        private V value;
        private hashNode<K, V>next;
        public hashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private hashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new hashNode[M];
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new hashNode[M];
    }

    private int Hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value){
        int index = Hash(key);
        hashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        hashNode<K, V> newNode = new hashNode<K, V>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    public V get(K key){
        int index = Hash(key);
        hashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
//    public V remove(K key){}
//    public boolean contains(V value){}
//    public K getkey(V value){}
}
