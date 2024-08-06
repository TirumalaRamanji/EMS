import java.io.*;
import java.util.*;

public class EmployeeManager {
    private static final String FILE_PATH = "employees.txt";

    public void addEmployee(Employee employee) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(employee.toString());
            writer.newLine();
        }
    }

    public void removeEmployee(int id) throws IOException {
        List<Employee> employees = listEmployees();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employees) {
                if (employee.getId() != id) {
                    writer.write(employee.toString());
                    writer.newLine();
                }
            }
        }
    }

    public List<Employee> listEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) { // Updated length check
                    employees.add(new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        data[4],
                        data[5] // Read gender
                    ));
                }
            }
        }
        return employees;
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. List Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Location: ");
                        String location = scanner.nextLine();
                        System.out.print("Enter Gender: "); // New input
                        String gender = scanner.nextLine(); // New input
                        manager.addEmployee(new Employee(id, name, department, salary, location, gender));
                        System.out.println("Employee added.");
                        break;
                    case 2:
                        System.out.print("Enter ID to remove: ");
                        int removeId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        manager.removeEmployee(removeId);
                        System.out.println("Employee removed.");
                        break;
                    case 3:
                        List<Employee> employees = manager.listEmployees();
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                        break;
                    case 4:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
