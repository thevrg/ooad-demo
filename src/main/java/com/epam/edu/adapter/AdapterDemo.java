package com.epam.edu.adapter;

import com.epam.edu.Employee;
import com.epam.edu.observer.ColourChangerActionListener;
import com.epam.edu.observer.ObserverDemo;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author tmp
 */
public class AdapterDemo {

    private JFrame frame = new JFrame("Adapter Demo");
    private EmployeeListTableModelAdapter employeeListAdapter = new EmployeeListTableModelAdapter();
    private JTable table = new JTable(employeeListAdapter);
    private JScrollPane scroll = new JScrollPane(table);

    public void init() {
		//panel.doLayout();

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(10000, 123L, "Bela"));
        empList.add(new Employee(100000, 124L, "Jozsi"));
        empList.add(new Employee(1000000, 126L, "Feri"));
        empList.add(new Employee(10000, 127L, "Dori"));

        employeeListAdapter.setEmployeeList(empList);
        
        frame.getContentPane().add(scroll);
        frame.pack();

    }

    public static void main(String[] args) {
        AdapterDemo demo = new AdapterDemo();
        demo.init();
        demo.show();
    }

    public void show() {
        frame.setVisible(true);
    }

}
