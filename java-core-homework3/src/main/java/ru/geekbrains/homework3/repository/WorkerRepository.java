package ru.geekbrains.homework3.repository;

import ru.geekbrains.homework3.model.BaseWorker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class WorkerRepository implements Iterable<BaseWorker> {

    private List<BaseWorker> workers = new ArrayList<>();

    public WorkerRepository(List<BaseWorker> workers) {
        this.workers = workers;
    }

    public WorkerRepository() {
    }

    public void addWorker(BaseWorker worker) {
        workers.add(worker);
    }

    public void addAllWorkers(List<BaseWorker> workers) {
        this.workers.addAll(workers);
    }

    public String findWorkerById(int id) {
        for (BaseWorker worker : workers) {
            if (worker.getId() == id) {
                return String.format("Найден рабочий: %s",worker);
            }
        }
        return null;
    }

    public List<BaseWorker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<BaseWorker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "WorkerRepository:"
                + workers ;
    }

    @Override
    public Iterator<BaseWorker> iterator() {
        return workers.iterator();
    }

}
