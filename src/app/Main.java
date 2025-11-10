import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ваш граф ориентированный?(True or False)");
        Boolean isDirected = Boolean.parseBoolean(scan.nextLine());
        Graph<String> graph = new Graph<>(isDirected);
        GraphConsole console = new GraphConsole(graph);
        console.start();
    }
}
