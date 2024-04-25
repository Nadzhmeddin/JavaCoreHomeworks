package ru.geekbrains.homework3.model;

/**
 * Создание базового абстрактного класса Worker
 */
public abstract class BaseWorker {

    protected int id;
    protected String name;

    protected BaseWorker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Абстрактный метод расчета зарплаты;
     */
    public abstract double salaryCalculation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("Id не может быть отрицательным!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() < 3) {
            throw new IllegalArgumentException("Некорректный ввод имени");
        }
        this.name = name;
    }
}
