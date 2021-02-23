import org.apache.log4j.Logger;

public class MyThreadClass extends Thread {
    private static final Logger logger = Logger.getLogger(MyThreadClass.class);
    private final Counter counter;

    public MyThreadClass(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.count();
            logger.info(Thread.currentThread().getName() + " counter = " + counter.getCount());
        }
    }
}
