package Task1;

class Clock implements Runnable {
    Timer timer;

    public Clock(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        while (true) {
            timer.clock();
        }
    }
}