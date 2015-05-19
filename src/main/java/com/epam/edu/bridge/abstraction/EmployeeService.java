package com.epam.edu.bridge.abstraction;

import com.epam.edu.bridge.impl.DataAccessObject;
import com.epam.edu.Employee;

/**
 *
 * @author tmp
 */
public class EmployeeService extends BaseService<Employee>{

    public EmployeeService(DataAccessObject dao) {
        super(dao);
    }
    
    public Employee findEmployeeById(Long id) {
        return dao.find(Employee.class, id);
    }
    
    public Employee setManagerOfEmployee(Long employeeId, Long managerId) {
        Employee employee = dao.find(Employee.class, employeeId);
        Employee originalManager = employee.getManager();
        Employee manager = dao.find(Employee.class, managerId);
        employee.setManager(manager);
        dao.update(employee);
        return originalManager;
    }
}
