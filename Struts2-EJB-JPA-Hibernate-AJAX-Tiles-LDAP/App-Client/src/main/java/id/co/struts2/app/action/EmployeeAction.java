package id.co.struts2.app.action;

import id.co.struts2.app.entity.Employee;
import id.co.struts2.app.bean.EmployeeRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.opensymphony.xwork2.ActionSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmployeeAction extends ActionSupport {

    EmployeeRemote employee = lookupEmployeeBean();
    HttpServletRequest request = ServletActionContext.getRequest();

    private String id;
    private String name;
    private String age;

    public EmployeeRemote lookupEmployeeBean() {
        try {
            InitialContext ic = new InitialContext();
            return (EmployeeRemote) ic.lookup("ejb:/App-EJB-1.0-SNAPSHOT//EmployeeBean!id.co.struts2.app.bean.EmployeeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    //show employees
    public String showEmployees() {
        List<Employee> emp = employee.showEmployees();
        request.setAttribute("emp", emp);
        return "showEmployees";
    }

    //add employee
    public String addEmployee() {
        employee.addEmployee(name, age);
        return "addEmployee";
    }

    //update employee
    public String updateEmployee() {
        employee.updateEmployee(id, name, age);
        return "updateEmployee";
    }

    //get employee by id
    public String getEmployeeById() {
        Employee emp = employee.getEmployeeById(id);
        request.setAttribute("emp", emp);
        return "getEmployeeById";
    }

    //delete employee 
    public String deleteEmployee() {
        employee.deleteEmployee(id);
        return "deleteEmployee";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
