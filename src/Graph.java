public class Graph<V> {
    private final MyMap<V, MyList<Edge<V>>> adjacencyList;
    boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyList = new MyMap<>();
    }

    public void addVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            return;
        }

        MyList<Edge<V>> newList = new MyList<>();
        adjacencyList.put(v, newList);
    }

    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    public void removeVertex(V v) {
        if (!adjacencyList.containsKey(v)) {
            throw new VertexNotFoundException("Вершина '" + v + "' не существует");
        }
        for (int i = 0; i < adjacencyList.size(); i++) {
            Entry<V, MyList<Edge<V>>> entry = adjacencyList.getEntry(i);
            MyList<Edge<V>> edges = entry.value;
            for (int j = edges.getSize() - 1; j >= 0; j--) {
                if (edges.get(j).to.equals(v)) {
                    edges.remove(j);
                }
            }
        }
        adjacencyList.remove(v);
    }


    public void addEdge(V from, V to, int weight) {
        if (!adjacencyList.containsKey(from)) {
            throw new VertexNotFoundException("Вершина '" + from + "' не существует");
        }
        if (!adjacencyList.containsKey(to)) {
            throw new VertexNotFoundException("Вершина '" + to + "' не существует");
        }

        adjacencyList.get(from).add(new Edge<>(to, weight));


        if (!directed) {
            adjacencyList.get(to).add(new Edge<>(from, weight));
        }
    }

    public void removeEdge(V from, V to) {
        if (!adjacencyList.containsKey(from)) {
            throw new VertexNotFoundException("Вершина '" + from + "' не существует");
        }
        if (!adjacencyList.containsKey(to)) {
            throw new VertexNotFoundException("Вершина '" + to + "' не существует");
        }

        MyList<Edge<V>> edgesFrom = adjacencyList.get(from);

        for (int i = edgesFrom.getSize() - 1; i >= 0; i--) {  // обратный цикл
            if (edgesFrom.get(i).to.equals(to)) {
                edgesFrom.remove(i);
            }
        }
        if (!directed) {
            MyList<Edge<V>> edgesTo = adjacencyList.get(to);
            for (int i = edgesTo.getSize() - 1; i >= 0; i--) {  // обратный цикл
                if (edgesTo.get(i).to.equals(from)) {
                    edgesTo.remove(i);
                }
            }
        }
    }

    private void dfsRecursive(V start, MyMap<V,Boolean> visited){
        visited.put(start,true);
        System.out.println(start);

        MyList<Edge<V>> edges = adjacencyList.get(start);

        for(int i = 0; i < edges.getSize(); i++){
            boolean isVisited = false;
            if (visited.containsKey(edges.get(i).to)){
                isVisited = true;
            }
            if (!isVisited){
                dfsRecursive(edges.get(i).to, visited);
            }
        }
    }

    public void dfs(V start){
        MyMap<V, Boolean> visited = new MyMap<>();
        dfsRecursive(start, visited);
    }

    public void bfs(V start){
        MyQueue<V> queue = new MyQueue<>();
        MyMap<V, Boolean> visited = new MyMap<>();

        queue.enqueue(start);
        visited.put(start,true);

        while(!queue.isEmpty()){
            V current = queue.dequeue();
            System.out.println(current);

            MyList<Edge<V>> edges = adjacencyList.get(current);

            for (int i = 0; i < edges.getSize();i++){
                Edge<V> e = edges.get(i);
                V next = e.to;

                if (!visited.containsKey(next)){
                    queue.enqueue(next);
                    visited.put(next,true);
                }
            }
        }
    }
    public void printGraph(){
        System.out.println("Вывод в формате[from -> to = weight]");
        for (int i = 0; i < adjacencyList.size(); i++){
            Entry<V, MyList<Edge<V>>> Vertex = adjacencyList.getEntry(i);
            int size = Vertex.value.getSize();
            for (int j = 0; j < size; j++){
                System.out.println("[" + Vertex.key + " -> " + Vertex.value.get(j).to + " = " + Vertex.value.get(j).weight + "]");
            }
        }
    }



}
