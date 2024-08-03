package designpattern;

import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected Person person;  // observe this person
    public abstract void update(); // Update information from person
}

class Person {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}

class CEO extends Observer {
    public CEO(Person person) {
        this.person = person;
        this.person.attach(this);
    }

    @Override
    public void update() {
        if (this.person.getState().equalsIgnoreCase("Success")) {
            System.out.println("CEO pleased with manager and lead-programmer");
        } else {
            System.out.println("CEO didn't pleased with manager and lead-programmer");
        }
    }
}

class ManagerV2 extends Observer {
    public ManagerV2(Person person) {
        this.person = person;
        this.person.attach(this);
    }
    @Override
    public void update() {
        if (this.person.getState().equalsIgnoreCase("Success")) {
            System.out.println("Manager pleased with lead-programmer and programmer");
        } else {
            System.out.println("Manager didn't pleased with lead-programmer and programmer");
        }
    }
}

class LeadProgrammerV2 extends Observer {
    public LeadProgrammerV2(Person person) {
        this.person = person;
        this.person.attach(this);
    }
    @Override
    public void update() {
        if (this.person.getState().equalsIgnoreCase("Success")) {
            System.out.println("Lead-manager pleased with programmer");
        } else {
            System.out.println("Lead-programmer didn't pleased with programmer");
        }
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {

        // Create person
        Person person = new Person();

        // CEO, ManagerV2, LeadProgrammerV2 observer this person
        new CEO(person);
        new ManagerV2(person);
        new LeadProgrammerV2(person);

        System.out.println("---------------------------------------");
        System.out.println("The person has succeed with his project");
        person.setState("Success");

        System.out.println("---------------------------------------");
        System.out.println("The person has failed with his project");
        person.setState("Failed");
    }
}
