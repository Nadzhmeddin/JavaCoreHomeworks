package ru.geekbrains.homework3.comporator;

import ru.geekbrains.homework3.model.BaseWorker;

import java.util.Comparator;

public class WorkerIdComparator implements Comparator<BaseWorker> {
    @Override
    public int compare(BaseWorker o1, BaseWorker o2) {
        if(o1.getId() > o2.getId()) {
            return 1;
        } else if(o1.getId() < o2.getId()) {
            return -1;
        } else return 0;
    }
}
