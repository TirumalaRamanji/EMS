public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String location; 
    private String gender; // New field

    public Employee(int id, String name, String department, double salary, String location, String gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.location = location;
        this.gender = gender; // Initialize new field
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getGender() { return gender; } // Getter
    public void setGender(String gender) { this.gender = gender; } // Setter

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary + "," + location + "," + gender;
    }
}
