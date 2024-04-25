package ru.geekbrains.homework3.comporator;

import ru.geekbrains.homework3.model.BaseWorker;

import java.util.Comparator;

public class WorkerNameComparator implements Comparator<BaseWorker> {

    @Override
    public int compare(BaseWorker o1, BaseWorker o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
