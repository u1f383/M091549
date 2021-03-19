import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;
import java.util.stream.Stream;

class MyPriorityQueueTest {
    private static Stream<Arguments> correctResult() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 6, 9}, new int[]{2, 5, 6, 9}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{7, 0, 1, 8}, new int[]{0, 1, 7, 8}),
                Arguments.of(new int[]{9, 11, 7, 10}, new int[]{7, 9, 10, 11}),
                Arguments.of(new int[]{1, 6, -3, 400}, new int[]{-3, 1, 6, 400})
        );
    }

    @ParameterizedTest
    @MethodSource("correctResult")
    public void correctResultPriorityQueueTest(int input[], int expected[]) {
        PriorityQueue pq = new PriorityQueue();

        for (int i: input) {
            pq.offer(i);
        }

        for (int e: expected) {
            assertEquals(pq.poll(), e, "Prioritize failed.");
        }
    }

    @Test
    public void illegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
    }

    @Test
    public void nullPointerExceptionTest() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue pq = new PriorityQueue();
            pq.offer(null);
            new PriorityQueue(pq);
        });
    }

    @Test
    public void classCastExceptionTest() {
        assertThrows(ClassCastException.class, () -> {
            PriorityQueue pq = new PriorityQueue();
            pq.offer(1);
            pq.offer("A");
            new PriorityQueue(pq);
        });
    }
}