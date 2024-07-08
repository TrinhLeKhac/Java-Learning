package thread;

public class ThreadExample {

    private static class Customer {

        private int amount;

        public Customer(int amount) {
            this.amount = amount;
        }

        public synchronized void withdraw(int amount) {
            System.out.println("going to withdraw...");
            while (this.amount < amount) {
                System.out.println("less balance; waiting for deposit...");
                try {
                    wait();  // release lock of object(resource)
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.amount -= amount;
            System.out.println("withdraw completed.");
            System.out.println("the amount after withdraw is: " + this.amount);
        }

        public synchronized void deposit(int amount) {
            System.out.println("going to deposit...");
            this.amount += amount;
            System.out.println("deposit completed.");
            System.out.println("the amount after deposit is: " + this.amount);
            notifyAll();
        }

        public synchronized int getAmount() {
            return this.amount;
        }
    }

    public static void main(String[] args) {
        Customer c = new Customer(10000);
        new Thread() {
            @Override
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.deposit(2000);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                c.deposit(5000);
            }
        }.start();
//        System.out.println("final amount of balance is: " + c.getAmount()); // still wrong
    }

}
