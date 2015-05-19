package com.epam.edu.bridge;

import com.epam.edu.Employee;
import com.epam.edu.bridge.abstraction.EmployeeService;
import com.epam.edu.bridge.impl.DataAccessObject;
import com.epam.edu.bridge.impl.InMemoryDAO;

/**
 *
 * @author tmp
 */
public class BridgeDemo {
    public static void main(String[] args) {
//        EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();
        DataAccessObject dao = new InMemoryDAO();
        Employee emp1 = new Employee();
        emp1.setId(123L);
        dao.persist(emp1);
        Employee emp2 = new Employee();
        emp2.setId(124L);
        dao.persist(emp2);
        
        
        EmployeeService emp = new EmployeeService(dao);
        emp.setManagerOfEmployee(123L, 124L);
        
        System.out.println(dao.find(Employee.class, 123L));
        
    }
}
