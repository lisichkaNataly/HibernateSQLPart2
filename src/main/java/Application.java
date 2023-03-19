import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDao = new EmployeeDAOImpl();
        CityDAO cityDao = new CityDAOImpl();

        City city1 = new City("Moscow");
        cityDao.createCity(city1);


        //При запуске приложения обе таблицы - employee и city - пустые
        // добавляя город, мы не указываем его id - он устанавливается БД самостоятельно
        //Значит, мы можем получить его id, чтобы этот город (как объект) - указать как поле класса Employee
        City cityForEmployee = cityDao.getByIdCity(1);

        //Создаем объект employee
        Employee employee = new Employee("Darya", "Androva", "woman", 25);

        //Заполняем поле city в объекте employee
        employee.setCityId(cityForEmployee);

        //Добавим employee в БД
        employeeDao.create(employee);

        //Удалим cityForEmployee
        cityDao.deleteCity(cityForEmployee);
    }
}
