import java.util.Scanner;

public class GraphConsole {

    private final Graph<String> graph;
    private final Scanner scanner = new Scanner(System.in);

    public GraphConsole(Graph<String> graph) {
        this.graph = graph;
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = readInt("Ваш выбор: ");

            switch (choice) {
                case 1 -> addVertex();
                case 2 -> addEdge();
                case 3 -> removeVertex();
                case 4 -> removeEdge();
                case 5 -> printGraph();
                case 6 -> dfs();
                case 7 -> bfs();
                case 0 -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Неверный пункт меню.");
            }
        }
    }


    private void printMenu() {
        System.out.println("\n--- МЕНЮ ГРАФА ---");
        System.out.println("1. Добавить вершину");
        System.out.println("2. Добавить ребро");
        System.out.println("3. Удалить вершину");
        System.out.println("4. Удалить ребро");
        System.out.println("5. Вывести граф");
        System.out.println("6. DFS");
        System.out.println("7. BFS");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    private void addVertex() {
        String Vertex = readString("Введите название вершины: ");
        graph.addVertex(Vertex);
    }

    private void addEdge() {
        String from = readString("Введите from: ");
        String to = readString("Введите to: ");
        int w = readInt("Вес ребра: ");

        try {
            graph.addEdge(from, to, w);
        } catch (VertexNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


    private void removeVertex() {
        String Vertex = readString("Введите вершину: ");
        graph.removeVertex(scanner.nextLine());
    }

    private void removeEdge() {
        System.out.print("Введите from: ");
        String from = scanner.nextLine();
        System.out.print("Введите to: ");
        String to = scanner.nextLine();
        graph.removeEdge(from, to);
    }

    private void printGraph() {
        graph.printGraph();
    }

    private void dfs() {
        String start = readString("Стартовая вершина: ");
        try {
            graph.dfs(start);
        } catch (VertexNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


    private void bfs() {
        String start = readString("Стартовая вершина: ");
        try {
            graph.bfs(start);
        } catch (VertexNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }



    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число.");
            }
        }
    }

    private String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Ошибка: строка не может быть пустой.");
        }
    }

}
