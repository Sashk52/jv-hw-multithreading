package task.second;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForkJoinPoolSolutionTest {
    private static ListCreator listCreator;
    private ForkJoinPoolSolution forkJoinPoolSolution;

    @Before
    public void beforeTest() {
        listCreator = new ListCreator();
    }

    @Test
    public void positiveNumberSum_ok() {
        List<Integer> list = listCreator.createLists(0, 1_000_000);
        forkJoinPoolSolution = new ForkJoinPoolSolution(list);
        Integer expected = list
                .stream()
                .reduce(0, Integer::sum);
        Integer actually = forkJoinPoolSolution.compute();
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void negativeNumberSum_ok() {
        List<Integer> list = listCreator.createLists(-10, -2);
        forkJoinPoolSolution = new ForkJoinPoolSolution(list);
        Integer expected = list
                .stream()
                .reduce(0, Integer::sum);
        Integer actually = forkJoinPoolSolution.compute();
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void emptyList_ok() {
        List<Integer> list = listCreator.createLists(0, 0);
        forkJoinPoolSolution = new ForkJoinPoolSolution(list);
        Integer expected = list
                .stream()
                .reduce(0, Integer::sum);
        Integer actually = forkJoinPoolSolution.compute();
        Assert.assertEquals(expected, actually);
    }
}
