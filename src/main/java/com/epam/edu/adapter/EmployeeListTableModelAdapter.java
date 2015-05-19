
package com.epam.edu.adapter;

import com.epam.edu.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tmp
 */
public class EmployeeListTableModelAdapter extends AbstractTableModel{

    List<Employee>employeeList = new ArrayList<>();
    
    private final static String[] columnNames = {"ID", "Name", "Salary"};

    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee emp = employeeList.get(rowIndex);
        switch (columnIndex) {
            case 0: return emp.getId();
            case 1: return emp.getName();
            case 2: return emp.getSalary();
            default:
                throw new RuntimeException("Neven happens, columnIndex: " + columnIndex);
        } 
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        fireTableDataChanged();
    }
}
