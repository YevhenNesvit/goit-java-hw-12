package Task1;

class Timer {
    static final Object MONITOR = new Object();
    int seconds = 0;

    public void clock() {
        synchronized (MONITOR) {
            System.out.println(seconds);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            seconds++;
            while (seconds % 5 == 0) {
                try {
                    System.out.println(seconds);
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
            }
            MONITOR.notifyAll();
        }
    }

    public void messenger() {
        synchronized (MONITOR) {
            while (seconds % 5 != 0) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
            }
            seconds++;
            System.out.println("Прошло 5 секунд");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            MONITOR.notifyAll();
        }
    }
}