package task.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolSolution extends RecursiveTask<Integer> {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int THRESHOLD = 100_000;
    private final List<Integer> integerList;

    public ForkJoinPoolSolution(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<ForkJoinPoolSolution> createTasks() {
        List<ForkJoinPoolSolution> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            list.add(new ForkJoinPoolSolution(
                    integerList.subList(i * integerList.size() / NUMBER_OF_THREADS,
                            (i + 1) * integerList.size() / NUMBER_OF_THREADS)));
        }
        return list;
    }

    @Override
    protected Integer compute() {
        if (integerList.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createTasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return integerList
                .stream()
                .mapToInt(i -> i)
                .sum();
    }
}
