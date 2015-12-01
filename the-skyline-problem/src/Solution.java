import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }

        List<Marker> markers = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            Marker start = new Marker(buildings[i][0], true, buildings[i][2]);
            Marker end = new Marker(buildings[i][1], false, buildings[i][2]);
            markers.add(start);
            markers.add(end);
        }
        markers.sort(new Comparator<Marker>() {
            @Override
            public int compare(Marker o1, Marker o2) {
                return Integer.compare(o1.index, o2.index);
            }
        });
        markers.add(null);
        List<int[]> results = new ArrayList<>();
        PriorityQueue<Integer> maxHeight = new PriorityQueue<>(Collections.reverseOrder());
        maxHeight.add(0);
        Iterator<Marker> itor = markers.iterator();
        int prevHeight = 0;
        int prevIndex = 0;
        Marker m = itor.next();
        while(m != null) {
            do {
                if (m.isStart) {
                    maxHeight.add(m.height);
                } else {
                    maxHeight.remove(m.height);
                }
                prevIndex = m.index;
                m = itor.next();
            }while(itor.hasNext() &&
                    m != null &&
                    m.index == prevIndex);

            int currentHeight = maxHeight.peek();
            if (currentHeight != prevHeight) {
                results.add(new int[] {prevIndex, currentHeight});
            }
            prevHeight = currentHeight;
        }
        return results;
    }

    class Marker {
        int index;
        boolean isStart;
        int height;

        Marker(int index, boolean isStart, int height) {
            this.index = index;
            this.isStart = isStart;
            this.height = height;
        }
    }

    @Test
    public void test() {
        int[][] buildings = new int[][]{
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        };

        List<int[]> results = getSkyline(buildings);
        for (int[] entry : results) {
            System.out.println(Arrays.toString(entry));
        }
    }
}
