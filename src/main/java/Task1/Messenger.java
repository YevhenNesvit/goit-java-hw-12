package Task1;

public class Messenger implements Runnable {
    Timer timer;

    public Messenger(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        while (true) {
            timer.messenger();
        }
    }
}
