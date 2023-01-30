package Adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    private Map<String, List<String>> graph = new HashMap<>();

    public int minMutation(String start, String end, String[] bank) {
        // Early exit condition
        if (!Arrays.asList(bank).contains(end)) return -1;

        addWordVerticesToGraph(start);
        // Seed the graph
        for (String word : bank) {
            addWordVerticesToGraph(word);
        }

        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        Queue<QueueElement> queue = new LinkedList<>();
        queue.offer(new QueueElement(start, 0));

        while (!queue.isEmpty()) {
            QueueElement element = queue.poll();

            if (element.word.equals(end)) {
                return element.distance;
            }

            for (String vertex : generateWordVertices(element.word)) {
                for (String adjacentVertex : graph.get(vertex)) {
                    if (!visited.contains(adjacentVertex)) {
                        visited.add(adjacentVertex);
                        queue.offer(new QueueElement(adjacentVertex, element.distance + 1));
                    }
                }
            }
        }

        return -1;

    }

    private List<String> generateWordVertices(String word) {
        List<String> vertices = new ArrayList<>();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            String vertex = word.substring(0, i) + "#" + word.substring(i + 1);
            vertices.add(vertex);
        }
        return vertices;

    }

    private void addWordVerticesToGraph(String word) {
        for (String vertex : generateWordVertices(word)) {
            if (!graph.containsKey(vertex)) {
                graph.put(vertex, new ArrayList<>());
            }

            graph.get(vertex).add(word);
        }
    }


    private static class QueueElement {
        private String word;
        private int distance;

        public QueueElement(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }
}