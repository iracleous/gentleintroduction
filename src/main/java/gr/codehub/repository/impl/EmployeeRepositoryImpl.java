package gr.codehub.repository.impl;

import gr.codehub.model.Customer;
import gr.codehub.model.Employee;

public class EmployeeRepositoryImpl extends RepositoryImpl<Employee>{

    @Override
    public boolean update(int id, Employee employee) {

        try{
            Employee dbEmployee = read(id);
            dbEmployee.setAddress(employee.getAddress());
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
