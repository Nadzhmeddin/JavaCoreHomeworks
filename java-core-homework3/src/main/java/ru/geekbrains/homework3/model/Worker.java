package ru.geekbrains.homework3.model;

/**
 * Создание второго наследника, где добавляется свое поле фиксировання месячная оплата труда.
 */
public class Worker extends BaseWorker {

    private double monthlySalary;

    public Worker(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    /**
     * Реализация метода подсчета зарплаты с фиксированным ежемесячным фондом оплаты труда
     * @return ежемесячную зарплату
     */
    @Override
    public double salaryCalculation() {
        return monthlySalary;
    }

    /**
     * Реализация метода для создания рабочего
     * @param id рабочего
     * @param name имя
     * @param monthlySalary ежемесячная фиксированная оплата
     * @return нового созданного сотрудника
     */
    public static Worker createFreelancer(int id, String name, double monthlySalary) {
        if(id < 0) {
            throw new IllegalArgumentException("Id рабочего не может быть отрицательным!");
        }
        if(name == null || name.length() < 3) {
            throw new IllegalArgumentException("Некорректный ввод имени рабочего");
        }
        return new Worker(id, name, monthlySalary);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "\nWorker: " +
                "id=" + id +
                ", monthlySalary=" + monthlySalary +
                ", name='" + name + '\'';
    }
}
