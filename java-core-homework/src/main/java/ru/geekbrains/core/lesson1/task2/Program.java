package ru.geekbrains.core.lesson1.task2;

import ru.geekbrains.core.lesson1.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {

    private final static Random random = new Random();

    public static void main(String[] args) throws SQLException, InterruptedException {

        Thread.sleep(20000);

        String url = "jdbc:mysql://employees-db:5001/";
        String user = "root";
        String password = "Password";

        // Подключение к БД
        Connection connection = DriverManager.getConnection(url, user, password);

        // Использование БД
        useDatabase(connection);
        System.out.println("Use database successfully");

        // Создание таблицы
        createTables(connection);
        System.out.println("Create tables successfully");

        int count = random.nextInt(5, 11);
        for (int i = 0; i < count; i++)
            isertData(connection, Employee.create());
        System.out.println("Insert data successfully");

        // Чтение данных
        Collection<Employee> employees = readData(connection);
        for (Employee employee : employees)
            System.out.println(employee);
        System.out.println("Read data successfully");

        // Закрытие соединения
        connection.close();
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE employeesDb";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    private static void isertData(Connection connection, Employee employee) throws SQLException {
        String insertSQL = "INSERT INTO users (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.executeUpdate();
        }
    }

    private static Collection<Employee> readData(Connection connection) throws SQLException {
        ArrayList<Employee> employeesList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                employeesList.add(new Employee(id, name, age));
            }
            return employeesList;
        }
    }

}
