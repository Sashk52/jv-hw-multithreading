import org.apache.log4j.Logger;

public class MyRunnableClass implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnableClass.class);
    private final Counter counter;

    public MyRunnableClass(Counter counter) {
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

