public class MyQueue<T>{
    MyList<T> queue = new MyList<>();
    public Boolean isEmpty(){
        return (queue.getSize() == 0);
    }

    public void enqueue(T value){
        queue.add(value);
    }
    public T dequeue() {
        if (isEmpty()){
            System.out.println("Очередь пуста");
            return null;
        }
        T value = queue.get(0);
        queue.remove(0);
        return value;
    }

}
