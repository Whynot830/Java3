package Snapshot;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<PCMemento> mementoList = new ArrayList<>();

    public void add(PCMemento state) {
        mementoList.add(state);
    }
    public PCMemento get(int index) {
        return mementoList.get(index);
    }

}
