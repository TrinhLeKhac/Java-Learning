package designpattern;

// Singleton
// private constructor
// private static instance (the only instance of class)
// public method getInstance()


// Eager Initialization Singleton
// Cons: create instance when it doesn't call method getInstance()
// Don't have handle exception

import stream.Serialization;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    private EagerInitializedSingleton() {}
    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}

// Static block initialization
class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;
    private StaticBlockSingleton() {}
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

// Lazy initialization
class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    private LazyInitializedSingleton() {}
    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

// Thread-safe Singleton V1
class ThreadSafeSingletonV1 {
    private static ThreadSafeSingletonV1 instance;
    private ThreadSafeSingletonV1() {}
    public static synchronized ThreadSafeSingletonV1 getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingletonV1();
        }
        return instance;
    }
}

// Thread-safe Singleton V2
class ThreadSafeSingletonV2 {
    private static ThreadSafeSingletonV2 instance;
    private ThreadSafeSingletonV2() {}
    public static ThreadSafeSingletonV2 getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonV2.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonV2();
                }
            }
        }
        return instance;
    }
}

// Singleton by static inner class
class BillPughSingleton {
    private BillPughSingleton() {}
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

class ReflectionSingletonTest {

    public void test() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;

        Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor: constructors) {
            constructor.setAccessible(true);
            instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
            break;
        }

        // Two different instance
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}

// Serializable Singleton
class SerializedSingleton implements Serializable {
    @Serial
    private static final long serialVersionUID = 111L;
    private SerializedSingleton() {}
    private static class SingletonHelper {
        private static final SerializedSingleton INSTANCE = new SerializedSingleton();
    }
    public static SerializedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

class SerializedSingletonTest {
    public void test() throws IOException, ClassNotFoundException {

        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("Hashcode of first instance is: " + instanceOne.hashCode());
        System.out.println("Hashcode of second instance is: " + instanceTwo.hashCode());
    }
}


public class Singleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("----------------Example 1: Eager Initialization Singleton-----------------------");
        EagerInitializedSingleton instanceExample10 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceExample11 = EagerInitializedSingleton.getInstance();

        // instanceExample10 and instanceExample11 will be the same instance
        System.out.println(instanceExample10.hashCode());
        System.out.println(instanceExample11.hashCode());

        System.out.println("----------------Example 2: Static Block Initialization Singleton-----------------------");
        StaticBlockSingleton instanceExample20 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton instanceExample21 = StaticBlockSingleton.getInstance();

        // instanceExample20 and instanceExample21 will be the same instance
        System.out.println(instanceExample20.hashCode());
        System.out.println(instanceExample21.hashCode());

        System.out.println("----------------Example 3: Lazy Initialization Singleton-----------------------");
        LazyInitializedSingleton instanceExample30 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceExample31 = LazyInitializedSingleton.getInstance();

        // instanceExample30 and instanceExample31 will be the same instance
        System.out.println(instanceExample30.hashCode());
        System.out.println(instanceExample31.hashCode());

        System.out.println("----------------Example 4: Thread Safe Initialization Singleton-----------------------");
        ThreadSafeSingletonV1 instanceExample40 = ThreadSafeSingletonV1.getInstance();
        ThreadSafeSingletonV1 instanceExample41 = ThreadSafeSingletonV1.getInstance();

        ThreadSafeSingletonV2 instanceExample42 = ThreadSafeSingletonV2.getInstance();
        ThreadSafeSingletonV2 instanceExample43 = ThreadSafeSingletonV2.getInstance();

        // instanceExample40 and instanceExample41 will be the same instance
        System.out.println(instanceExample40.hashCode());
        System.out.println(instanceExample41.hashCode());

        // instanceExample42 and instanceExample43 will be the same instance
        System.out.println(instanceExample42.hashCode());
        System.out.println(instanceExample43.hashCode());

        System.out.println("----------------Example 5: Bill Pugh Initialization Singleton-----------------------");
        BillPughSingleton instanceExample50 = BillPughSingleton.getInstance();
        BillPughSingleton instanceExample51 = BillPughSingleton.getInstance();

        // instanceExample50 and instanceExample51 will be the same instance
        System.out.println(instanceExample50.hashCode());
        System.out.println(instanceExample51.hashCode());

        System.out.println("----------------Example 5: Test Reflection break through rules of singleton-----------------------");
        ReflectionSingletonTest reflectionSingletonTest = new ReflectionSingletonTest();
        reflectionSingletonTest.test();

        System.out.println("----------------Example 6: Test Serialized singleton-----------------------");
        SerializedSingletonTest serializedSingletonTest = new SerializedSingletonTest();
        serializedSingletonTest.test();
    }
}
