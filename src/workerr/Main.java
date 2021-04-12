package workerr;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WorkerManagement ck = new WorkerManagement();
        while (true) {
            System.out.println("====================Worker Management Program====================");
            System.out.println("1. Add Worker");
            System.out.println("2. Up Salary");
            System.out.println("3. Down Salary");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = ck.checkInt();
            switch (choice) {
                case 1: {
                    ck.addWorker();
                    break;
                }
                case 2: {
                    ck.upSalary();
                    break;
                }
                case 3: {
                    ck.downSalary();
                    break;
                }
                case 4: {
                    ck.display();
                    break;
                }
                case 5: {
                    return;
                }

            }
        }
    }
}
