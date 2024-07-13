package collection;

// Comparable Interface is used to order the objects of the user-defined class
// Its contains only one method named compareTo(Object)

// Method 1:
// implements Comparable interface in class need compare (overwrite compareTo method)
// using Collection.sort()
// cons: only compare by 1 criteria

// Method 2: Create PropertyComparator class implements Comparator
// using Collection.sort(instance, new PropertyComparator()) or instance.sort(new PropertyComparator())
// can compare by multiple criteria but too long


// Method 3(the best method): Using Comparator.comparing, Comparator.comparingInt,.. (Java 8)

import java.util.*;

class Purple implements Comparable<Purple>{
    int rollno;

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

    private String name;
    private int age;
    public Purple (int rollno, String name, int age){
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Purple purple) {
        return Integer.compare(this.age, purple.age);
    }
}

class AgeComparator implements Comparator<Purple> {
    @Override
    public int compare(Purple o1, Purple o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class NameComparator implements Comparator<Purple> {
    @Override
    public int compare(Purple o1, Purple o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class CompareExample {
    public static void main(String[] args) {

        List<Purple> purpleList = new ArrayList<>();

        purpleList.add(new Purple(101, "Jane", 23));
        purpleList.add(new Purple(102, "Jenny", 22));
        purpleList.add(new Purple(103, "Jack", 21));

        System.out.println("----------------Example 1: Comparing two elements using Comparable interface-----------------------");
        Collections.sort(purpleList);
        for (Purple p: purpleList) {
            System.out.println(p.rollno + " " + p.getName() + " " + p.getAge());
        }

        System.out.println("----------------Example 2: Comparing two element using Comparator interface-----------------------");
        purpleList.sort(new NameComparator());
        for (Purple p: purpleList) {
            System.out.println(p.rollno + " " + p.getName() + " " + p.getAge());
        }
        System.out.println('\n');
        purpleList.sort(new AgeComparator());
        for (Purple p: purpleList) {
            System.out.println(p.rollno + " " + p.getName() + " " + p.getAge());
        }

        System.out.println("----------------Example 3: Comparing two element using Comparator interface in Java 8-----------------------");
        purpleList.sort(Comparator.comparing(Purple::getName));
        for (Purple p: purpleList) {
            System.out.println(p.rollno + " " + p.getName() + " " + p.getAge());
        }
        System.out.println('\n');
        purpleList.sort(Comparator.comparingInt(Purple::getAge));
        for (Purple p: purpleList) {
            System.out.println(p.rollno + " " + p.getName() + " " + p.getAge());
        }
        System.out.println('\n');
    }

}
