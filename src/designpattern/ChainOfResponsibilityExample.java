package designpattern;

// Create chain of responsibility
abstract class Employee {
    static final int PROGRAMMER = 1;
    static final int LEAD_PROGRAMMER = 2;
    static final int MANAGER = 3;

    protected int authorityLevel;
    protected Employee nextEmployee;

    public void setNextEmployee(Employee nextEmployee) {
        this.nextEmployee = nextEmployee;
    }

    public void doWork(int authorityLevel, String message) {
        if (this.authorityLevel <= authorityLevel) {
            write(message);
        }
        if (nextEmployee != null) {
            this.nextEmployee.doWork(authorityLevel, message);
        }
    }

    abstract protected void write(String message);
}

class Programmer extends Employee {
    public Programmer(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Programmer:" + message);
    }
}

class LeadProgrammer extends Employee {
    public LeadProgrammer(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }
    @Override
    protected void write(String message) {
        System.out.println("Lead programmer: " + message);
    }
}

class Manager extends Employee {
    public Manager(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Manager: " + message);
    }
}


public class ChainOfResponsibilityExample {

    private static Employee getChainOfEmployees() {

        Employee programmer = new Programmer(Employee.PROGRAMMER);
        Employee leadProgrammer = new LeadProgrammer(Employee.LEAD_PROGRAMMER);
        Employee manager = new Manager(Employee.MANAGER);

        leadProgrammer.setNextEmployee(manager);
        programmer.setNextEmployee(leadProgrammer);

        return programmer;
    }

    public static void main(String[] args) {
        Employee employeeChain = getChainOfEmployees();
        System.out.println("---------------------------------------");
        employeeChain.doWork(Employee.PROGRAMMER, "This is a basic programming project");

        System.out.println("---------------------------------------");
        employeeChain.doWork(Employee.LEAD_PROGRAMMER, "This is a hard programming project");

        System.out.println("---------------------------------------");
        employeeChain.doWork(Employee.MANAGER, "This is a manager task");
    }
}
