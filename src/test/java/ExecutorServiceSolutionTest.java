import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task.second.ExecutorServiceSolution;
import task.second.ListCreator;

public class ExecutorServiceSolutionTest {
    private static ListCreator listCreator;
    private ExecutorServiceSolution executorServiceSolution;

    @Before
    public void beforeTests() {
        listCreator = new ListCreator();
    }

    @Test
    public void positiveNumberSum_ok() {
        List<Integer> list = listCreator.createLists(0, 1_000_000);
        executorServiceSolution = new ExecutorServiceSolution(list);
        Integer expected = list
                .stream()
                .reduce(0, Integer::sum);
        Integer actually = executorServiceSolution.sum();
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void negativeNumberSum_ok() {
        List<Integer> list = listCreator.createLists(-10, -2);
        executorServiceSolution = new ExecutorServiceSolution(list);
        Integer expected = list
                .stream()
                .reduce(0, Integer::sum);
        Integer actually = executorServiceSolution.sum();
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void emptyList_ok() {
        List<Integer> list = listCreator.createLists(0, 0);
        executorServiceSolution = new ExecutorServiceSolution(list);
        Integer expected = list
                .stream()
                .reduce(0, Integer::sum);
        Integer actually = executorServiceSolution.sum();
        Assert.assertEquals(expected, actually);
    }
}
