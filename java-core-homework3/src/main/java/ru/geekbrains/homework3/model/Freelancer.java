package ru.geekbrains.homework3.model;

/**
 * Создание потомка, где добавлено свое поле с почасовой зарплатой.
 */
public class Freelancer extends BaseWorker {

    private double hourlySalary;

    private Freelancer(int id, String name, double hourlySalary) {
        super(id, name);
        this.hourlySalary = hourlySalary;
    }

    /**
     * Реализация подсчета почасовой оплаты труда
     * @return количество зарплаты за месяц
     */
    @Override
    public double salaryCalculation() {
        return 20.8*8*hourlySalary;
    }

    /**
     * Метод создания рабочего - фрилансера
     * @param id рабочего
     * @param name имя
     * @param hourlySalary почасовая оплата труда
     * @return нового созданного сотрудника
     */
    public static Freelancer createFreelancer(int id, String name, double hourlySalary) {
        if(id < 0) {
            throw new IllegalArgumentException("Id рабочего не может быть отрицательным!");
        }
        if(name == null || name.length() < 3) {
            throw new IllegalArgumentException("Некорректный ввод имени рабочего");
        }
        return new Freelancer(id, name, hourlySalary);
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "\nFreelancer: " +
                "id= " + id +
                ", hourlySalary=" + hourlySalary +
                ", name='" + name + '\'';
    }
}
