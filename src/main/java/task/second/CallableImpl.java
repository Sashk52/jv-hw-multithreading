package task.second;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableImpl implements Callable<Integer> {
    private final List<Integer> integerList;
    private final int start;
    private final int end;

    public CallableImpl(List<Integer> integerList, int start, int end) {
        this.integerList = integerList;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        return integerList
                .subList(start, end)
                .stream()
                .mapToInt(Math::toIntExact)
                .sum();
    }
}
