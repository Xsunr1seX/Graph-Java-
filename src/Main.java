//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);





        graph.addEdge(0, 1,5);
        graph.addEdge(0,2,5);
        graph.addEdge(0,3,5);
        graph.addEdge(1,4,5);
        graph.addEdge(1,5,5);
        graph.addEdge(2,6,5);
        graph.addEdge(3,7,5);
        graph.printGraph();
        graph.dfs(0);
    }
}