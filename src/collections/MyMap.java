public class MyMap<K, V> {
    private Entry<K, V>[] data = new Entry[10];
    private int size = 0;

    private void expand(){
        Entry<K, V>[] new_data = new Entry[data.length * 2];
        for (int i = 0; i < size; i++){
            new_data[i] = data[i];
        }
        data = new_data;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void put(K key, V value){
        if (indexOf(key) != -1) {
            data[indexOf(key)].value = value;
            return;
        }
        if (size == data.length){
            expand();
        }
        data[size++] = new Entry<>(key,value);
    }

    public V get(K key){
        if (indexOf(key) == -1){
            return null;
        }
        return data[indexOf(key)].value;
    }

    public void remove(K key){
        int index = indexOf(key);
        for (int i = index; i < data.length - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
    }

    public boolean containsKey(K key){
        if (indexOf(key) != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public Entry<K, V> getEntry(int index){
        return data[index];
    }
}
