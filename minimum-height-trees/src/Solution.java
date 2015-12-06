import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (edges.length == 0) {
            return Arrays.asList(0);
        }

        Map<Integer, Set<Integer>> connections = new HashMap<>();
        Map<Integer, AtomicInteger> indegrees = new HashMap<>();

        // init
        for (int i = 0; i < n; i++) {
            connections.put(i, new HashSet<>());
            indegrees.put(i, new AtomicInteger(0));
        }

        for (int i = 0; i < edges.length; i++) {
            connections.get(edges[i][0]).add(edges[i][1]);
            indegrees.get(edges[i][0]).getAndIncrement();
            connections.get(edges[i][1]).add(edges[i][0]);
            indegrees.get(edges[i][1]).getAndIncrement();
        }

        Queue<Integer> dequeue = new LinkedList<>();
        for (Integer i : indegrees.keySet()) {
            if (indegrees.get(i).get() == 1) {
                dequeue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!dequeue.isEmpty()) {
            int size = dequeue.size();
            result = new ArrayList<>();
            while (size-- > 0) {
                int c = dequeue.poll();
                result.add(c);
                for (Integer node : connections.get(c)) {
                    AtomicInteger indegree = indegrees.get(node);
                    if (indegree.decrementAndGet() == 1) {
                        dequeue.add(node);
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[][] input = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        List<Integer> output = findMinHeightTrees(4, input);
        assertEquals(1, output.size());
        assertEquals(1, output.get(0).intValue());
    }

    @Test
    public void test2() {
        int[][] input = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> output = findMinHeightTrees(6, input);
        assertEquals(2, output.size());
        assertEquals(3, output.get(0).intValue());
        assertEquals(4, output.get(1).intValue());
    }
}
