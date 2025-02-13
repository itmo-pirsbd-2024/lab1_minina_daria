package org.example;
import java.util.*;

public class Main {

    public static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.target;

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Edge(v, distances[v]));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        // Пример графа
        List<List<Edge>> graph = new ArrayList<>();
        graph.add(Arrays.asList(new Edge(1, 4), new Edge(2, 1))); // 0 -> 1 (4), 0 -> 2 (1)
        graph.add(Arrays.asList(new Edge(3, 1)));               // 1 -> 3 (1)
        graph.add(Arrays.asList(new Edge(1, 2), new Edge(3, 5))); // 2 -> 1 (2), 2 -> 3 (5)
        graph.add(Collections.emptyList());                     // 3

        // Замер времени и памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        // Вызов алгоритма
        int[] distances = dijkstra(graph, 0);

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        // Вывод результатов
        System.out.println("Кратчайшие расстояния от вершины 0: " + Arrays.toString(distances));
        System.out.println("Время выполнения: " + (endTime - startTime) + " наносекунд");
        System.out.println("Использовано памяти: " + (memoryAfter - memoryBefore) + " байт");
    }
}

