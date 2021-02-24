package task.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSolution {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int THREADS = 4;
    private List<Integer> integerList;

    public ExecutorServiceSolution(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public int sum() {
        int size = integerList.size();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            callableTasks.add(new CallableImpl(integerList,
                    i * size / NUMBER_OF_THREADS,
                    (i + 1) * size / NUMBER_OF_THREADS));
        }
        int totalSum = 0;
        List<Future<Integer>> futures = null;
        try {
            futures = executorService.invokeAll(callableTasks);
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }
            return totalSum;
        } catch (InterruptedException e) {
            throw new RuntimeException("Can't invoke all callableTasks", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Can't get all callableTasks", e);
        } finally {
            executorService.shutdown();
        }
    }
}
