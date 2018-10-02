package dao;

import entities.Employee;
import java.util.ArrayList;

public interface IEmployee {

    public boolean insert(Employee employee);

    public boolean update(Employee employee);

    public boolean delete(String employeeID);

    public ArrayList<Employee> getList();
}
