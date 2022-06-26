package Task1;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        Thread clock = new Thread(new Clock(timer));
        Thread messenger = new Thread(new Messenger(timer));
        clock.start();
        messenger.start();
    }
}