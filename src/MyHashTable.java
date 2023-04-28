public class MyHashTable <K, V>{
    private class hashNode<K,V>{
        private K key;
        private V value;
        private hashNode<K, V>next;
        public hashNode(K key, V value){
            this.key = K;
            this.value = V;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private hashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){}
}
