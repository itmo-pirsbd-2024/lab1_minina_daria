package org.example;

public class PerformanceRunner {
    public static void main(String[] args) {
        Graph graph = new Graph();
        // Инициализация графа (можно добавить большие данные)
        // Пример: многократный вызов метода для профилирования
        for (int i = 0; i < 100000; i++) {
            graph.getShortestPath('A', 'H');
        }
    }
}