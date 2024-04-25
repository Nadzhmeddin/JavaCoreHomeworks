package ru.geekbrains.homework3;

import ru.geekbrains.homework3.comporator.WorkerIdComparator;
import ru.geekbrains.homework3.comporator.WorkerNameComparator;
import ru.geekbrains.homework3.model.BaseWorker;
import ru.geekbrains.homework3.model.Freelancer;
import ru.geekbrains.homework3.model.Worker;
import ru.geekbrains.homework3.repository.WorkerRepository;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Freelancer freelancer1 = Freelancer.createFreelancer(1, "Mike", 2000);
        Worker worker1 = Worker.createFreelancer(2, "Donna", 30000);
        Freelancer freelancer2 = Freelancer.createFreelancer(3, "Danny", 1500);
        Worker worker2 = Worker.createFreelancer(4, "John", 47500);
        Freelancer freelancer3 = Freelancer.createFreelancer(5, "Steve", 320);
        Worker worker3 = Worker.createFreelancer(6, "Jack", 52000);


        // Пример расчета зарплаты с фрилансером и работником.
        System.out.println(freelancer1.getHourlySalary());
        System.out.println(worker1.getMonthlySalary());

        // Создание листа на базе абстрактного класса, далее заполнение данными.
        List<BaseWorker> workers = new ArrayList<>();

        workers.add(freelancer1);
        workers.add(worker1);
        workers.add(freelancer2);
        workers.add(worker2);
        workers.add(freelancer3);
        workers.add(worker3);

        // Созданный метод сортировки с помощью Comparator по полю name
        workers.sort(new WorkerNameComparator());
        System.out.println(workers);

        System.out.println("--------------------------------");

        // Созданный метод сортирови с помощью Comparator по полю Id
        workers.sort(new WorkerIdComparator());
        System.out.println(workers);

        // Импортирование и добавление в репозиторий рабочих, который поддерживает как Worker так и Freelancer.
        // С помощью метода showAllWorkers() в котором реализован Iterator, мы распечатываем содержание листа.
        WorkerRepository workerRepository = new WorkerRepository();

        workerRepository.addWorker(freelancer1);
        workerRepository.addWorker(freelancer2);
        workerRepository.addWorker(freelancer3);

        // Использование итератора для перебора элементов и последующего вывода в консоль.
        workerRepository.iterator().forEachRemaining(worker -> System.out.println(worker.toString()));

    }
}
