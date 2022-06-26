package Task2;

import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz(Runnable fizz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                fizz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Runnable buzz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 == 0) {
                buzz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz(Runnable fizzBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 15 == 0) {
                fizzBuzz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}