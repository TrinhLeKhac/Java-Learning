package designpattern;

// Create class to control redirect to class
// Moving codebase to technical support

interface Animal {
    void eat();
}

class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("When eating, dog gruz gruz...");
    }
}

class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("When eating, cat meox meox...");
    }
}

class Pig implements Animal {

    @Override
    public void eat() {
        System.out.println("When eating, pig hog hog...");
    }
}

class AnimalFactory {
    static Animal getAnimal(String type) {
        Animal animal = null;
        if (type.equalsIgnoreCase("Dog")) {
            animal = new Dog();
        } else if (type.equalsIgnoreCase("Cat")) {
            animal = new Cat();
        } else if (type.equalsIgnoreCase("Pig")) {
            animal = new Pig();
        }
        return animal;
    }
}

interface Human {
    void feedAnimal();
}

class Child implements Human {

    @Override
    public void feedAnimal() {
        System.out.println("Children doesn't know how to feed animal");
    }
}

class Adult implements Human {

    @Override
    public void feedAnimal() {
        System.out.println("Adult feed animal in the right way");
    }
}

class Elder implements Human {

    @Override
    public void feedAnimal() {
        System.out.println("Elder feed animal too much");
    }
}

class HumanFactory {
    static Human getHuman(String type) {
        Human human = null;
        if (type.equalsIgnoreCase("Children")) {
            human = new Child();
        } else if (type.equalsIgnoreCase("Adult")) {
            human = new Adult();
        } else if (type.equalsIgnoreCase("Elder")) {
            human = new Elder();
        }
        return human;
    }
}

abstract class AbstractFactory {
    abstract Animal getAnimal(String type);
    abstract Human getHuman(String type);
}

class AnimalFactoryV2 extends AbstractFactory {

    @Override
    Animal getAnimal(String type) {
        Animal animal = null;
        if (type.equalsIgnoreCase("Dog")) {
            animal = new Dog();
        } else if (type.equalsIgnoreCase("Cat")) {
            animal = new Cat();
        } else if (type.equalsIgnoreCase("Pig")) {
            animal = new Pig();
        }
        return animal;
    }

    @Override
    Human getHuman(String type) {
        return null;
    }
}

class HumanFactoryV2 extends AbstractFactory {

    @Override
    Animal getAnimal(String type) {
        return null;
    }

    @Override
    Human getHuman(String type) {
        Human human = null;
        if (type.equalsIgnoreCase("Child")) {
            human = new Child();
        } else if (type.equalsIgnoreCase("Adult")) {
            human = new Adult();
        } else if (type.equalsIgnoreCase("Elder")) {
            human = new Elder();
        }
        return human;
    }
}

class FactoryProducer {
    static AbstractFactory getFactory(String type) {
        AbstractFactory factory = null;
        if (type.equalsIgnoreCase("Human")) {
            factory = new HumanFactoryV2();
        } else if (type.equalsIgnoreCase("Animal")) {
            factory = new AnimalFactoryV2();
        }
        return factory;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {

        System.out.println("----------------Example 1: Factory Pattern for Animal-----------------------");
        Animal animal11 = AnimalFactory.getAnimal("Dog");
        animal11.eat();

        Animal animal12 = AnimalFactory.getAnimal("Cat");
        animal12.eat();

        Animal animal13 = AnimalFactory.getAnimal("Pig");
        animal13.eat();

        System.out.println("----------------Example 2: Abstract Factory Pattern for Animal and Human-----------------------");
        AbstractFactory animalFactory = FactoryProducer.getFactory("Animal");
        AbstractFactory humanFactory = FactoryProducer.getFactory("Human");

        Animal animal21 = animalFactory.getAnimal("Dog");
        animal21.eat();
        Animal animal22 = animalFactory.getAnimal("Cat");
        animal22.eat();
        Animal animal23 = animalFactory.getAnimal("Pig");
        animal23.eat();

        Human human21 = humanFactory.getHuman("Child");
        human21.feedAnimal();
        Human human22 = humanFactory.getHuman("Adult");
        human22.feedAnimal();
        Human human23 = humanFactory.getHuman("Elder");
        human23.feedAnimal();

    }
}
