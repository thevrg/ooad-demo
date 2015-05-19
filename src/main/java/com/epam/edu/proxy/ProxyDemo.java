package com.epam.edu.proxy;

import com.epam.edu.Employee;
import com.epam.edu.bridge.impl.DataAccessObject;
import com.epam.edu.bridge.impl.InMemoryDAO;
import com.epam.edu.bridge.impl.JPADAO;

/**
 *
 * @author tmp
 */
public class ProxyDemo {
    public static void main(String[] args) {
        
        
        Runnable myRunnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        
        LazyInitializerDAOProxy p1 = new LazyInitializerDAOProxy(InMemoryDAO.class);
        
        DataAccessObject proxy = new ProxyFactory().createPerformanceMeasurerProxy(p1, DataAccessObject.class);
        
        
        Runnable runnableProxy = new ProxyFactory().createPerformanceMeasurerProxy(myRunnable, Runnable.class);
        
        proxy.persist(new Employee(123, 1000L, "Bela"));
        Employee emp = proxy.find(Employee.class, 1000L);
        
        System.out.println("emp: " + emp);
        
        runnableProxy.run();
      
        System.out.println("proxy: " + proxy.getClass());
        System.out.println("proxy: " + runnableProxy.getClass());
    }
}
