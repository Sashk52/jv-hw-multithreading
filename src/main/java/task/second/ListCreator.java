package task.second;

import java.util.ArrayList;
import java.util.List;

public class ListCreator {
    public List<Integer> createLists(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }
}
