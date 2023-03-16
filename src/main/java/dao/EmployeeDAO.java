package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Добавление объекта
    void create(Employee employee);

    // Получение объекта по id
    Employee getById(int id);

    // Получение всех объектов
    List<Employee> getAllEmployees();

    // Изменение объекта
    void updateEmployee(Employee employee);

    // Удаление объекта
    void deleteEmployee(Employee employee);
}
