package id.co.struts2.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name="Employee")
public class Employee implements Serializable {
    
    @SequenceGenerator(name="EmployeeSequence",sequenceName="EmployeeSequence")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="EmployeeSequence")
    @Column(name="id")
    private long id;
    
    @Column(name="name", length=100)
    private String name;
    
    @Column(name="age")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
