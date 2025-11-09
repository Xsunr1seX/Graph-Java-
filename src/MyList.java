public class MyList<T> {
    private Object[] data = new Object[10];
    private int size = 0;

    private void expand() {
        int newSize = data.length * 2;
        Object[] newArray = new Object[newSize];

        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    public void add(T value) {
        if (size == data.length) {
            expand();
        }
        data[size++] = value;
    }

    public int getSize() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    public T get(int index){
        checkIndex(index);
        return (T) data[index];
    }

    public void set(T value,int index) {
            checkIndex(index);
            data[index] = value;

    }

    public void remove(int index){
        checkIndex(index);


        for(int i = index; i < getSize() - 1; i++){
            this.data[i] = this.data[i+1];
        }
        size--;
        data[size] = null;
    }


}
