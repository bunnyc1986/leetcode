import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * http://www.lintcode.com/en/problem/topological-sorting/
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nei : node.neighbors) {
                Integer counter = inDegrees.get(nei.label);
                if (counter == null) {
                    counter = 0;
                }
                inDegrees.put(nei.label, ++counter);
            }
        }
        Queue<DirectedGraphNode> nodeQueue = new LinkedList<>();
        // add all nodes with indegree = 0
        for (DirectedGraphNode node : graph) {
            if (inDegrees.get(node.label) == null) {
                nodeQueue.add(node);
            }
        }
        ArrayList<DirectedGraphNode> sorted = new ArrayList<>();
        while (nodeQueue.size() > 0) {
            DirectedGraphNode node = nodeQueue.poll();
            sorted.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                int inDegree = inDegrees.get(neighbor.label);
                inDegree--;
                if (inDegree == 0) {
                    nodeQueue.add(neighbor);
                }
                inDegrees.put(neighbor.label, inDegree);
            }
        }
        return sorted;
    }

    @Test
    public void test() {
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        DirectedGraphNode node0 = new DirectedGraphNode(0);
        DirectedGraphNode node1 = new DirectedGraphNode(1);
        DirectedGraphNode node2 = new DirectedGraphNode(2);
        DirectedGraphNode node3 = new DirectedGraphNode(3);
        DirectedGraphNode node4 = new DirectedGraphNode(4);
        DirectedGraphNode node5 = new DirectedGraphNode(5);
        node0.neighbors.addAll(Arrays.asList(node2, node3, node4));
        node1.neighbors.add(node4);
        node2.neighbors.addAll(Arrays.asList(node4, node5));
        node3.neighbors.addAll(Arrays.asList(node4, node5));
        node5.neighbors.addAll(Arrays.asList(node1));
        graph.addAll(Arrays.asList(node0, node1, node2, node3, node4, node5));
        ArrayList<DirectedGraphNode> sorted = topSort(graph);
        List<Integer> sortedLabels = sorted.stream().map(node -> node.label).collect(Collectors.toList());
        System.out.println(sortedLabels); // [0, 2, 3, 5, 1, 4]
    }

    static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
