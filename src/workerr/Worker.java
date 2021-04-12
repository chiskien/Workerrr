package workerr;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Worker {
    protected String code,name,worklocation;
    protected int age, salary;
    public Worker() {
    }

    public Worker(String code, String name, String worklocation, int age, int salary) {
        this.code = code;
        this.name = name;
        this.worklocation = worklocation;
        this.age = age;
        this.salary = salary;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorklocation() {
        return worklocation;
    }

    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
