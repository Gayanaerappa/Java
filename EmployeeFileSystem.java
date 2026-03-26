import java.io.*;
import java.util.Scanner;

public class EmployeeFileSystem {

    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    searchEmployee(sc);
                    break;
                case 0:
                    System.out.println("👋 Exit");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    // Add Employee
    public static void addEmployee(Scanner sc) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String data = id + "," + name + "," + salary;
            bw.write(data);
            bw.newLine();

            bw.close();
            System.out.println("✅ Employee Added Successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error writing file!");
        }
    }

    // View Employees
    public static void viewEmployees() {
        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n--- Employee Records ---");

            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                System.out.println("ID: " + emp[0] +
                                   " | Name: " + emp[1] +
                                   " | Salary: " + emp[2]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("❌ Error reading file!");
        }
    }

    // Search Employee
    public static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        String searchId = sc.nextLine();

        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                if (emp[0].equals(searchId)) {
                    System.out.println("✅ Found: ID: " + emp[0] +
                                       " | Name: " + emp[1] +
                                       " | Salary: " + emp[2]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("❌ Employee Not Found!");
            }

            br.close();

        } catch (IOException e) {
            System.out.println("❌ Error reading file!");
        }
    }
}
