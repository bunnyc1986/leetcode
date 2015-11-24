import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Solution {
    public class ZigzagIterator {
        final Iterator<Integer>[] iterators;
        int current = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            iterators = new Iterator[]{v1.iterator(), v2.iterator()};
            gotoAvaliable();
        }

        public int next() {
            if (current == -1) {
                throw new NoSuchElementException();
            }

            int rtn = iterators[current].next();
            current = (current + 1) % iterators.length;
            gotoAvaliable();
            return rtn;
        }

        private void gotoAvaliable() {
            if (iterators[current].hasNext()) {
                return;
            }
            int next = (current + 1) % iterators.length;
            while (!iterators[next].hasNext()) {
                next = (next + 1) % iterators.length;
                if (next == current) {
                    break;
                }
            }
            current = next;
        }

        public boolean hasNext() {
            return iterators[current].hasNext();
        }
    }

    @Test
    public void test1() {
        List<Integer> v1 = Arrays.asList(1,2,3);
        List<Integer> v2 = Arrays.asList(2,4,6,9,11,13);
        ZigzagIterator iterator = new ZigzagIterator(v1, v2);
        while(iterator.hasNext()) {
            System.out.printf("%s,", iterator.next());
        }
    }

}
