public class MyHashTable <K, V>{
    private class hashNode<K,V>{
        private K key;
        private V value;
        private hashNode<K, V>next;
        public hashNode(K key, V value){
            this.key = key;
            this.value = value;
        }


    }

    private hashNode<K, V>[] chainArray;
    private int M = 11;
    public int size = 0;

    public MyHashTable(){
        chainArray = new hashNode[M];
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new hashNode[M];
    }

    private int Hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value){
        int index = Hash(key);
        hashNode<K,V> node = chainArray[index];
        while(node!=null){
            if(node.key.equals(key)){
                node.value = value;
            }
            node = node.next;
        }
        size++;
        node = new hashNode<>(key, value);
        node.next = chainArray[index];
        chainArray[index] = node;
    }
  public V get(K key){
        int index = Hash(key);
        hashNode<K,V> node = chainArray[index];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }

        return null;
  }

  public V remove(K key){
        int index = Hash(key);
        hashNode<K,V> node = chainArray[index];
        hashNode<K,V> prev = null;
        while(node!=null){
            if(node.key.equals(key)){
                if(prev == null){
                    chainArray[index] = node.next;
                }else{
                    prev.next = node.next;
                }
                size--;
            }
            prev = node;
            node = node.next;
        }
        return null;//not found
  }

  public boolean contains(V value){
        for(int i = 0 ; i<M;i++){
            hashNode<K,V> node = chainArray[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return true;
                }
                node = node.next;
            }

        }
        return false;
    }

    public K getkey(V value){
        for(int i =0 ; i < M;i++){
            hashNode<K,V> node = chainArray[i];
            while(node != null){
                if(node.value.equals(value)){
                    return node.key;
                }
                node =node.next;
            }
        }
        return null;
    }

    public int[] getBuckeds(){

        int []buckets = new int [M];
        for(int i =0; i< M;i++){
            int count = 0;
            hashNode<K,V> node = chainArray[i];
            while(node!= null){
                count++;
                node = node.next;
            }
            buckets[i] = count;

        }
        return buckets;

    }


//    public V remove(K key){}
//    public boolean contains(V value){}
//    public K getkey(V value){}
}
