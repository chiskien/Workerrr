package workerr;

/**
 *
 * @author Admin
 */
public class History extends Worker {
    private String status;
    private String date;

    public History() {
    }

    public History(String status, String date, String code, String name, String worklocation, int age, int salary) {
        super(code, name, worklocation, age, salary);
        this.status = status;
        this.date = date;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getWorklocation() {
        return worklocation;
    }

    @Override
    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
