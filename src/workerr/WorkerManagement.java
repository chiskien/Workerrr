package workerr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class WorkerManagement {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Worker> arraylist = new ArrayList<>();
    ArrayList<History> historylist = new ArrayList<>();
    Worker worker = new Worker();

    public String checkString() {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Must not be Empty!!");
                System.out.print("Enter again: ");
            } else {
                break;
            }
        }
        return input;
    }

    public int checkInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input < 0) {
                    System.out.println("Must greater than 0 ");
                    System.out.print("Enter again: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("must be digit!! ");
                System.out.print("Enter again: ");
            }
        }
        return input;
    }

    public boolean checkCodeExist(String code) {
        for (Worker worker : arraylist) {
            if (worker.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicate(String name, String worklocation, int age,
            int salary) {
        for (Worker worker : arraylist) {
            if (worker.getName().equalsIgnoreCase(name) && worker.getWorklocation().equalsIgnoreCase(worklocation)
                    && age == worker.getAge() && salary == worker.getSalary()) {
                return true;
            }
        }
        return false;
    }

    public void addWorker() {
        System.out.println("------------------Add Worker------------------");
        System.out.print("Enter Code: ");
        String code = checkString();
        if (checkCodeExist(code)) {
            System.err.println("This code has exist!!");
            return;
        } else {
            System.out.print("Enter Name: ");
            String name = checkString();
            System.out.print("Enter Worklocation: ");
            String worklocation = checkString();
            System.out.print("Enter Age: ");
            int age = checkInt();
            System.out.print("Enter Salary: ");
            int Salary = checkInt();
            if (checkDuplicate(name, worklocation, age, Salary)) {
                System.err.println("Duplicate");
                return;
            } else {
                arraylist.add(new Worker(code, name, worklocation, age, Salary));
                System.err.println("Add Successfully!!!");

            }
        }
    }

    public void upSalary() {
        System.out.print("Enter code: ");
        String code = checkString();
        if (checkCodeExist(code)) {
            for (int i = 0; i < arraylist.size(); i++) {
                if (arraylist.get(i).getCode().equalsIgnoreCase(code)) {
                    Worker workerUpdate = arraylist.get(i);
                    int salaryNow = workerUpdate.getSalary();
                    int salaryUpdate;

                    System.out.print("Enter Salary Update: ");
                    salaryUpdate = checkInt();
                    salaryNow = salaryNow + salaryUpdate;
                    historylist.add(new History("UP", getCurrentDate(), workerUpdate.getCode(),
                            workerUpdate.getName(), workerUpdate.getWorklocation(),
                            workerUpdate.getAge(), salaryNow));
                    workerUpdate.setSalary(salaryNow);
                }
            }
            System.err.println("Update Successfully");
        } else {
            System.err.println("Not found worker");
        }
    }

    public void downSalary() {
        System.out.print("Enter code: ");
        String code = checkString();
        if (checkCodeExist(code)) {
            for (int i = 0; i < arraylist.size(); i++) {
                if (arraylist.get(i).getCode().equalsIgnoreCase(code)) {
                    Worker workerUpdate = arraylist.get(i);
                    int salaryNow = workerUpdate.getSalary();
                    System.out.println("Enter Salary: ");
                    int salaryUpdate = checkInt();
                    salaryNow = salaryNow - salaryUpdate;
                    historylist.add(new History("DOWN", getCurrentDate(), workerUpdate.getCode(),
                            workerUpdate.getName(), workerUpdate.getWorklocation(),
                            workerUpdate.getAge(), salaryNow));
                    workerUpdate.setSalary(salaryNow);
                }
            }
            System.err.println("Update Successfully");
        } else {
            System.err.println("Not found worker");
            return;
        }
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public void display() {
        if (historylist.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(historylist, new CodeComparator());
        //print history from first to last list
        for (History history : historylist) {
            System.out.printf("%-10s%-20s%-20s%-20d%-20s%-20s\n", history.getCode(),
                    history.getName(), history.getAge(), history.getSalary(),
                    history.getStatus(), history.getDate());
        }
    }
}
