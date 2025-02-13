package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

@BenchmarkMode(Mode.AverageTime) // Измерение среднего времени выполнения
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Вывод результатов в наносекундах
@State(Scope.Benchmark) // Состояние бенчмарка
public class DijkstraBenchmark {

    private Graph graph;

    @Setup(Level.Trial) // Инициализация перед запуском бенчмарка
    public void setup() {
        graph = new Graph();
        graph.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
        graph.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
        graph.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
        graph.addVertex('D', Arrays.asList(new Vertex('F', 8)));
        graph.addVertex('E', Arrays.asList(new Vertex('H', 1)));
        graph.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('D', 8), new Vertex('G', 9), new Vertex('H', 3)));
        graph.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
        graph.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));
    }

    @Benchmark // Метод, который будет тестироваться
    public List<Character> benchmarkShortestPath() {
        return graph.getShortestPath('A', 'H');
    }
}