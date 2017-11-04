package id.co.struts2.app.bean;

import javax.ejb.Remote;
import java.util.List;
import id.co.struts2.app.entity.Employee;

@Remote
public interface EmployeeRemote {
    boolean createEmployee(Employee employee);
    
    void addEmployee(String name, String age);
    
    Employee getEmployeeById(String id);
    
    List<Employee> showEmployees();
    
    void updateEmployee(String id, String name, String age);
    
    void deleteEmployee(String id);
            
}
